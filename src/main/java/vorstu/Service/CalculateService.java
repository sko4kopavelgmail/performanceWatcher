package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Efficiency.Efficiency;
import vorstu.model.Efficiency.parts.*;
import vorstu.model.Efficiency.parts.Index.Index;
import vorstu.model.Report.Department;
import vorstu.model.Report.Report;
import vorstu.repo.Efficiency.IndexRepo;
import vorstu.repo.Efficiency.parts.EducationActivityRepo;
import vorstu.repo.Efficiency.parts.InternationalActivityRepo;
import vorstu.repo.Efficiency.parts.ResearchActivityRepo;

import java.util.Map;

@Service
public class CalculateService {

    private Double P;

    private Double N;

    private Double R;

    private Double S;

    private Double SS;

    private Double VV;

    @Autowired
    private EducationActivityRepo educationActivityRepo;

    @Autowired
    private InternationalActivityRepo internationalActivityRepo;

    @Autowired
    private ResearchActivityRepo researchActivityRepo;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EfficiencyService efficiencyService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private IndexRepo indexRepo;

    public EducationActivity calculateEducationActivity(Map<String, String> form) {
        EducationActivity educationActivity = new EducationActivity();

        //Min mean
        Double min = getDoubleFromString(form.get("educationMinMean"));
        educationActivity.setMinMean(min);

        //1.1
        Double _2410118 = getDoubleFromString(form.get("24118b"));
        Double _2410218 = getDoubleFromString(form.get("24118s"));
        Double _2410119 = getDoubleFromString(form.get("24119b"));
        Double _2410219 = getDoubleFromString(form.get("24119s"));
        Double _2410129 = getDoubleFromString(form.get("24129b"));
        Double _2410229 = getDoubleFromString(form.get("24129s"));

        Double _2410130 = getDoubleFromString(form.get("24130b"));
        Double _2410230 = getDoubleFromString(form.get("24130s"));
        Double _2410120 = getDoubleFromString(form.get("24120b"));
        Double _2410220 = getDoubleFromString(form.get("24120s"));
        Double _2410121 = getDoubleFromString(form.get("24121b"));
        Double _2410221 = getDoubleFromString(form.get("24121s"));

        Double _2410122 = getDoubleFromString(form.get("24122b"));
        Double _2410222 = getDoubleFromString(form.get("24122s"));

        Double mean = _2410129 * (_2410118 - _2410119);
        mean += _2410229 * (_2410218 - _2410219);
        mean += _2410130 * (_2410120 - _2410121);
        mean += _2410230 * (_2410220 - _2410221);
        mean += 100 * _2410122;
        mean += 100 * _2410222;
        mean /= ((_2410118 - _2410119 + _2410120 - _2410121 + _2410122) + (_2410218 - _2410219 + _2410220 - _2410221 + _2410222));

        educationActivity.addIndex(getIndex(mean, "1.1", Constants._11, Constants._ball));

        //1.2

        mean = _2410129 * (_2410118 - _2410119);
        mean += _2410229 * (_2410218 - _2410219);
        mean += _2410130 * (_2410120 - _2410121);
        mean += _2410230 * (_2410220 - _2410221);
        mean /= ((_2410118 - _2410119 + _2410120 - _2410121 + _2410122) + (_2410218 - _2410219 + _2410220 - _2410221 + _2410222));

        educationActivity.addIndex(getIndex(mean, "1.2", Constants._12, Constants._ball));

        //1.3
        Double _2410131 = getDoubleFromString(form.get("24131b"));
        Double _2410231 = getDoubleFromString(form.get("24131s"));
        Double _2410132 = getDoubleFromString(form.get("24132b"));
        Double _2410232 = getDoubleFromString(form.get("24132s"));

        mean = _2410131 * _2410119;
        mean += _2410231 * _2410219;
        mean += _2410132 * _2410121;
        mean += _2410232 * _2410221;
        mean /= _2410119 + _2410121 + _2410219 + _2410221;
        educationActivity.addIndex(getIndex(mean, "1.3", Constants._13, Constants._ball));

        //1.4
        Double _2410125 = getDoubleFromString(form.get("24125b"));
        Double _2410225 = getDoubleFromString(form.get("24125s"));
        Double _2410126 = getDoubleFromString(form.get("24126b"));
        Double _2410226 = getDoubleFromString(form.get("24126s"));
        Double _2410127 = getDoubleFromString(form.get("24127b"));
        Double _2410227 = getDoubleFromString(form.get("24127s"));
        Double _2410128 = getDoubleFromString(form.get("24128b"));
        Double _2410228 = getDoubleFromString(form.get("24128s"));

        mean = 0.0;
        if (_2410118 + _2410120 != 0) {
            mean += getMin(_2410125, _2410126, _2410127, _2410128);
        }
        if (_2410218 + _2410220 != 0) {
            mean += getMin(_2410225, _2410226, _2410227, _2410228);
        }
        int x = 0;
        if (_2410118 + _2410120 != 0) x++;
        if (_2410218 + _2410220 != 0) x++;
        mean /= x;
        educationActivity.addIndex(getIndex(mean, "1.4", Constants._14, Constants._ball));

        //1.5
        Double _2410123 = getDoubleFromString(form.get("24123b"));
        Double _2410223 = getDoubleFromString(form.get("24123s"));
        mean = _2410123 + _2410223;
        educationActivity.addIndex(getIndex(mean, "1.5", Constants._15, Constants._person));

        //1.6
        Double _2410124 = getDoubleFromString(form.get("24124b"));
        Double _2410224 = getDoubleFromString(form.get("24124s"));
        mean = _2410124 + _2410224;
        educationActivity.addIndex(getIndex(mean, "1.6", Constants._16, Constants._person));

        //1.7
        Double _2410110 = getDoubleFromString(form.get("24110b"));
        Double _2410210 = getDoubleFromString(form.get("24110s"));
        mean = _2410110 + _2410210;
        educationActivity.addIndex(getIndex(mean, "1.7", Constants._17, Constants._person));

        //1.8
        Double _2410105 = getDoubleFromString(form.get("2415b"));
        Double _2410205 = getDoubleFromString(form.get("2415s"));
        Double numerator = _2410110 + _2410210;
        Double denominator = _2410105 + _2410205;
        mean = numerator / denominator;
        educationActivity.addIndex(getIndex(mean, "1.8", Constants._18, Constants._percent));

        //1.9
        Double _21077 = getDoubleFromString(form.get("21077"));
        Double _21078 = getDoubleFromString(form.get("21078"));
        Double _21079 = getDoubleFromString(form.get("21079"));
        mean = (_21077 + 0.25 * _21078 + 0.1 * _21079) / S;
        mean *= 100;
        educationActivity.addIndex(getIndex(mean, "1.9", Constants._19, Constants._percent));

        //1.10
        Double _21057 = getDoubleFromString(form.get("21057"));
        Double _21058 = getDoubleFromString(form.get("21058"));
        Double _21059 = getDoubleFromString(form.get("21059"));

        Double _21067 = getDoubleFromString(form.get("21067"));
        Double _21068 = getDoubleFromString(form.get("21068"));
        Double _21069 = getDoubleFromString(form.get("21069"));

        Double _21087 = getDoubleFromString(form.get("21087"));
        Double _21088 = getDoubleFromString(form.get("21088"));
        Double _21089 = getDoubleFromString(form.get("21089"));

        Double _21097 = getDoubleFromString(form.get("21097"));
        Double _21098 = getDoubleFromString(form.get("21098"));
        Double _21099 = getDoubleFromString(form.get("21099"));

        Double _211007 = getDoubleFromString(form.get("211007"));
        Double _211008 = getDoubleFromString(form.get("211008"));
        Double _211009 = getDoubleFromString(form.get("211009"));

        numerator = (_21077 + 0.25 * _21078 + 0.1 * _21079);
        numerator += (_21087 + 0.25 * _21088 + 0.1 * _21089);
        numerator += (_21097 + 0.25 * _21098 + 0.1 * _21099);
        numerator += (_211007 + 0.25 * _211008 + 0.1 * _211009);

        denominator = numerator;
        denominator += (_21057 + 0.25 * _21058 + 0.1 * _21059);
        denominator += (_21067 + 0.25 * _21068 + 0.1 * _21069);
        denominator *= 100;
        mean = numerator / denominator;
        educationActivity.addIndex(getIndex(mean, "1.10", Constants._110, Constants._percent));

        //1.11
        Double _241035 = getDoubleFromString(form.get("241035"));
        Double _2410312 = getDoubleFromString(form.get("2410312"));
        Double _2444 = getDoubleFromString(form.get("2444"));
        Double _2446 = getDoubleFromString(form.get("2446"));
        mean = _241035 - _2410312 + _2444 - _2446;
        mean /= _241035 + _2444;
        mean *= 100;
        educationActivity.addIndex(getIndex(mean, "1.11", Constants._111, Constants._percent));

        //1.12
        Double _2420312 = getDoubleFromString(form.get("2420312"));
        Double _2420318 = getDoubleFromString(form.get("2420318"));

        Double _2450312 = getDoubleFromString(form.get("2450312"));
        Double _2450314 = getDoubleFromString(form.get("2450314"));

        Double _2510111 = getDoubleFromString(form.get("2510111"));
        Double _2510118 = getDoubleFromString(form.get("2510118"));

        Double _2510211 = getDoubleFromString(form.get("2510211"));
        Double _2510218 = getDoubleFromString(form.get("2510218"));

        Double _2510311 = getDoubleFromString(form.get("2510311"));
        Double _2510318 = getDoubleFromString(form.get("2510318"));

        numerator = _2420312 - _2420318 + _2450312 - _2450314;
        numerator += _2510111 - _2510118;
        numerator += _2510211 - _2510218;
        numerator += _2510311 - _2510318;

        denominator = _2420312 + _2450312 + _2510111 + _2510211 + _2510311;

        mean = numerator / denominator;
        mean *= 100;
        educationActivity.addIndex(getIndex(mean, "1.12", Constants._112, Constants._percent));

        //1.13
        Double _210806 = getDoubleFromString(form.get("210806"));
        Double _210906 = getDoubleFromString(form.get("210906"));
        Double _211006 = getDoubleFromString(form.get("211006"));

        mean = _210806 + _210906 + _211006;
        mean /= S;
        mean *= 100;
        educationActivity.addIndex(getIndex(mean, "1.13", Constants._113, Constants._person));

        //1.14
        Double _260103 = getDoubleFromString(form.get("260103"));
        Double _260105 = getDoubleFromString(form.get("260105"));

        mean = _260103 - _260105;
        mean /= _260103;
        mean *= 100;
        educationActivity.addIndex(getIndex(mean, "1.14", Constants._114, Constants._percent));

        //1.15
        Double _2420417E = getDoubleFromString(form.get("2420417E"));
        Double _2420412E = getDoubleFromString(form.get("2420412E"));
        Double _2450412E = getDoubleFromString(form.get("2450412E"));
        mean = _2420417E / (_2420412E + _2450412E);
        mean *= 100;
        educationActivity.addIndex(getIndex(mean, "1.15", Constants._115, Constants._percent));

        for (int i = 0; i < educationActivity.getIndices().size(); i++) {
            educationActivity.getIndices().get(i).setEducationActivity(educationActivity);
        }


        //MEAN
        Double _2410134 = getDoubleFromString(form.get("2410134"));
        Double _2410234 = getDoubleFromString(form.get("2410234"));
        Double _2410135 = getDoubleFromString(form.get("2410135"));
        Double _2410235 = getDoubleFromString(form.get("2410235"));

        numerator = (_2410129 * (_2410118 - _2410119)) + (_2410229 * (_2410218 - _2410219));
        numerator += (_2410131 * _2410119) + (_2410231 + _2410219);
        numerator += (_2410122 * 100) + (_2410222 * 100);
        numerator += (_2410130 * (_2410120 - _2410121)) + (_2410230 * (_2410220 - _2410221));
        numerator += (_2410132 * _2410121) + (_2410232 * _2410221);
        denominator = (_2410118 + _2410120 + _2410122) + (_2410218 + _2410220 + _2410222);

        Double newNumerator = (_2410129 * (_2410118 - _2410119)) + (_2410229 * (_2410218 - _2410219));
        newNumerator += (_2410131 * _2410119) + (_2410231 + _2410219);
        newNumerator += (_2410122 * 100) + (_2410222 * 100);
        newNumerator += (_2410134 * (_2410120 - _2410121)) + (_2410234 * (_2410220 - _2410221));
        newNumerator += (_2410135 * _2410121) + (_2410235 * _2410221);

        mean = ((numerator / denominator) + (newNumerator / denominator)) / 2;

        educationActivity.setMean(mean);

        return educationActivity;
    }

