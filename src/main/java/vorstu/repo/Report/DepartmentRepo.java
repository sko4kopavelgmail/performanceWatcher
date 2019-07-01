package vorstu.repo.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import vorstu.model.Report.Department;
import vorstu.model.Report.Faculty;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
    List<Department> findAllByName(String name);

    List<Department> findAllByFaculty(Faculty faculty);

    List<Department> findAllById(Long id);
}
