package com.ssl.springboot2task.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity//这个注解已经包括@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        /**
         * 定制请求的授权规则
         */
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        /**
         * 开启自动配置的登录功能，如果没有登录则会来到登陆页面
         */
        http.formLogin().usernameParameter("user").passwordParameter("password").loginPage("/userLogin");
        /**
         * 默认的用户名和密码是username，password
         * 自定义的登录页面，发送参数，点击登录需要发送post的请求，
         * 请求路径是/userLogin
         */

        //自动配置注销功能
        //访问/logout,清空session
        //注销成功后去主页
        http.logout().logoutSuccessUrl("/");

        /**
         * 开启记住我功能
         * 对应的input标签里name的值就是remember
         */
        http.rememberMe().rememberMeParameter("remember");
        //默认cookie生命周期是14天
        //登录成功后将cookie发给浏览器保存，以后登录带上cookie，通过检查就可以免登录
        //点击注销也会删除cookie
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth);
        auth.inMemoryAuthentication().withUser("zhangsan").password("123456").roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password("123456").roles("VIP2", "VIP3");
    }

}

