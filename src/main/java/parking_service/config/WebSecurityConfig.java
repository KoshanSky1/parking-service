package parking_service.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import parking_service.service.SecurityService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final SecurityService securityService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/",  "/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/admin-panel").hasAuthority("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .defaultSuccessUrl("/parking-lots", true)
                .permitAll()
            )
            .logout((logout) -> logout
                .permitAll()
                .logoutSuccessUrl("/login"));

        http
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
            );

        http
            .sessionManagement(sessionManagement -> sessionManagement
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .invalidSessionUrl("/login")
            );

        http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(securityService)
            .passwordEncoder(passwordEncoder());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}