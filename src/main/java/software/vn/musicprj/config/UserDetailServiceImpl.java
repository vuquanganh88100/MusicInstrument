package software.vn.musicprj.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import software.vn.musicprj.dto.UserDto;
import software.vn.musicprj.entities.MusicuserEntity;
import software.vn.musicprj.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            MusicuserEntity musicuserEntity = userRepository.findFirstByUserEmail(username);
        if (musicuserEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("USER"));
        User user = new User(musicuserEntity.getUserEmail(), musicuserEntity.getUserPassword(),roles);
        return user;

    }
}

