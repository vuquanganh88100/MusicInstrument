package software.vn.musicprj.entities;

        import javax.persistence.*;
        import java.sql.Date;
        import java.util.Objects;

@Entity
@Table(name = "musicuser", schema = "ktpm", catalog = "")
public class MusicuserEntity {
    private Integer id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userSex;
    private Date userDate;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_email")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_sex")
    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_date")
    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicuserEntity that = (MusicuserEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userSex, that.userSex) &&
                Objects.equals(userDate, that.userDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, userEmail, userPassword, userSex, userDate);
    }
}
