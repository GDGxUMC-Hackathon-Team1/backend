package gdg.hackathon.backend.entity;

import gdg.hackathon.backend.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int hits;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @JoinColumn(name = "board_id")
    @ManyToOne
    private Board board;

    @JoinColumn(name = "tag_id")
    @ManyToOne
    private Tag tag;

    private String schedule;


//    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL)
//    @Builder.Default
//    private List<NoticeTag> noticeTags = new ArrayList<>();

    public NoticeDto toDto() {
        return NoticeDto.builder()
                .id(this.id)
                .title(this.title)
                .url(this.url)
//                .content(this.content)
                .hits(this.hits)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .summary(this.summary)
                .boardId(this.board != null ? this.board.getId() : null)
                .tag(this.tag.getName())
                .schedule(this.schedule)
                .build();
    }
}
