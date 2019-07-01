package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Report.Faculty;
import vorstu.repo.Report.FacultyRepo;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public List<Faculty> findAll(){
        return facultyRepo.findAll();
    }

}
