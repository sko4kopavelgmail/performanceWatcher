package vorstu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vorstu.model.Efficiency.parts.Constants;
import vorstu.model.Efficiency.parts.EducationActivity;
import vorstu.model.Efficiency.parts.Index.Index;
import vorstu.model.Efficiency.parts.InternationalActivity;
import vorstu.model.Efficiency.parts.ResearchActivity;
import vorstu.repo.Efficiency.EfficiencyRepo;
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
    private EfficiencyRepo efficiencyRepo;

    public EducationActivity calculateEducationActivity(Map<String, String> form) {
        EducationActivity educationActivity = new EducationActivity();

        //1.1
        Double b24118 = getDoubleFromString(form.get("24118b"));
        Double s24118 = getDoubleFromString(form.get("24118s"));
        Double b24119 = getDoubleFromString(form.get("24119b"));
        Double s24119 = getDoubleFromString(form.get("24119s"));
        Double b24129 = getDoubleFromString(form.get("24129b"));
        Double s24129 = getDoubleFromString(form.get("24129s"));

        Double _24130b = getDoubleFromString(form.get("24130b"));
        Double _24130s = getDoubleFromString(form.get("24130s"));
        Double _24120b = getDoubleFromString(form.get("24120b"));
        Double _24120s = getDoubleFromString(form.get("24120s"));
        Double _24121b = getDoubleFromString(form.get("24121b"));
        Double _24121s = getDoubleFromString(form.get("24121s"));

        Double _24122b = getDoubleFromString(form.get("24122b"));
        Double _24122s = getDoubleFromString(form.get("24122s"));

        Double mean = b24129 * (b24118 - b24119);
        mean += s24129 * (s24118 - s24119);
        mean += _24130b * (_24120b - _24121b);
        mean += _24130s * (_24120s - _24121s);
        mean += 100 * _24122b;
        mean += 100 * _24122s;
        mean /= ((b24118 - b24119 + _24120b - _24121b + _24122b) + (s24118 - s24119 + _24120s - _24121s + _24122s));

        educationActivity.addIndex(getIndex(mean, "1.1", Constants._11, Constants._ball));

        //1.2

        mean = b24129 * (b24118 - b24119);
        mean += s24129 * (s24118 - s24119);
        mean += _24130b * (_24120b - _24121b);
        mean += _24130s * (_24120s - _24121s);
        mean /= ((b24118 - b24119 + _24120b - _24121b + _24122b) + (s24118 - s24119 + _24120s - _24121s + _24122s));

        educationActivity.addIndex(getIndex(mean, "1.2", Constants._12, Constants._ball));

        //1.3
        Double _24131b = getDoubleFromString(form.get("24131b"));
        Double _24131s = getDoubleFromString(form.get("24131s"));
        Double _24132b = getDoubleFromString(form.get("24132b"));
        Double _24132s = getDoubleFromString(form.get("24132s"));

        mean = _24131b * b24119;
        mean += _24131s * s24119;
        mean += _24132b * _24121b;
        mean += _24132s * _24121s;
        mean /= b24119 + _24121b + s24119 + _24121s;
        educationActivity.addIndex(getIndex(mean, "1.3", Constants._13, Constants._ball));

        //1.4
        Double _24125b = getDoubleFromString(form.get("24125b"));
        Double _24125s = getDoubleFromString(form.get("24125s"));
        Double _24126b = getDoubleFromString(form.get("24126b"));
        Double _24126s = getDoubleFromString(form.get("24126s"));
        Double _24127b = getDoubleFromString(form.get("24127b"));
        Double _24127s = getDoubleFromString(form.get("24127s"));
        Double _24128b = getDoubleFromString(form.get("24128b"));
        Double _24128s = getDoubleFromString(form.get("24128s"));

        mean = 0.0;
        if (b24118 + _24120b != 0) {
            mean += getMin(_24125b, _24126b, _24127b, _24128b);
        }
        if (s24118 + _24120s != 0) {
            mean += getMin(_24125s, _24126s, _24127s, _24128s);
        }
        int x = 0;
        if (b24118 + _24120b != 0) x++;
        if (s24118 + _24120s != 0) x++;
        mean /= x;
        educationActivity.addIndex(getIndex(mean, "1.4", Constants._14, Constants._ball));

        //1.5
        Double _24123b = getDoubleFromString(form.get("24123b"));
        Double _24123s = getDoubleFromString(form.get("24123s"));
        mean = _24123b + _24123s;
        educationActivity.addIndex(getIndex(mean, "1.5", Constants._15, Constants._person));

        //1.6
        Double _24124b = getDoubleFromString(form.get("24124b"));
        Double _24124s = getDoubleFromString(form.get("24124s"));
        mean = _24124b + _24124s;
        educationActivity.addIndex(getIndex(mean, "1.6", Constants._16, Constants._person));

        //1.7
        Double _24110b = getDoubleFromString(form.get("24110b"));
        Double _24110s = getDoubleFromString(form.get("24110s"));
        mean = _24110b + _24110s;
        educationActivity.addIndex(getIndex(mean, "1.7", Constants._17, Constants._person));

        //1.8
        Double _2415b = getDoubleFromString(form.get("2415b"));
        Double _2415s = getDoubleFromString(form.get("2415s"));
        Double numerator = _24110b + _24110s;
        Double denominator = _2415b + _2415s;
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
        Double _2420417 = getDoubleFromString(form.get("2420417"));
        Double _2420412 = getDoubleFromString(form.get("2420412"));
        Double _2450412E = getDoubleFromString(form.get("2450412E"));
        mean = _2420417 / (_2420412 + _2450412E);
        mean *= 100;
        educationActivity.addIndex(getIndex(mean,"1.15",Constants._115,Constants._percent));

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
        return Double.parseDouble(s);
    }

    public InternationalActivity calculateInternationalActivity(Map<String, String> form) {
        InternationalActivity internationalActivity = new InternationalActivity();


        return internationalActivity;
    }

    public ResearchActivity calculateResearchActivity(Map<String, String> form) {
        ResearchActivity researchActivity = new ResearchActivity();


        return researchActivity;
    }

    public void calculateEfficiency(Map<String, String> form) {
        form.remove("_csrf");
        calculateConstants(form);
        EducationActivity educationActivity = calculateEducationActivity(form);
        educationActivityRepo.save(educationActivity);
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
