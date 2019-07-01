package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Report.Faculty;
import vorstu.model.Report.Report;
import vorstu.repo.Report.ReportRepo;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportRepo;

    public List<Report> findAll(){
        return reportRepo.findAll();
    }

    public void save(Report report){
        reportRepo.save(report);
    }

    public List<Report> findAllByFaculty(Faculty faculty){
        return reportRepo.findByFaculty(faculty);
    }
}
