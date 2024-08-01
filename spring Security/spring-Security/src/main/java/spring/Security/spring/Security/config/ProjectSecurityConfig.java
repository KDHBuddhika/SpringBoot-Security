package spring.Security.spring.Security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.net.http.HttpRequest;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)throws Exception{
       http.csrf().disable()   //disable by spring security is given becuse that enable block the post,put , delete request
               .authorizeRequests()
               .antMatchers("/api/v1/account/my-account").hasRole("ADMIN") //meka standed kramarak .database ekh role column ekh ROLE_ADMIN kiyala thiyenna one //.hasAuthority("admin")     //.authenticated() // this method is acessed only admin
               .antMatchers("/api/v1/loan/my-loan").hasRole("USER")//database ekh role column ekh ROLE_USER kiyala thiyenna one  //.hasAuthority("user") // this method is acessed only user
               .antMatchers("/api/v1/notice/my-notice","/api/v1/user/register").permitAll()
               .and().formLogin().and().httpBasic();

       return http.build();
    }


    //crate user name and assword for 1 st time user request

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService(){
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("12345")
//                .authorities("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin);
//    }


    //meye awashya wanne ihatha ekh wade karanne nattan pamani
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
}

}
