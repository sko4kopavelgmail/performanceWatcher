package vorstu.model.Report;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.Exception.MyException;
import vorstu.model.BaseEntity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Faculty extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Department> departments;

    public void addDepartment(Department department) throws MyException {
        if (Objects.isNull(department)) {
            throw new MyException("Переданный аргумент нулевой");
        }
        if (Objects.isNull(departments)) {
            departments = new ArrayList<>();
        }
        if (departments.contains(department)){
            throw new MyException("Дублирование данных");
        }
        departments.add(department);
    }

    public void removeDepartment(Department department) throws MyException {
        if (Objects.isNull(department)) {
            throw new MyException("Переданный аргумент нулевой");
        }
        if (Objects.isNull(departments) || !departments.contains(department)) {
            throw new MyException("Поптыка удаления несуществущей кафедры");
        }
        departments.remove(department);
    }
}
