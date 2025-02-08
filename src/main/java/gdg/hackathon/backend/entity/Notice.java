package gdg.hackathon.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String url;

    private String content;

    private int hits;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String summary;

    @JoinColumn(name = "board_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Board board;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoticeTag> noticeTags = new ArrayList<>();
}
