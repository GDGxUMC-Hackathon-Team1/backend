package gdg.hackathon.backend.service;

import gdg.hackathon.backend.dto.NoticeDto;
import gdg.hackathon.backend.dto.NoticeSaveRequestDto;
import gdg.hackathon.backend.entity.Board;
import gdg.hackathon.backend.entity.Notice;
import gdg.hackathon.backend.repository.BoardRepository;
import gdg.hackathon.backend.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final BoardRepository boardRepository;
    public NoticeDto save(NoticeSaveRequestDto request) {
        // todo
        // Board 찾기
        Board board = boardRepository.findByTitle(request.getBoard());

        // Notice 엔티티 생성 및 저장
        Notice notice = Notice.builder()
                .title(request.getTitle())
                .url(request.getUrl())
                .content(request.getContent())
                .hits(request.getHits())
                .createdAt(request.getCreatedAt())
                .updatedAt(null)
                .board(board)
                .build();
        // AI 서버에 태그를 요청함
        // todo

        // AI 서버에 요약을 요청함
        // todo

        // 모두 모아서 저장
        Notice saved = noticeRepository.save(notice);
        return saved.toDto();
    }
}
