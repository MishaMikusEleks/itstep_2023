package itstep.task_18;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "mantis_user_table")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class MantisUser {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "access_level")
    private Integer accessLevel;

    @Column(name = "cookie_string", length = 255)
    private String cookieString;

    @Column(name = "date_created")
    private Long dateCreated;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "enabled")
    private Integer enabled;

    @Column(name = "failed_login_count")
    private Integer failedLoginCount;

    @Column(name = "last_visit")
    private Long lastVisit;

    @Column(name = "login_count")
    private Integer loginCount;

    @Column(name = "lost_password_request_count")
    private Integer lostPasswordRequestCount;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "protected")
    private Integer protectedUser;

    @Column(name = "realname", length = 255)
    private String realname;

    @Column(name = "username", length = 255)
    private String username;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MantisUser that = (MantisUser) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}