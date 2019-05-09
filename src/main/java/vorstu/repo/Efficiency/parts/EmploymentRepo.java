package vorstu.repo.Efficiency.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Efficiency.parts.Employment;

public interface EmploymentRepo extends JpaRepository<Employment, Long> {
}
