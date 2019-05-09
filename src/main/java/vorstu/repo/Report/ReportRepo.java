package vorstu.repo.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Report.Report;

public interface ReportRepo extends JpaRepository<Report, Long> {
}
