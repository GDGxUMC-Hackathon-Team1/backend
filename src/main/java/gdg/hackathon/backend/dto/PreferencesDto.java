package gdg.hackathon.backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreferencesDto {
    private Long id;
    private String key;
    private String value;
}
