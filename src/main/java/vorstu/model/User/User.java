package vorstu.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.model.BaseEntity.BaseEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "usr")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;

    private String password;
}
