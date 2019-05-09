package vorstu.repo.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Report.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long>{

}
