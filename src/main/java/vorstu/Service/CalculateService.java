package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Efficiency.parts.EducationActivity;
import vorstu.model.Efficiency.parts.InternationalActivity;
import vorstu.model.Efficiency.parts.ResearchActivity;
import vorstu.repo.Efficiency.EfficiencyRepo;
import vorstu.repo.Efficiency.parts.EducationActivityRepo;
import vorstu.repo.Efficiency.parts.InternationalActivityRepo;
import vorstu.repo.Efficiency.parts.ResearchActivityRepo;

import java.util.Map;

@Service
public class CalculateService {

    @Autowired
    private EducationActivityRepo educationActivityRepo;

    @Autowired
    private InternationalActivityRepo internationalActivityRepo;

    @Autowired
    private ResearchActivityRepo researchActivityRepo;

    @Autowired
    private EfficiencyRepo efficiencyRepo;

    public EducationActivity calculateEducationActivity(Map<String, String> form) {
        EducationActivity educationActivity = new EducationActivity();



        return educationActivity;
    }

    public InternationalActivity calculateInternationalActivity(Map<String, String> form) {
        InternationalActivity internationalActivity = new InternationalActivity();



        return internationalActivity;
    }

    public ResearchActivity calculateResearchActivity(Map<String, String> form) {
        ResearchActivity researchActivity = new ResearchActivity();


        return researchActivity;
    }

    public void calculateEfficiency(Map<String, String> form){

    }
}
