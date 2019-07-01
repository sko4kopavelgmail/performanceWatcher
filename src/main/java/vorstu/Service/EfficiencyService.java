package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Efficiency.Efficiency;
import vorstu.model.Efficiency.parts.EducationActivity;
import vorstu.model.Efficiency.parts.InternationalActivity;
import vorstu.model.Efficiency.parts.ResearchActivity;
import vorstu.model.Report.Report;
import vorstu.repo.Efficiency.EfficiencyRepo;

import java.util.List;

@Service
public class EfficiencyService {

    @Autowired
    private EfficiencyRepo efficiencyRepo;

    public void save(Efficiency efficiency) {
        efficiencyRepo.save(efficiency);
    }

    public List<Efficiency> findAll() {
        return efficiencyRepo.findAll();
    }

    public Efficiency getAverageEfficiency(List<Report> departmentReports) {
        Efficiency facultyEfficiency = new Efficiency();

        facultyEfficiency.setResearchActivity(new ResearchActivity());
        facultyEfficiency.setInternationalActivity(new InternationalActivity());
        facultyEfficiency.setEducationActivity(new EducationActivity());
        for (Report report : departmentReports) {
            facultyEfficiency.getEducationActivity().setMean(report.getEfficiency().getEducationActivity().getMean()
                    + facultyEfficiency.getEducationActivity().getMean());
            facultyEfficiency.getEducationActivity().setName(report.getEfficiency().getEducationActivity().getName());
            facultyEfficiency.getEducationActivity().setShortName(report.getEfficiency().getEducationActivity().getShortName());

            facultyEfficiency.getInternationalActivity().setMean(facultyEfficiency.getInternationalActivity().getMean()
                    + report.getEfficiency().getInternationalActivity().getMean());
            facultyEfficiency.getInternationalActivity().setName(report.getEfficiency().getInternationalActivity().getName());
            facultyEfficiency.getInternationalActivity().setShortName(report.getEfficiency().getInternationalActivity().getShortName());

            facultyEfficiency.getResearchActivity().setMean(facultyEfficiency.getResearchActivity().getMean()
                    + report.getEfficiency().getResearchActivity().getMean());
            facultyEfficiency.getResearchActivity().setName(report.getEfficiency().getResearchActivity().getName());
            facultyEfficiency.getResearchActivity().setShortName(report.getEfficiency().getResearchActivity().getShortName());
        }
        facultyEfficiency.getResearchActivity().setMean(facultyEfficiency.getResearchActivity().getMean() / departmentReports.size());
        facultyEfficiency.getInternationalActivity().setMean(facultyEfficiency.getInternationalActivity().getMean() / departmentReports.size());
        facultyEfficiency.getEducationActivity().setMean(facultyEfficiency.getEducationActivity().getMean() / departmentReports.size());

        return facultyEfficiency;
    }

}