    private Index getIndex(Double mean, String shortName, String name, String unit) {
        Index index = new Index();
        index.setMean(mean);
        index.setShortName(shortName);
        index.setName(name);
        index.setUnit(unit);

        return index;
    }

    private Double getMin(Double f, Double f1, Double f2, Double f3) {
        if (f == 0) {
            f = Double.MAX_VALUE;
        }
        if (f1 == 0) {
            f1 = Double.MAX_VALUE;
        }
        if (f2 == 0) {
            f2 = Double.MAX_VALUE;
        }
        if (f3 == 0) {
            f3 = Double.MAX_VALUE;
        }
        if (f < f1 && f < f2 && f < f3) return f;
        if (f1 < f && f1 < f2 && f1 < f3) return f1;
        if (f2 < f && f2 < f1 && f2 < f3) return f2;
        if (f3 < f && f3 < f2 && f3 < f1) return f3;
        return 0.0;
    }

    private Double getDoubleFromString(String s) {
        if ("".equals(s)){
            return 0.0;
        }
        return Double.parseDouble(s);
    }

    public InternationalActivity calculateInternationalActivity(Map<String, String> form) {
        InternationalActivity internationalActivity = new InternationalActivity();
        Double mean, numerator, denumerator;

        //Min mean
        Double min = getDoubleFromString(form.get("internationalMinMean"));
        internationalActivity.setMinMean(min);

        //3.1
        Double _2470409O = getDoubleFromString(form.get("2470409O"));
        Double _2470409V = getDoubleFromString(form.get("2470409V"));
        Double _2470409Z = getDoubleFromString(form.get("2470409Z"));

        Double _2470709O = getDoubleFromString(form.get("2470709O"));
        Double _2470709V = getDoubleFromString(form.get("2470709V"));
        Double _2470709Z = getDoubleFromString(form.get("2470709Z"));

        Double _2470309ON = getDoubleFromString(form.get("2470309ON"));
        Double _2470309VN = getDoubleFromString(form.get("2470309VN"));
        Double _2470309ZN = getDoubleFromString(form.get("2470309ZN"));

        Double _2470609ON = getDoubleFromString(form.get("2470609ON"));
        Double _2470609VN = getDoubleFromString(form.get("2470609VN"));
        Double _2470609ZN = getDoubleFromString(form.get("2470609ZN"));

        mean = _2470409O + 0.25 * _2470409V + 0.1 * _2470409Z;
        mean += _2470709O + 0.25 * _2470709V + 0.1 * _2470709Z;
        mean += _2470309ON + 0.25 * _2470309VN + 0.1 * _2470309ZN;
        mean += _2470609ON + 0.25 * _2470609VN + 0.1 * _2470609ZN;
        mean /= SS;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.1", Constants._31, Constants._percent));

        //3.2
        Double _2470309OP = getDoubleFromString(form.get("2470309OP"));
        Double _2470309VP = getDoubleFromString(form.get("2470309VP"));
        Double _2470309ZP = getDoubleFromString(form.get("2470309ZP"));

        Double _2470609OP = getDoubleFromString(form.get("2470609OP"));
        Double _2470609VP = getDoubleFromString(form.get("2470609VP"));
        Double _2470609ZP = getDoubleFromString(form.get("2470609ZP"));

        mean = _2470309OP + 0.25 * _2470309VP + 0.1 * _2470309ZP;
        mean += _2470609OP + 0.25 * _2470609VP + 0.1 * _2470609ZP;
        mean /= SS;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.2", Constants._32, Constants._percent));

        //3.3
        Double _2470414O = getDoubleFromString(form.get("2470414O"));
        Double _2470414V = getDoubleFromString(form.get("2470414V"));
        Double _2470414Z = getDoubleFromString(form.get("2470414Z"));

        Double _2470714O = getDoubleFromString(form.get("2470714O"));
        Double _2470714V = getDoubleFromString(form.get("2470714V"));
        Double _2470714Z = getDoubleFromString(form.get("2470714Z"));

        Double _2470314O = getDoubleFromString(form.get("2470314O"));
        Double _2470314V = getDoubleFromString(form.get("2470314V"));
        Double _2470314Z = getDoubleFromString(form.get("2470314Z"));

        Double _2470614O = getDoubleFromString(form.get("2470614O"));
        Double _2470614V = getDoubleFromString(form.get("2470614V"));
        Double _2470614Z = getDoubleFromString(form.get("2470614Z"));

        mean = _2470414O + 0.25 * _2470414V + 0.1 * _2470414Z;
        mean += _2470714O + 0.25 * _2470714V + 0.1 * _2470714Z;
        mean += _2470314O + 0.25 * _2470314V + 0.1 * _2470314Z;
        mean += _2470614O + 0.25 * _2470614V + 0.1 * _2470614Z;
        mean /= VV;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.3", Constants._33, Constants._percent));

        //3.4
        mean = _2470414O + 0.25 * _2470414V + 0.1 * _2470414Z;
        mean += _2470714O + 0.25 * _2470714V + 0.1 * _2470714Z;
        mean += _2470309ON + 0.25 * _2470309VN + 0.1 * _2470309ZN;
        mean += _2470609ON + 0.25 * _2470609VN + 0.1 * _2470609ZN;
        mean /= VV;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.4", Constants._34, Constants._percent));

        //3.5
        mean = _2470414O + 0.25 * _2470414V + 0.1 * _2470414Z;
        mean += _2470714O + 0.25 * _2470714V + 0.1 * _2470714Z;
        mean += _2470309OP + 0.25 * _2470309VP + 0.1 * _2470309ZP;
        mean += _2470609OP + 0.25 * _2470609VP + 0.1 * _2470609ZP;
        mean /= VV;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.5", Constants._35, Constants._percent));

        //3.6
        Double _2480404 = getDoubleFromString(form.get("2480404"));
        Double _2480405 = getDoubleFromString(form.get("2480405"));
        Double _2420412 = getDoubleFromString(form.get("2420412"));
        Double _2450412 = getDoubleFromString(form.get("2450412"));//430103
        numerator = _2480404 + _2480405;
        denumerator = _2420412 + _2450412;
        mean = numerator / denumerator;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.6", Constants._36, Constants._percent));

        //3.7
        Double _2480410 = getDoubleFromString(form.get("2480410"));
        Double _2480411 = getDoubleFromString(form.get("2480411"));
        numerator = _2480410 + _2480411;
        mean = numerator / denumerator;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.7", Constants._37, Constants._un));

        //3.8
        Double _430103 = getDoubleFromString(form.get("430103"));
        Double _430107 = getDoubleFromString(form.get("430107"));
        Double _430303 = getDoubleFromString(form.get("430303"));
        Double _430307 = getDoubleFromString(form.get("430307"));
        Double _4110403 = getDoubleFromString(form.get("4110403"));
        Double _4110415 = getDoubleFromString(form.get("4110415"));
        Double _4120403 = getDoubleFromString(form.get("4120403"));
        Double _4120415 = getDoubleFromString(form.get("4120415"));
        numerator = _430103 + _430107 + _430303 + _430307;
        denumerator = _4110403 + _4110415 + _4120403 + _4120415;
        mean = numerator / denumerator;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.8", Constants._38, Constants._percent));

        //3.9
        Double _430106 = getDoubleFromString(form.get("430106"));
        Double _430110 = getDoubleFromString(form.get("430110"));
        Double _430306 = getDoubleFromString(form.get("430306"));
        Double _430310 = getDoubleFromString(form.get("430310"));
        mean = _430106 + _430110 + _430306 + _430310;
        internationalActivity.addIndex(getIndex(mean, "3.9", Constants._39, Constants._person));

        //3.10
        Double _2510114 = getDoubleFromString(form.get("2510114"));
        Double _2510116 = getDoubleFromString(form.get("2510116"));
        Double _2510214 = getDoubleFromString(form.get("2510214"));
        Double _2510216 = getDoubleFromString(form.get("2510216"));
        Double _2510314 = getDoubleFromString(form.get("2510314"));
        Double _2510316 = getDoubleFromString(form.get("2510316"));

        Double _210806 = getDoubleFromString(form.get("210806"));
        Double _210906 = getDoubleFromString(form.get("210906"));
        Double _211006 = getDoubleFromString(form.get("211006"));
        numerator = _2510114 - _2510116;
        numerator += _2510214 - _2510216;
        numerator += _2510314 - _2510316;
        denumerator = _210806 + _210906 + _211006;
        mean = numerator / denumerator;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.10", Constants._310, Constants._percent));

        //3.11
        numerator = _2510114 + _2510214 + _2510314;
        mean = numerator / denumerator;
        mean *= 100;
        internationalActivity.addIndex(getIndex(mean, "3.11", Constants._311, Constants._percent));

        //3.12
        Double _611010 = getDoubleFromString(form.get("611010"));
        mean = _611010;
        internationalActivity.addIndex(getIndex(mean, "3.12", Constants._312, Constants._thousand));

        //3.13
        Double _611004 = getDoubleFromString(form.get("611004"));
        mean = _611004;
        internationalActivity.addIndex(getIndex(mean, "3.13", Constants._313, Constants._thousand));

        for (int i = 0; i < internationalActivity.getIndices().size(); i++) {
            internationalActivity.getIndices().get(i).setInternationalActivity(internationalActivity);
        }

        //MEAN
        Double _2470309O = getDoubleFromString(form.get("2470309O"));
        Double _2470309V = getDoubleFromString(form.get("2470309V"));
        Double _2470309Z = getDoubleFromString(form.get("2470309Z"));

        Double _2470609O = getDoubleFromString(form.get("2470609O"));
        Double _2470609V = getDoubleFromString(form.get("2470609V"));
        Double _2470609Z = getDoubleFromString(form.get("2470609Z"));

        numerator = _2470309O + _2470309V * 0.25 + _2470309Z * 0.1;
        numerator += _2470409O + _2470409V * 0.25 + _2470409Z * 0.1;
        numerator += _2470609O + _2470609V * 0.25 + _2470609Z * 0.1;
        numerator += _2470709O + _2470709V * 0.25 + _2470709Z * 0.1;
        mean = numerator / SS;
        mean *= 100;
        internationalActivity.setMean(mean);

        return internationalActivity;
    }

