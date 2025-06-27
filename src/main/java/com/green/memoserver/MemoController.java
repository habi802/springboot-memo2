package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
// 공통 URL
@RequestMapping("/api/memo")
public class MemoController {
    private final MemoService memoService;

    // Create
    @PostMapping
    public int insertMemo(@RequestBody MemoPostReq req) {
        log.info("req={}", req);
        return memoService.save(req);
    }

    // Read
    @GetMapping
    public List<MemoGetRes> selectMemo(@ModelAttribute MemoGetReq req) {
//    public String selectMemo(@RequestParam(name = "search_text", required = false) String searchText,
//                             @RequestParam(required = false) Integer page) {
//        log.info("search={}, page={}", searchText, page);
//        MemoGetReq req = MemoGetReq.builder()
//                                    .searchText(searchText)
//                                    .page(page)
//                                    .build();
        //return memoService.findAll(searchText, page);
        log.info("req={}", req);
        return memoService.findAll(req);
    }

    // Read
    @GetMapping("/{memoId}")
    public MemoGetOneRes selectMemoDetail(@PathVariable("memoId") int memoId) {
        log.info("memoId={}", memoId);
        return memoService.findById(memoId);
    }

    // Update
    @PutMapping
    public int updateMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        return memoService.modify(req);
    }

    // Delete
    @DeleteMapping
    public int deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        return memoService.deleteById(memoId);
    }
}
