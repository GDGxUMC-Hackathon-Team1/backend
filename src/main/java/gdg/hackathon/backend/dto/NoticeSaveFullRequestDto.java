package gdg.hackathon.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeSaveFullRequestDto {
    private String board;
    private String title;
    private String url;
    private String content;
    private int hits;
    private String createdAt;
    private String tag;
    private String summary;
    private String schedule;
}
