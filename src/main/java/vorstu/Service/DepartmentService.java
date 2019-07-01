package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Report.Department;
import vorstu.model.Report.Faculty;
import vorstu.repo.Report.DepartmentRepo;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    public Department getOneByName(String name) {
        return departmentRepo.findAllByName(name).get(0);
    }

    public Department getOneById(Long id){
        return departmentRepo.findAllById(id).get(0);
    }

    public List<Department> findAllByFaculty(Faculty faculty) {
        return departmentRepo.findAllByFaculty(faculty);
    }

    public Object findAll() {
        return departmentRepo.findAll();
    }
}
