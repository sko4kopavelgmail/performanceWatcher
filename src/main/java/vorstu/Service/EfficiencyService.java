package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Efficiency.Efficiency;
import vorstu.model.Efficiency.parts.EducationActivity;
import vorstu.model.Efficiency.parts.InternationalActivity;
import vorstu.model.Efficiency.parts.ResearchActivity;
import vorstu.model.Report.Faculty;
import vorstu.model.Report.Report;
import vorstu.repo.Efficiency.EfficiencyRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
            facultyEfficiency.getEducationActivity().setMinMean(report.getEfficiency().getEducationActivity().getMinMean());

            facultyEfficiency.getInternationalActivity().setMean(facultyEfficiency.getInternationalActivity().getMean()
                    + report.getEfficiency().getInternationalActivity().getMean());
            facultyEfficiency.getInternationalActivity().setName(report.getEfficiency().getInternationalActivity().getName());
            facultyEfficiency.getInternationalActivity().setShortName(report.getEfficiency().getInternationalActivity().getShortName());
            facultyEfficiency.getInternationalActivity().setMinMean(report.getEfficiency().getInternationalActivity().getMinMean());

            facultyEfficiency.getResearchActivity().setMean(facultyEfficiency.getResearchActivity().getMean()
                    + report.getEfficiency().getResearchActivity().getMean());
            facultyEfficiency.getResearchActivity().setName(report.getEfficiency().getResearchActivity().getName());
            facultyEfficiency.getResearchActivity().setShortName(report.getEfficiency().getResearchActivity().getShortName());
            facultyEfficiency.getResearchActivity().setMinMean(report.getEfficiency().getResearchActivity().getMinMean());

        }
        facultyEfficiency.getResearchActivity().setMean(facultyEfficiency.getResearchActivity().getMean() / departmentReports.size());
        facultyEfficiency.getInternationalActivity().setMean(facultyEfficiency.getInternationalActivity().getMean() / departmentReports.size());
        facultyEfficiency.getEducationActivity().setMean(facultyEfficiency.getEducationActivity().getMean() / departmentReports.size());

        return facultyEfficiency;
    }

    public Efficiency getUniEfficiency(List<Efficiency> efficiencies) {
        Efficiency efficiency = new Efficiency();

        efficiency.setResearchActivity(new ResearchActivity());
        efficiency.setInternationalActivity(new InternationalActivity());
        efficiency.setEducationActivity(new EducationActivity());

        for (Efficiency uniEff : efficiencies) {
            efficiency.getEducationActivity().setMean(uniEff.getEducationActivity().getMean()
                    + efficiency.getEducationActivity().getMean());
            efficiency.getEducationActivity().setName(uniEff.getEducationActivity().getName());
            efficiency.getEducationActivity().setShortName(uniEff.getEducationActivity().getShortName());

            efficiency.getInternationalActivity().setMean(efficiency.getInternationalActivity().getMean()
                    + uniEff.getInternationalActivity().getMean());
            efficiency.getInternationalActivity().setName(uniEff.getInternationalActivity().getName());
            efficiency.getInternationalActivity().setShortName(uniEff.getInternationalActivity().getShortName());

            efficiency.getResearchActivity().setMean(efficiency.getResearchActivity().getMean()
                    + uniEff.getResearchActivity().getMean());
            efficiency.getResearchActivity().setName(uniEff.getResearchActivity().getName());
            efficiency.getResearchActivity().setShortName(uniEff.getResearchActivity().getShortName());
        }

        efficiency.getResearchActivity().setMean(efficiency.getResearchActivity().getMean() / efficiencies.size());
        efficiency.getInternationalActivity().setMean(efficiency.getInternationalActivity().getMean() / efficiencies.size());
        efficiency.getEducationActivity().setMean(efficiency.getEducationActivity().getMean() / efficiencies.size());

        return efficiency;
    }

    public Double getFacultyScope(Efficiency efficiency) {
        Double d = 0.0;
        Double fine = 0.2;
        Double tmp;

        //E1
        tmp = efficiency.getEducationActivity().getMean() / efficiency.getEducationActivity().getMinMean();
        if (tmp < 1) {
            tmp = tmp - (tmp * (1 - fine *2));
        } else {
            tmp = tmp + (tmp * (1 - fine *2));
        }

        d += tmp;

        //E2
        tmp = efficiency.getResearchActivity().getMean()/efficiency.getResearchActivity().getMinMean();
        if (tmp < 1) {
            tmp = tmp - (tmp - (1 - fine *1.8));
        } else {
            tmp = tmp + (tmp * (1 - fine *1.8));
        }

        d += tmp;

        //E3
        tmp = efficiency.getInternationalActivity().getMean()/efficiency.getInternationalActivity().getMinMean();
        if (tmp < 1) {
            tmp = tmp - (tmp - (1 - fine *1.6));
        } else {
            tmp = tmp + (tmp * (1 - fine *1.6));
        }

        d += tmp;

        return d;
    }
}
