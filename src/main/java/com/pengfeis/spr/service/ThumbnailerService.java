package com.pengfeis.spr.service;

import com.pengfeis.spr.domain.ThumbnailRequest;
import com.pengfeis.spr.domain.ThumbnailResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import java.io.IOException;

/**
 * @author supengfei
 */
@Service
public class ThumbnailerService {

    private Logger log = Logger.getLogger(ThumbnailerService.class);

    public ThumbnailCreatorComponent getThumbnailCreator() {
        return thumbnailCreator;
    }

    public void setThumbnailCreator(ThumbnailCreatorComponent thumbnailCreator) {
        this.thumbnailCreator = thumbnailCreator;
    }

    public NotificationComponent getNotification() {
        return notification;
    }

    public void setNotification(NotificationComponent notification) {
        this.notification = notification;
    }

    @Autowired
    private ThumbnailCreatorComponent thumbnailCreator;

    @Autowired
    private NotificationComponent notification;

    @JmsListener(destination = "mysqs-demo-order")
    public void createThumbnail(String requestJSON) throws JMSException {
        log.info("Received " + requestJSON);
        try {
            ThumbnailRequest request=ThumbnailRequest.fromJSON(requestJSON);
            String thumbnailUrl= thumbnailCreator.createThumbnail(request.getImageUrl());
            notification.thumbnailComplete(new ThumbnailResult(request,thumbnailUrl));
        } catch (IOException ex) {
            log.error("Encountered error while parsing message.",ex);
            throw new JMSException("Encountered error while parsing message.");
        }
    }


}
