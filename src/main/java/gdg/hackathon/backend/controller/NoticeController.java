package gdg.hackathon.backend.controller;


import gdg.hackathon.backend.dto.NoticeDto;
import gdg.hackathon.backend.dto.NoticeSaveRequestDto;
import gdg.hackathon.backend.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notice")
public class NoticeController {
    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<Object> saveNotice(NoticeSaveRequestDto request) {
        NoticeDto notice = noticeService.save(request);
        return ResponseEntity.ok(notice.getId());
    }
}
