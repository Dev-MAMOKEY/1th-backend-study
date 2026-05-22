package com.task.RestAPIServer.dto;

import java.time.LocalDateTime;

public class PostRequest {

    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
