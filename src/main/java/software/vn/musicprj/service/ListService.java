package software.vn.musicprj.service;

        import com.fasterxml.jackson.databind.util.BeanUtil;
        import org.springframework.beans.BeanUtils;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;
        import software.vn.musicprj.dto.ListDto;
        import software.vn.musicprj.entities.ListMusicEntity;
        import software.vn.musicprj.repository.ListRepository;
        import software.vn.musicprj.utils.FileUtils;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;

@Service
public class ListService {
    private static final String FOLDER_MEDIA = "D:/opt/music_audio/";

    private static final String SOLO_FLAG = "solo";
    private static final String DUET_FLAG = "duet";

    @Autowired
    ListRepository listRepository;

    public List<ListMusicEntity> findAll() {
        return listRepository.findAll();
    }

    public List<ListMusicEntity> findSoloTracks() {
        return listRepository.findAllByMusicType(SOLO_FLAG);
    }

    public List<ListMusicEntity> findDuetTracks() {
        return listRepository.findAllByMusicType(DUET_FLAG);
    }
    public List<ListMusicEntity> searchByInstrumentName(String instrumentName){
        return listRepository.findByInstrumentName(instrumentName);
    }


    public String save(ListDto listDto) throws IOException {
        ListMusicEntity listMusicEntity = new ListMusicEntity();
        String filePath = FileUtils.saveFileFromMultiPartFile(listDto.getAudioFile(), ".wav");
        listDto.setAudio(filePath);
        BeanUtils.copyProperties(listDto, listMusicEntity);
        listMusicEntity.setAudio(filePath);
        listRepository.save(listMusicEntity);
        return "Tạo mới bài nhạc hiệu thành công";
    }

    public String deleteById(Integer id) throws IOException {
        ListMusicEntity listMusicEntity = listRepository.findById(id).orElseThrow(() -> new RuntimeException());
        Files.deleteIfExists(Paths.get(listMusicEntity.getAudio()));
        listRepository.deleteById(id);
        return "xóa thành công";
    }

}