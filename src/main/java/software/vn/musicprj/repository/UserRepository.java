package software.vn.musicprj.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import software.vn.musicprj.entities.MusicuserEntity;


        import java.util.List;

public interface UserRepository extends JpaRepository<MusicuserEntity, Integer> {
    List<MusicuserEntity> findAllByUserEmailContaining(String userEmail); // tìm kiếm email gần đúng
    MusicuserEntity findFirstByUserEmail(String userEmail);}
