package gdg.hackathon.backend.service;

import gdg.hackathon.backend.dto.NoticeDto;
import gdg.hackathon.backend.dto.NoticeSaveRequestDto;
import gdg.hackathon.backend.entity.Board;
import gdg.hackathon.backend.entity.Notice;
import gdg.hackathon.backend.repository.BoardRepository;
import gdg.hackathon.backend.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public NoticeDto findById(Long id) {
        Notice notice = noticeRepository.findById(id)
                .orElseThrow();
        return notice.toDto();
    }

    public List<NoticeDto> getNoticesByFilters(String category, List<String> tags) {
        return noticeRepository.findTop10NoticesByCategoryAndTags(category, tags).stream()
                    .map(Notice::toDto)
                    .collect(Collectors.toList());
    }

    public List<NoticeDto> getRecommendedNotices(Map<String, String> preferences) {
        // ai 서버에 연관도 분석 요청 넣음
        return null;
    }
}
