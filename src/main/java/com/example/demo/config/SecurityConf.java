package com.example.demo.config;

import com.example.demo.config.security.AjaxAccessDeniedHandle;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConf extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/test").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().exceptionHandling().accessDeniedHandler(new AjaxAccessDeniedHandle())
                .and().logout().permitAll().and().httpBasic();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return charSequence.toString();
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        System.out.println(charSequence + "=====" + s);
                        return s.equalsIgnoreCase(charSequence.toString());
                    }
                })
                .withUser("admin").password("a123").roles("admin", "simple_manage")
                .and()
                .withUser("lf").password("a123").roles("simple_manage");
    }
}
