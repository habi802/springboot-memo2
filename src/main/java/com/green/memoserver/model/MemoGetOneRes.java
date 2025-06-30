package com.green.memoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MemoGetOneRes {
    @JsonProperty("memoId")
    private int id;
    private String title;
    @JsonProperty("ctnts")
    private String content;
    private String createdAt;
}
