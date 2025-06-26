package com.green.memoserver;

import com.green.memoserver.model.MemoGetOneRes;
import com.green.memoserver.model.MemoGetReq;
import com.green.memoserver.model.MemoGetRes;
import com.green.memoserver.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoMapper memoMapper;

    public int save(MemoPostReq p) {
        return memoMapper.save(p);
    }

    public List<MemoGetRes> findAll(MemoGetReq p) {
        return memoMapper.findAll(p);
    }

    public MemoGetOneRes findById(int id) {
        return memoMapper.findById(id);
    }

    public int deleteById(int id) {
        return memoMapper.deleteById(id);
    }
}
