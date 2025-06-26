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
    public String insertMemo(@RequestBody MemoPostReq req) {
        log.info("req={}", req);
        int result = memoService.save(req);
        return result == 1 ? "저장 성공" : "저장 실패!";
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
    public String updateMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        return "수정 완료";
    }

    // Delete
    @DeleteMapping
    public String deleteMemo(@RequestParam(name = "memo_id") int memoId) {
        log.info("memoId={}", memoId);
        int result = memoService.deleteById(memoId);
        return result == 1 ? "삭제 성공" : "삭제 실패!";
    }
}
