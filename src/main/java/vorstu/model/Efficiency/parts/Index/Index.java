package vorstu.model.Efficiency.parts.Index;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.model.Efficiency.parts.EducationActivity;
import vorstu.model.Efficiency.parts.InternationalActivity;
import vorstu.model.Efficiency.parts.ResearchActivity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shortName;

    @Column(length = 1000)
    private String name;

    private String unit;

    private Double mean;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_id")
    private EducationActivity educationActivity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "research_id")
    private ResearchActivity researchActivity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "international_id")
    private InternationalActivity internationalActivity;
}
