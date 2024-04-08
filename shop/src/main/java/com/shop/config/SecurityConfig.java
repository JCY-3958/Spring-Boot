package com.shop.config;

import com.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    MemberService memberService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //더 이상 로그인을 하지 않도록 모두 허용
        /*
        http.
                authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests.
                        requestMatchers(new AntPathRequestMatcher("/**")).permitAll());
        */
        http
                //아니 jar로 배포하면 login이 왜 안되는데
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/members/login").permitAll()
                                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                                .requestMatchers("/", "members/**", "/item/**", "/images/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin((formLogin) ->
                    formLogin
                            .loginPage("/members/login") // 로그인 페이지
                            .defaultSuccessUrl("/") //로그인 성공 시 표시 페이지
                            .usernameParameter("email")
                            .failureUrl("/members/login/error") //로그인 실패 시 표시 페이지
                )
                .logout((logoutConfig) ->
                        logoutConfig
                                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                                .logoutSuccessUrl("/")
                )
                .exceptionHandling((exceptionConfig) ->
                        exceptionConfig
                                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()))
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