    public ResearchActivity calculateResearchActivity(Map<String, String> form) {
        ResearchActivity researchActivity = new ResearchActivity();

        //Min mean
        Double min = getDoubleFromString(form.get("researchMinMean"));
        researchActivity.setMinMean(min);

        //2.1
        Double _324191 = getDoubleFromString(form.get("324191"));
        Double mean = _324191 / R;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.1", Constants._21, Constants._un));

        //2.2
        Double _324021 = getDoubleFromString(form.get("324021"));
        mean = _324021 / R;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.2", Constants._22, Constants._un));

        //2.3
        Double _324022 = getDoubleFromString(form.get("324022"));
        mean = _324022 / R;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.3", Constants._22, Constants._un));

        //2.4
        Double _324023 = getDoubleFromString(form.get("324023"));
        mean = _324023 / R;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.4", Constants._24, Constants._un));

        //2.5
        Double _324043 = getDoubleFromString(form.get("324043"));
        mean = _324043 / R;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.5", Constants._25, Constants._un));

        //2.6
        Double _324053 = getDoubleFromString(form.get("324053"));
        mean = _324053 / R;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.6", Constants._26, Constants._un));

        //2.7
        Double _321023 = getDoubleFromString(form.get("321023"));
        mean = _321023;
        researchActivity.addIndex(getIndex(mean, "2.7", Constants._27, Constants._thousand));

        //2.8
        Double _610110 = getDoubleFromString(form.get("610110"));
        Double _610103 = getDoubleFromString(form.get("610103"));
        mean = _610110 / _610103;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.8", Constants._28, Constants._percent));

        //2.9
        Double _321024 = getDoubleFromString(form.get("321024"));
        mean = _321024 / _321023;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.9", Constants._29, Constants._percent));

        //2.10
        Double _610610 = getDoubleFromString(form.get("610610"));
        mean = _610610 / R;
        researchActivity.addIndex(getIndex(mean, "2.10", Constants._210, Constants._thousand));

        //2.11
        Double _32606 = getDoubleFromString(form.get("32606"));
        mean = _32606;
        researchActivity.addIndex(getIndex(mean, "2.11", Constants._211, Constants._un));

        //2.12
        Double _610112 = getDoubleFromString(form.get("610112"));
        mean = _610112 / _610103;
        researchActivity.addIndex(getIndex(mean, "2.12", Constants._212, Constants._percent));

        //2.13
        Double _450203 = getDoubleFromString(form.get("450203"));
        Double _450204 = getDoubleFromString(form.get("450204"));
        Double _450303 = getDoubleFromString(form.get("450303"));
        Double _450304 = getDoubleFromString(form.get("450304"));
        Double _450403 = getDoubleFromString(form.get("450403"));
        Double _450404 = getDoubleFromString(form.get("450404"));
        Double _450103 = getDoubleFromString(form.get("450103"));
        Double _450104 = getDoubleFromString(form.get("450104"));
        Double numerator = _450203 + _450204 + _450303 + _450304 + _450403 + _450404;
        Double denumerator = _450103 + _450104;
        mean = numerator / denumerator;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.13", Constants._213, Constants._percent));

        //2.14
        Double _440403 = getDoubleFromString(form.get("440403"));
        Double _440405 = getDoubleFromString(form.get("440405"));
        Double _440407 = getDoubleFromString(form.get("440407"));
        Double _440503 = getDoubleFromString(form.get("440503"));
        Double _440505 = getDoubleFromString(form.get("440505"));
        Double _440507 = getDoubleFromString(form.get("440507"));
        numerator = _440405 + _440407 + _440505 + _440507;
        denumerator = _440403 + _440503;
        mean = numerator / denumerator;
        mean *= 100;
        researchActivity.addIndex(getIndex(mean, "2.14", Constants._214, Constants._percent));

        //2.15
        Double _32425 = getDoubleFromString(form.get("32425"));
        mean = _32425;
        researchActivity.addIndex(getIndex(mean, "2.15", Constants._215, Constants._un));

        //2.16
        Double _3241603 = getDoubleFromString(form.get("3241603"));
        mean = _3241603 / R;
        researchActivity.addIndex(getIndex(mean, "2.16", Constants._216, Constants._un));

        for (int i = 0; i < researchActivity.getIndices().size(); i++){
            researchActivity.getIndices().get(i).setResearchActivity(researchActivity);
        }

        //MEAN
        Double _3210803 = getDoubleFromString(form.get("3210803"));

        Double E21 = _321023 / R;
        Double E22 = (_321023 + _3210803) / R;
        mean = (E21 + E22) / 2;
        researchActivity.setMean(mean);

        return researchActivity;
    }

