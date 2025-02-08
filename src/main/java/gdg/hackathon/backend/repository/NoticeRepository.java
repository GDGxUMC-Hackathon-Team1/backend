package gdg.hackathon.backend.repository;

import gdg.hackathon.backend.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
