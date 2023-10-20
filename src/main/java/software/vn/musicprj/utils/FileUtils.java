package software.vn.musicprj.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static final String FOLDER_MEDIA = "D:/opt/music_audio/";

    public static String saveFileFromMultiPartFile(MultipartFile multipartFile, String extension) throws IOException {
        if (multipartFile == null) return null;
        String nameFile = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File file = new File(FOLDER_MEDIA + nameFile);
        if (!file.exists()) file.createNewFile();
        multipartFile.transferTo(file);
        return nameFile;
    }
}


