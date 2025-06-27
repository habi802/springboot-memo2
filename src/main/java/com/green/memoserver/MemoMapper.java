package com.green.memoserver;

import com.green.memoserver.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemoMapper {
    int save(MemoPostReq p);
    List<MemoGetRes> findAll(MemoGetReq p);
    MemoGetOneRes findById(int id);
    int modify(MemoPutReq p);
    int deleteById(int id);
}
