package gdg.hackathon.backend.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class BoardDto {
    private Long id;
    private String title;
    private String url;
    private List<Long> noticeIds;
}
