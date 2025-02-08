package gdg.hackathon.backend.repository;

import gdg.hackathon.backend.entity.Notice;
import gdg.hackathon.backend.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findTop10ByBoard_Title(String category);

    List<Notice> findTop10ByTagAndBoard_Title(Tag tag, String category);

    List<Notice> findTop10ByTag(Tag tags);

    // category(게시판 제목)과 tags(태그 리스트) 중 하나라도 일치하는 Notice 검색
    @Query("SELECT n FROM Notice n " +
            "WHERE (:category IS NULL OR n.board.title = :category) " +
            "AND (:tags IS NULL OR n.tag.name IN :tags)" +
            "ORDER BY n.createdAt DESC")
    List<Notice> findTop10NoticesByCategoryAndTags(@Param("category") String category,
                                              @Param("tags") List<String> tags);
}
