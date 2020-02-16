package embl.person.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Performs the web based security for Spring Security
 *
 * @author Manuel Bouzas
 */
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService () {

        User.UserBuilder user = org.springframework.security.core.userdetails.User.withUsername("user");
        user.password(new BCryptPasswordEncoder().encode("secret"));
        user.roles("USER");

        User.UserBuilder admin = org.springframework.security.core.userdetails.User.withUsername("admin");
        admin.password(new BCryptPasswordEncoder().encode("secret"));
        admin.roles("ADMIN");
        return new InMemoryUserDetailsManager(user.build(),
                admin.build());

    }

}