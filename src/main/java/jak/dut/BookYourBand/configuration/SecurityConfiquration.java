package jak.dut.BookYourBand.configuration;

import jak.dut.BookYourBand.service.ClientDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiquration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private final ClientDetailServiceImpl clientDetailService;

    public SecurityConfiquration(ClientDetailServiceImpl clientDetailService) {
        this.clientDetailService = clientDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(clientDetailService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http.authorizeRequests()
                .antMatchers("/welcome").authenticated()
                .antMatchers("/bands").permitAll()
                .antMatchers("/bands/{id}").permitAll()
                .antMatchers("/comments").permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/welcome");
    }
}
