package Lab24.hammaslaakari;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import Lab24.hammaslaakari.web.UserDetailServiceImpl;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {

        private final AuthenticationHandler authenticationHandler;

        @Lazy
        @Autowired
        public WebSecurityConfig(AuthenticationHandler authenticationHandler) {
                this.authenticationHandler = authenticationHandler;
        }

        @Autowired
        private UserDetailServiceImpl userDetailsService;

        @Bean
        public SecurityFilterChain configure(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(antMatcher("/css/**")).permitAll()
                                                .anyRequest().authenticated())
                                .formLogin(formlogin -> formlogin
                                                .successHandler(authenticationHandler)
                                                .permitAll())
                                .logout(logout -> logout
                                                .permitAll());

                return http.build();
        }

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
                auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        }

        @Bean
        public UserDetailsService userDetailsService() {
                System.out.println("in-memory users - jokuviesti");
                List<UserDetails> users = new ArrayList<UserDetails>();

                PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

                UserDetails user1 = User.withUsername("user").password(passwordEncoder.encode("user"))
                                .roles("USER").build();

                users.add(user1);

                UserDetails user2 = User.withUsername("admin").password(passwordEncoder.encode("admin"))
                                .roles("USER", "ADMIN").build();

                users.add(user2);

                return new InMemoryUserDetailsManager(users);
        }

        @Bean
        public AuthenticationHandler authenticationHandler() {
                return new AuthenticationHandler();
        }

}
