package spring.security.confoguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource); //bcrypt and noop

//        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder(); //vremenno
//
//        auth.inMemoryAuthentication().withUser(userBuilder.username("Leha").password("Selyanko").roles("DRIVER"))
//                .withUser(userBuilder.username("Artem").password("Tokarev").roles("ELECTRICITY"))
//                .withUser(userBuilder.username("Olga").password("Gagina").roles("EMPLOYEE"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "ELECTRICITY", "DRIVER")
                .antMatchers("/driver_info").hasRole("DRIVER")
                .antMatchers("/electricity_info").hasRole("ELECTRICITY")
                .and().formLogin().permitAll();
    }
}
