package vorstu.model.Efficiency;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.model.BaseEntity.BaseEntity;
import vorstu.model.Efficiency.parts.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Efficiency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "educationActivity_id")
    private EducationActivity educationActivity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "internationalActivity_id")
    private InternationalActivity internationalActivity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "researchActivity_id")
    private ResearchActivity researchActivity;


}
