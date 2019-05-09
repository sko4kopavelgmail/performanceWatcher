package vorstu.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vorstu.model.BaseEntity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "usr")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    private boolean active;

    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;
}
