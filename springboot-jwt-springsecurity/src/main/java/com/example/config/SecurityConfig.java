package com.example.config;

import com.example.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //设置请求授权
        http.authorizeRequests()
                .antMatchers("/public").permitAll()   //表示允许 /public 路径的请求无需认证
                .anyRequest().authenticated();    //表示其他所有的请求都需要进行认证，即需要用户进行登录验证

        http
                .formLogin()   //配置表单登录功能
                .loginPage("/login")   //登录页面的路径为 /login
                .permitAll()    //表示登录页面允许公开访问，无需认证
                .successForwardUrl("/success")  //登录成功后跳转路径
                .failureForwardUrl("/fail")  //登录失败后跳转路径
                .and()
                .logout()   //配置注销功能
                .logoutUrl("/logout")   //注销的操作的路径为 /logout
                .permitAll();  //注销页面允许公开访问
        //关闭csrf防护
        http.csrf().disable();
        return http.build();
    }

    //密码校验器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
