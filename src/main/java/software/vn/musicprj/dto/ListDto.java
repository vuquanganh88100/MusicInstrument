package software.vn.musicprj.dto;

        import lombok.Data;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import org.springframework.web.multipart.MultipartFile;


@Data
//@Component
public class ListDto {
    //    @Autowired
    private Integer id;
    private String instrumentName;
    private String musicType;
    private String audio;
    private MultipartFile audioFile;
}


