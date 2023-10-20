package software.vn.musicprj.entities;

        import javax.persistence.*;
        import java.util.Objects;

@Entity
@Table(name = "list_music", schema = "ktpm", catalog = "")
public class ListMusicEntity {
    private Integer id;
    private String instrumentName;
    private String musicType;
    private String audio;

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
    @Column(name = "instrument_name")
    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    @Basic
    @Column(name = "music_type")
    public String getMusicType() {
        return musicType;
    }

    public void setMusicType(String musicType) {
        this.musicType = musicType;
    }

    @Basic
    @Column(name = "audio")
    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListMusicEntity that = (ListMusicEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(instrumentName, that.instrumentName) &&
                Objects.equals(musicType, that.musicType) &&
                Objects.equals(audio, that.audio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instrumentName, musicType, audio);
    }
}
