package com.handsof.backend.domain.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Getter
public class Slack {
    protected Slack(){};
    private String userId;
    private Workspace workspace;
    private String destinationId;
    private String destinationName;
    private String message;
    private Date createdAt;

    @Builder
    public Slack(String userId, Workspace workspace, String destinationId, String destinationName, String message, Date createdAt) {
        this.userId = userId;
        this.workspace = workspace;
        this.destinationId = destinationId;
        this.destinationName = destinationName;
        this.message = message;
        this.createdAt = createdAt;
    }
}
