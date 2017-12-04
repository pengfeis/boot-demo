package com.pengfeis.spr.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ThumbnailRequest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    String objectId;
    String imageUrl;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public static ThumbnailRequest fromJSON(String json)
            throws IOException {
        return OBJECT_MAPPER.readValue(json, ThumbnailRequest.class);
    }

    public static void main(String[] args) {
        ThumbnailRequest request = new ThumbnailRequest();
        request.setImageUrl("~/img/10001.jpg");
        request.setObjectId("10001");
        try {
            String json = OBJECT_MAPPER.writeValueAsString(request);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


}
