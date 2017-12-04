package com.pengfeis.spr.service;

import com.pengfeis.spr.domain.ThumbnailResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NotificationComponent {


    @Autowired
    protected JmsTemplate defaultJmsTemplate;

    public void thumbnailComplete(ThumbnailResult result) throws IOException {
        System.out.println(result.toJSON());
        defaultJmsTemplate.convertAndSend("thumbnail_results", result.toJSON());
    }

}
