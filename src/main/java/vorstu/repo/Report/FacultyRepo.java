package vorstu.repo.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Report.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Long> {
}
