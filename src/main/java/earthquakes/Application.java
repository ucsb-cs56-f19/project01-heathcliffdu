package earthquakes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class Application extends WebSecurityConfigurerAdapter {

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
            .antMatchers("/","/login**","/webjars/**","/error**")
            .permitAll()
        .anyRequest()
            .authenticated()
        .and()
            .oauth2Login().loginPage("/login")
        .and()
            .logout()
            .deleteCookies("remove")
            .invalidateHttpSession(true)
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll();
    }

}
