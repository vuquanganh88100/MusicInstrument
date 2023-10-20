package software.vn.musicprj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import software.vn.musicprj.dto.ListDto;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/images/**")// vói đường đãn url bắt đầu bằng images/
                .addResourceLocations("file:/D:\\opt\\music_audio\\" );// thì nó sẽ vào thư mục FOLDER_MEDIA lấy file
    }

//    @Bean
//    public ListDto createBean(){
//        return new ListDto();
//    }
}
