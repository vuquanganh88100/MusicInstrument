    package software.vn.musicprj.service;
            import org.springframework.beans.BeanUtils;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.security.crypto.password.PasswordEncoder;
            import org.springframework.stereotype.Service;
            import software.vn.musicprj.dto.UserDto;
            import software.vn.musicprj.entities.MusicuserEntity;
            import software.vn.musicprj.repository.UserRepository;


            import java.util.List;
    @Service
    public class UserService {
        @Autowired
        UserRepository userRepository;
        public String save(UserDto userDto,PasswordEncoder passwordEncoder) {
            MusicuserEntity musicuserEntity = new MusicuserEntity();
            BeanUtils.copyProperties(userDto, musicuserEntity);
            musicuserEntity.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
            // lưu vào db
            userRepository.save(musicuserEntity);
            return "tạo mới thành công ";
        }
        public List<MusicuserEntity> findAll(){
            return userRepository.findAll();
        }
        public String deleteById(Integer id){
            userRepository.deleteById(id);
            return "xóa thành công";
        }
        public List<MusicuserEntity> searchByEmail(String userEmail){
            return userRepository.findAllByUserEmailContaining(userEmail);
        }
    }