    public void calculateEfficiency(Map<String, String> form) {
        form.remove("_csrf");
        Department department = departmentService.getOneById(Long.parseLong(form.get("direction")));
        int year;
        if ("".equals(form.get("year"))){
            year = 2019;
        }else {
            year = Integer.parseInt(form.get("year"));
        }
        calculateConstants(form);

        EducationActivity educationActivity = calculateEducationActivity(form);
        educationActivity.setName("Образовательная деятельность");
        educationActivity.setShortName("E.1");
        educationActivityRepo.save(educationActivity);

        ResearchActivity researchActivity = calculateResearchActivity(form);
        researchActivity.setName("Научно-исследовательская деятельность");
        researchActivity.setShortName("E.2");
        researchActivityRepo.save(researchActivity);

        InternationalActivity internationalActivity = calculateInternationalActivity(form);
        internationalActivity.setName("Международная деятельность");
        internationalActivity.setShortName("E.3");
        internationalActivityRepo.save(internationalActivity);

        Efficiency efficiency = new Efficiency();
        efficiency.setEducationActivity(educationActivity);
        efficiency.setInternationalActivity(internationalActivity);
        efficiency.setResearchActivity(researchActivity);
        efficiencyService.save(efficiency);

        Report report = new Report();
        report.setDepartment(department);
        report.setFaculty(department.getFaculty());
        report.setEfficiency(efficiency);
        report.setPeriod(year);
        reportService.save(report);
    }

