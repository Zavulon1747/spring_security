package spring.security.confoguration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder(); //vremenno

        auth.inMemoryAuthentication().withUser(userBuilder.username("Leha").password("Selyanko").roles("DRIVER"))
                .withUser(userBuilder.username("Artem").password("Tokarev").roles("ELECTRICITY"))
                .withUser(userBuilder.username("Olga").password("Gagina").roles("EMPLOYEE"));

    }
}
