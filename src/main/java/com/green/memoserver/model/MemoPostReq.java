package com.green.memoserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemoPostReq {
    private String title;
    private String ctnts;
}
