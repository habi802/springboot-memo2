package com.green.memoserver;

import com.green.memoserver.config.model.ResultResponse;
import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
// 공통 URL
@RequestMapping("/api/memo")
public class MemoController {
    private final MemoService memoService;

    // Create
//    @PostMapping
//    public int insertMemo(@RequestBody MemoPostReq req) {
//        log.info("req={}", req);
//        return memoService.save(req);
//    }
    @PostMapping
    public ResultResponse<Integer> insertMemo(@RequestBody MemoPostReq req) {
        log.info("req={}", req);
        int result = memoService.save(req);
        return new ResultResponse<>("삽입 성공", result);
    }

    // Read
//    @GetMapping
//    public List<MemoGetRes> selectMemo(@ModelAttribute MemoGetReq req) {
////    public String selectMemo(@RequestParam(name = "search_text", required = false) String searchText,
////                             @RequestParam(required = false) Integer page) {
////        log.info("search={}, page={}", searchText, page);
////        MemoGetReq req = MemoGetReq.builder()
////                                    .searchText(searchText)
////                                    .page(page)
////                                    .build();
//        //return memoService.findAll(searchText, page);
//        log.info("req={}", req);
//        return memoService.findAll(req);
//    }
    @GetMapping
    public ResultResponse<List<MemoGetRes>> selectMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        List<MemoGetRes> result = memoService.findAll(req);
        String message = String.format("rows: %d", result.size());
        return new ResultResponse<>(message, result);
    }

    // Read
//    @GetMapping("/{memoId}")
//    public MemoGetOneRes selectMemoDetail(@PathVariable("memoId") int memoId) {
//        log.info("memoId={}", memoId);
//        return memoService.findById(memoId);
//    }
    @GetMapping("/{memoId}")
    public ResultResponse<MemoGetOneRes> selectMemoDetail(@PathVariable("memoId") int memoId) {
        log.info("memoId={}", memoId);
        MemoGetOneRes result = memoService.findById(memoId);
        return new ResultResponse<>("조회 성공", result);
    }

    // Update
//    @PutMapping
//    public int updateMemo(@RequestBody MemoPutReq req) {
//        log.info("req={}", req);
//        return memoService.modify(req);
//    }
    @PutMapping
    public ResultResponse<Integer> updateMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        int result = memoService.modify(req);
        return new ResultResponse<>("수정 성공", result);
    }

    // Delete
//    @DeleteMapping
//    public int deleteMemo(@RequestParam(name = "memo_id") int memoId) {
//        log.info("memoId={}", memoId);
//        return memoService.deleteById(memoId);
//    }
    @DeleteMapping
    public ResultResponse<Integer> deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        int result = memoService.deleteById(memoId);
        return new ResultResponse<>("삭제 성공", result);
    }
}
