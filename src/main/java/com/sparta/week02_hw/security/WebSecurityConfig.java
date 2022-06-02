package com.sparta.week02_hw.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
public class WebSecurityConfig {

    @Configuration
    public static class SecurityConfiguration {

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() { // h2-console 사용에 대한 허용 (CSRF, FrameOptions 무시)
            return (web) -> web.ignoring().antMatchers("/h2-console/**");
        }

    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder(); // BCrypt 해시함수를 사용해 패스워드 암호화하여 DB에 저장
    }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            // 회원 관리 처리 API (POST /user/**) 에 대해 CSRF 무시
            http.csrf()
                    .ignoringAntMatchers("/user/**");

            http
                    .authorizeHttpRequests((authz) -> authz
                            // 어떤 요청이든 '인증'
                            .anyRequest().authenticated()
                                    // image 폴더를 login 없이 허용
                                    .antMatchers("/images/**").permitAll()
                                    // css 폴더를 login 없이 허용
                                    .antMatchers("/css/**").permitAll()

                            // 로그인, 로그아웃 처리 URL 설정 어떻게 하나요 (스프링 시큐리티 버전이 다름)


                    )
                    .httpBasic(withDefaults());
            return http.build();
        }

    }

