package vorstu.model.Report;

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
public class Department extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Report> reports;



    public void addReport(Report report) throws MyException {
        if (Objects.isNull(report)) {
            throw new MyException("Добавление несуществующего отчета");
        }
        if (Objects.isNull(reports)) {
            reports = new ArrayList<>();
        }
        if (reports.contains(report)) {
            throw new MyException("Попытка повторного добавления отчета");
        }
        reports.add(report);
    }

    public void removeReport(Report report) throws MyException {
        if (Objects.isNull(report)) {
            throw new MyException("Добавление несуществующего отчета");
        }
        if (Objects.isNull(reports) || !reports.contains(report)) {
            throw new MyException("Попытка удаления несуществующего отчета");
        }
        reports.remove(report);
    }
}
