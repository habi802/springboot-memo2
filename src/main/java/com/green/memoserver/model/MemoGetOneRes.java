package com.green.memoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MemoGetOneRes {
    private int id;
    private String title;
    @JsonProperty("ctnts")
    private String content;
    @JsonProperty("created_at")
    private String createdAt;
}
