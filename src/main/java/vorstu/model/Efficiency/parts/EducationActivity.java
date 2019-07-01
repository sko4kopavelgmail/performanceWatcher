package vorstu.model.Efficiency.parts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.Exception.MyException;
import vorstu.model.BaseEntity.BaseEntity;
import vorstu.model.Efficiency.Efficiency;
import vorstu.model.Efficiency.parts.Index.Index;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class EducationActivity extends BaseEntity implements BasePart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shortName;

    private String name;

    private Double mean;

    private Double minMean;

    public EducationActivity() {
        mean = 0.0;
        minMean = 0.0;
    }

    @OneToMany(mappedBy = "educationActivity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Index> indices;

    public void addIndex(Index index) {
        if (Objects.isNull(indices)) {
            indices = new ArrayList<>();
        }
        if (Objects.nonNull(index)) {
            indices.add(index);
        }
    }

    @OneToMany(mappedBy = "educationActivity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Efficiency> efficiencies;

    public void addEfficiency(Efficiency efficiency) throws MyException {
        if (Objects.isNull(efficiency)) {
            throw new MyException("Попытка добавить несущуствующую ассоциацию");
        }
        if (Objects.isNull(efficiencies)) {
            efficiencies = new ArrayList<>();
        }
        if (efficiencies.contains(efficiency)) {
            throw new MyException("Попытка дублирования данных");
        }
        efficiencies.add(efficiency);
    }

    public void removeEfficiency(Efficiency efficiency) throws MyException {
        if (Objects.isNull(efficiency)) {
            throw new MyException("Передача несуществующей ассоциации");
        }
        if (Objects.isNull(efficiencies) || !efficiencies.contains(efficiency)) {
            throw new MyException("Попытка удаления несуществующей ассоциации");
        }
    }
}
