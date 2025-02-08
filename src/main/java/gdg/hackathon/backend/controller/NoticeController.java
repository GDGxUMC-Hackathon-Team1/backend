package gdg.hackathon.backend.controller;


import gdg.hackathon.backend.dto.NoticeDto;
import gdg.hackathon.backend.dto.NoticeSaveFullRequestDto;
import gdg.hackathon.backend.dto.NoticeSaveRequestDto;
import gdg.hackathon.backend.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
@CrossOrigin
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<Object> saveNotice(
        @RequestBody NoticeSaveRequestDto request
    ) {
        NoticeDto notice = noticeService.save(request);
        return ResponseEntity.ok(notice.getId());
    }

    @PostMapping("/full")
    public ResponseEntity<Object> saveFullNotice(
        @RequestBody NoticeSaveFullRequestDto request
    ) {
        NoticeDto notice = noticeService.save(request);
        return ResponseEntity.ok(notice.getId());

    }

    @GetMapping
    public ResponseEntity<List<NoticeDto>> getNotices(
        @RequestParam(required = false) String category,
        @RequestParam(required = false) List<String> tags
    ) {
        List<NoticeDto> notices = noticeService.getNoticesByFilters(category, tags);
        return ResponseEntity.ok(notices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticeDto> getNotice(
        @PathVariable("id") Long id
    ) {
        NoticeDto notice = noticeService.findById(id);
        return ResponseEntity.ok(notice);
    }

    @PostMapping("/recommended")
    public ResponseEntity<List<NoticeDto>> getRecommendedNotices(
        @RequestBody Map<String, String> preferences
    ) {
        List<NoticeDto> noticeDtos = noticeService.getRecommendedNotices(preferences);
        return ResponseEntity.ok(noticeDtos);
    }


}
