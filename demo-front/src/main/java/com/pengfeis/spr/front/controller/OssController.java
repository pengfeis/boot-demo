package com.pengfeis.spr.front.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.google.zxing.WriterException;
import com.pengfeis.spr.front.utils.QrUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@RestController
@RequestMapping("oss/")
public class OssController {


    private String accessKeyId = "accKey";

    private String accessKeySecret = "accSec";

    private String endpoint = "ep";


    private String bucketPath = "bucketPath";

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file") MultipartFile multipartFile, HttpServletResponse response, HttpServletRequest request) {

        File file = null;
        File qrFile = null;
        try {
            file = convert2File(multipartFile);

            String url = this.upload2Oss(file);

            if (StringUtils.isNotBlank(url)) {
                log.info("上传成功url: {}", url);

                String orignFileName = multipartFile.getOriginalFilename();

                qrFile = new File("./qr-" + orignFileName + ".png");

                QrUtils.createQRImage(qrFile, bucketPath + url, 400, "png");

                String qrUrl = this.upload2Oss(qrFile);

                return bucketPath + qrUrl;
            }
        } catch (IOException e) {
            log.error(e.getLocalizedMessage(), e);
        } catch (WriterException e) {
            log.error(e.getLocalizedMessage(), e);
        } finally {
            FileUtils.deleteQuietly(file);
            FileUtils.deleteQuietly(qrFile);
        }

        return "Error";
    }

    private File convert2File(MultipartFile file) throws IOException {
        File target = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(target);
        fos.write(file.getBytes());
        fos.close();
        return target;
    }


    private String upload2Oss(File file) {


        ThreadLocalRandom random = ThreadLocalRandom.current();
        ;
        String uuid = new UUID(random.nextLong(), random.nextLong()).toString().replace("-", "");

        String key = "os/" + uuid + "-" + file.getName();

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        ossClient.putObject(new PutObjectRequest("pengfeis007", key, file));

        // 关闭OSSClient。
        ossClient.shutdown();

        log.info("上传oss key: {}", key);

        return key;
    }
}
