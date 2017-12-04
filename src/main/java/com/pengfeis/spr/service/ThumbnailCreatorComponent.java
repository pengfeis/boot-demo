package com.pengfeis.spr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author supengfei
 */
@Component
public class ThumbnailCreatorComponent {

    public String createThumbnail(String url) {
        return url;
    }

    @Autowired
    protected JmsTemplate defaultJmsTemplate;
}