    private void calculateConstants(Map<String, String> form) {

        //P
        Double _0101 = getDoubleFromString(form.get("0101"));
        Double _0201 = getDoubleFromString(form.get("0201"));
        Double _02501 = getDoubleFromString(form.get("02501"));
        Double _0301 = getDoubleFromString(form.get("0301"));
        Double _0401 = getDoubleFromString(form.get("0401"));
        Double _0501 = getDoubleFromString(form.get("0501"));
        Double _0601 = getDoubleFromString(form.get("0601"));
        Double _0701 = getDoubleFromString(form.get("0701"));
        Double _07501 = getDoubleFromString(form.get("07501"));
        Double _0801 = getDoubleFromString(form.get("0801"));
        Double _0901 = getDoubleFromString(form.get("0901"));
        Double _101 = getDoubleFromString(form.get("101"));

        Double _0104 = getDoubleFromString(form.get("0104"));
        Double _0204 = getDoubleFromString(form.get("0204"));
        Double _02504 = getDoubleFromString(form.get("02504"));
        Double _0304 = getDoubleFromString(form.get("0304"));
        Double _0404 = getDoubleFromString(form.get("0404"));
        Double _0504 = getDoubleFromString(form.get("0504"));
        Double _0604 = getDoubleFromString(form.get("0604"));
        Double _0704 = getDoubleFromString(form.get("0704"));
        Double _07504 = getDoubleFromString(form.get("07504"));
        Double _0804 = getDoubleFromString(form.get("0804"));
        Double _0904 = getDoubleFromString(form.get("0904"));
        Double _104 = getDoubleFromString(form.get("104"));

        Double _0113 = getDoubleFromString(form.get("0113"));
        Double _0213 = getDoubleFromString(form.get("0213"));
        Double _02513 = getDoubleFromString(form.get("02513"));
        Double _0313 = getDoubleFromString(form.get("0313"));
        Double _0413 = getDoubleFromString(form.get("0413"));
        Double _0513 = getDoubleFromString(form.get("0513"));
        Double _0613 = getDoubleFromString(form.get("0613"));
        Double _0713 = getDoubleFromString(form.get("0713"));
        Double _07513 = getDoubleFromString(form.get("07513"));
        Double _0813 = getDoubleFromString(form.get("0813"));
        Double _0913 = getDoubleFromString(form.get("0913"));
        Double _113 = getDoubleFromString(form.get("113"));


        P = _0104 * 0.1 + _0201 * 0.2 + _02501 * 0.25 + _0301 * 0.3 + _0401 * 0.4 + _0501 * 0.5 + _0601 * 0.6
                + _0701 * 0.7 + _07501 * 0.75 + _0801 * 0.8 + _0901 * 0.9 + _101;

        P += _0101 * 0.1 + _0204 * 0.2 + _02504 * 0.25 + _0304 * 0.3 + _0404 * 0.4 + _0504 * 0.5 + _0604 * 0.6
                + _0704 * 0.7 + _07504 * 0.75 + _0804 * 0.8 + _0904 * 0.9 + _104;

        P += _0113 * 0.1 + _0213 * 0.2 + _02513 * 0.25 + _0313 * 0.3 + _0413 * 0.4 + _0513 * 0.5 + _0613 * 0.6
                + _0713 * 0.7 + _07513 * 0.75 + _0813 * 0.8 + _0913 * 0.9 + _113;

        //N
        Double _0107 = getDoubleFromString(form.get("0107"));
        Double _0207 = getDoubleFromString(form.get("0207"));
        Double _02507 = getDoubleFromString(form.get("02507"));
        Double _0307 = getDoubleFromString(form.get("0307"));
        Double _0407 = getDoubleFromString(form.get("0407"));
        Double _0507 = getDoubleFromString(form.get("0507"));
        Double _0607 = getDoubleFromString(form.get("0607"));
        Double _0707 = getDoubleFromString(form.get("0707"));
        Double _07507 = getDoubleFromString(form.get("07507"));
        Double _0807 = getDoubleFromString(form.get("0807"));
        Double _0907 = getDoubleFromString(form.get("0907"));
        Double _107 = getDoubleFromString(form.get("107"));

        Double _0110 = getDoubleFromString(form.get("0110"));
        Double _0210 = getDoubleFromString(form.get("0210"));
        Double _02510 = getDoubleFromString(form.get("02510"));
        Double _0310 = getDoubleFromString(form.get("0310"));
        Double _0410 = getDoubleFromString(form.get("0410"));
        Double _0510 = getDoubleFromString(form.get("0510"));
        Double _0610 = getDoubleFromString(form.get("0610"));
        Double _0710 = getDoubleFromString(form.get("0710"));
        Double _07510 = getDoubleFromString(form.get("07510"));
        Double _0810 = getDoubleFromString(form.get("0810"));
        Double _0910 = getDoubleFromString(form.get("0910"));
        Double _110 = getDoubleFromString(form.get("110"));

        Double _0116 = getDoubleFromString(form.get("0116"));
        Double _0216 = getDoubleFromString(form.get("0216"));
        Double _02516 = getDoubleFromString(form.get("02516"));
        Double _0316 = getDoubleFromString(form.get("0316"));
        Double _0416 = getDoubleFromString(form.get("0416"));
        Double _0516 = getDoubleFromString(form.get("0516"));
        Double _0616 = getDoubleFromString(form.get("0616"));
        Double _0716 = getDoubleFromString(form.get("0716"));
        Double _07516 = getDoubleFromString(form.get("07516"));
        Double _0816 = getDoubleFromString(form.get("0816"));
        Double _0916 = getDoubleFromString(form.get("0916"));
        Double _116 = getDoubleFromString(form.get("116"));


        N = _0107 * 0.1 + _0207 * 0.2 + _02507 * 0.25 + _0307 * 0.3 + _0407 * 0.4 + _0507 * 0.5 + _0607 * 0.6
                + _0707 * 0.7 + _07507 * 0.75 + _0807 * 0.8 + _0907 * 0.9 + _107;

        N += _0110 * 0.1 + _0210 * 0.2 + _02510 * 0.25 + _0310 * 0.3 + _0410 * 0.4 + _0510 * 0.5 + _0610 * 0.6
                + _0710 * 0.7 + _07510 * 0.75 + _0810 * 0.8 + _0910 * 0.9 + _110;

        N += _0116 * 0.1 + _0216 * 0.2 + _02516 * 0.25 + _0316 * 0.3 + _0416 * 0.4 + _0516 * 0.5 + _0616 * 0.6
                + _0716 * 0.7 + _07516 * 0.75 + _0816 * 0.8 + _0916 * 0.9 + _116;

        R = P + N;

        //S
        Double _242O = getDoubleFromString(form.get("242O"));
        Double _242V = getDoubleFromString(form.get("242V"));
        Double _242Z = getDoubleFromString(form.get("242Z"));

        Double _245O = getDoubleFromString(form.get("245O"));
        Double _245V = getDoubleFromString(form.get("245V"));
        Double _245Z = getDoubleFromString(form.get("245Z"));

        S = _242O + 0.25 * _242V + 0.1 * _242Z + _245O + 0.25 * _245V + 0.1 * _245Z;

        //SS
        Double _242OF = getDoubleFromString(form.get("242OF"));
        Double _242VF = getDoubleFromString(form.get("242VF"));
        Double _242ZF = getDoubleFromString(form.get("242ZF"));

        Double _245OF = getDoubleFromString(form.get("245OF"));
        Double _245VF = getDoubleFromString(form.get("245VF"));
        Double _245ZF = getDoubleFromString(form.get("245ZF"));

        SS = _242OF + 0.25 * _242VF + 0.1 * _242ZF + _245OF + 0.25 * _245VF + 0.1 * _245ZF;

        //VV
        Double _243045O = getDoubleFromString(form.get("243045O"));
        Double _243045V = getDoubleFromString(form.get("243045V"));
        Double _243045Z = getDoubleFromString(form.get("243045Z"));

        Double _246045O = getDoubleFromString(form.get("246045O"));
        Double _246045V = getDoubleFromString(form.get("246045V"));
        Double _246045Z = getDoubleFromString(form.get("246045Z"));

        VV = _243045O + 0.25 * _243045V + 0.1 * _243045Z + _246045O + 0.25 * _246045V + 0.1 * _246045Z;


    }
}
