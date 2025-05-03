package bg.sap.trohar_delivery.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/menu").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/signup").permitAll()
                        .requestMatchers("/restaurant").permitAll()
                        .requestMatchers("/cart").permitAll()
                        .requestMatchers("/profile").authenticated()
                        .requestMatchers("/employee").permitAll()
                        .anyRequest().permitAll())
                .formLogin(form -> form
                        .loginPage("/login") // your custom login page
                        .successHandler((HttpServletRequest request, HttpServletResponse response, Authentication authentication) -> {
                            // Role-based redirection logic
                            for (GrantedAuthority auth : authentication.getAuthorities()) {
                                String role = auth.getAuthority();
                                if ("ROLE_ADMIN".equals(role)) {
                                    response.sendRedirect("/employee");
                                    return;
                                } else if ("ROLE_CUSTOMER".equals(role)) {
                                    response.sendRedirect("/profile");
                                    return;
                                } else if ("ROLE_DRIVER".equals(role)) {
                                    response.sendRedirect("/profile"); // Change as needed
                                    return;
                                }
                            }
                            // Default redirect
                            response.sendRedirect("/");
                        })
                        .failureUrl("/login?error=true")
                    .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}