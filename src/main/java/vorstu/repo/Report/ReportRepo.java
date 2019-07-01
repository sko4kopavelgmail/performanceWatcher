package vorstu.repo.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Report.Faculty;
import vorstu.model.Report.Report;

import java.util.List;

public interface ReportRepo extends JpaRepository<Report, Long> {
    List<Report> findByFaculty(Faculty faculty);
}
