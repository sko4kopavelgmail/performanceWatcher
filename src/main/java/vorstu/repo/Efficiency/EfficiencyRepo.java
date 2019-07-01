package vorstu.repo.Efficiency;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Efficiency.Efficiency;
import vorstu.model.Report.Department;
import vorstu.model.Report.Faculty;

import java.util.List;

public interface EfficiencyRepo extends JpaRepository<Efficiency, Long> {
}
