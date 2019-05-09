package vorstu.model.Efficiency.parts;

import vorstu.Exception.MyException;
import vorstu.model.Efficiency.Efficiency;

public interface BasePart {

    void addEfficiency(Efficiency efficiency) throws MyException;

    void removeEfficiency(Efficiency efficiency) throws MyException;
}
