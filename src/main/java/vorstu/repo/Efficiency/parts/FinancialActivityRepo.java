package vorstu.repo.Efficiency.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Efficiency.parts.FinancialActivity;

public interface FinancialActivityRepo extends JpaRepository<FinancialActivity, Long> {
}
