package software.vn.musicprj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
    @Bean
    public PasswordEncoder passwordEncoder(){ // mã hóa pass
        return new BCryptPasswordEncoder(); // mã hóa 1 chiều
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                // Câu hình phạm vi phân quyền
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers(HttpMethod.POST, "/music/backend/user/save").permitAll()
                        .antMatchers("/music/backend/track/solo", "/music/backend/track/duet").permitAll()
                        .antMatchers("/music/backend/**").authenticated()
                        .anyRequest().permitAll()
                )



                // Cấu hình trang đăng nhập
                .formLogin((form) -> form
                        .loginPage("/music/login")
                        .usernameParameter("userEmail")
                        .passwordParameter("userPassword")
                        .loginProcessingUrl("/doLogin")
                        .defaultSuccessUrl("/music/home") // add this line
                        .failureUrl("/music/login?error=true")
                        .permitAll()
                )

                .logout((logout) ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/music/login")
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")// key duy nhất xđ ng dùng tương tác vs hệ thống
                                .permitAll()
                );

        return http.build();
    }
}
