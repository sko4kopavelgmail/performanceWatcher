package vorstu.model.Efficiency.parts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.Exception.MyException;
import vorstu.model.BaseEntity.BaseEntity;
import vorstu.model.Efficiency.Efficiency;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class InternationalActivity extends BaseEntity implements BasePart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "internationalActivity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Efficiency> efficiencies;

    public void addEfficiency(Efficiency efficiency) throws MyException {
        if (Objects.isNull(efficiency)){
            throw new MyException("Попытка добавить несущуствующую ассоциацию");
        }
        if (Objects.isNull(efficiencies)){
            efficiencies = new ArrayList<>();
        }
        if (efficiencies.contains(efficiency)){
            throw new MyException("Попытка дублирования данных");
        }
        efficiencies.add(efficiency);
    }

    public void removeEfficiency(Efficiency efficiency) throws MyException {
        if (Objects.isNull(efficiency)){
            throw new MyException("Передача несуществующей ассоциации");
        }
        if (Objects.isNull(efficiencies) || !efficiencies.contains(efficiency)){
            throw new MyException("Попытка удаления несуществующей ассоциации");
        }
    }
}
