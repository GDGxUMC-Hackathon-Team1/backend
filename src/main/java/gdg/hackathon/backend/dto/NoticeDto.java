package gdg.hackathon.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeDto {
    Long id;
    String title;
    String url;
    String content;
    String summary;
    Long boardId;
    int hits;
    private String tag;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String schedule;

}
