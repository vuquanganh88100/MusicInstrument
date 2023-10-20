package software.vn.musicprj.repository;

        import org.springframework.data.jpa.repository.JpaRepository;
        import software.vn.musicprj.entities.ListMusicEntity;

        import java.util.List;

public interface ListRepository extends JpaRepository<ListMusicEntity, Integer> {
    List<ListMusicEntity> findAllByMusicType(String musicType);
    List<ListMusicEntity> findByInstrumentName(String instrumentName);
}


