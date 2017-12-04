package com.pengfeis.spr.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ThumbnailResult {

    public ThumbnailRequest getThumbnailRequest() {
        return thumbnailRequest;
    }

    public void setThumbnailRequest(ThumbnailRequest thumbnailRequest) {
        this.thumbnailRequest = thumbnailRequest;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    private ThumbnailRequest thumbnailRequest;

    private String thumbnailUrl;

    public ThumbnailResult(ThumbnailRequest thumbnailRequest, String thumbnailUrl) {
        this.thumbnailRequest = thumbnailRequest;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String toJSON() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }
}
