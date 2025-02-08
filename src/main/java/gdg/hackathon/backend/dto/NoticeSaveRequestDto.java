package gdg.hackathon.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeSaveRequestDto {
    String title;
    String content;
    int hits;
    String board;
    String url;
    LocalDateTime createdAt;
}
