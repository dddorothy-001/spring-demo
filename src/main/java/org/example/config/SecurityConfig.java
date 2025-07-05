package org.example.config;

import org.example.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(myUserDetailService)
//                .passwordEncoder(passwordEncoder())
//                .and()
//                .build();
//    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/bye/**").hasRole("ADMIN")
//                        .requestMatchers("/test/**").hasAnyRole("USER", "ADMIN")
                                .requestMatchers("/zk/*").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults());  // 配置 AuthenticationManager

        return http.build();
    }


//
//    @Bean
//    public UserDetailsService userDetailsService() {
////        UserDetails admin = User.builder()
////                .username("admin")
////                .password(passwordEncoder().encode("123456"))
////                .roles("ADMIN", "USER")
////                .build();
////
////        UserDetails user = User.builder()
////                .username("user")
////                .password(passwordEncoder().encode("123456"))
////                .roles("USER")
////                .build();
////
////        return new InMemoryUserDetailsManager(admin, user);
//        return myUserDetailService;
//    }


//    密码加密器（如 BCrypt）
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

////    自定义认证逻辑（如从数据库加载用户）：
//    @Bean
//    public AuthenticationManager authenticationManager(
//            AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//
////    自定义用户数据来源（替代默认的内存用户）：
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            // 从数据库或其他地方加载用户
//            UserDetails user = ...;
//            return user;
//        };
//    }
//
////    跨域配置：
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(List.of("https://example.com"));
//        config.setAllowedMethods(List.of("GET", "POST"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//        return source;
//    }
//
////    为不同 URL 路径定义不同的安全规则：
//    @Bean
//    @Order(1)  // 优先级
//    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
//        http.securityMatcher("/api/**")  // 只对 /api 生效
//                .authorizeHttpRequests(auth -> auth.anyRequest().hasRole("API"));
//        return http.build();
//    }
//    @Bean
//    @Order(2)  // 更低优先级
//    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//        return http.build();
//    }
//
////    自定义退出登录逻辑：
//    @Bean
//    public RememberMeServices rememberMeServices() {
//        return new TokenBasedRememberMeServices("密钥", userDetailsService());
//    }
//
////    自定义认证方式（如短信验证码登录）：
//    @Bean
//    public AuthenticationProvider customAuthProvider() {
//        return new CustomAuthenticationProvider();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // 禁用 CSRF（如果是 API 服务）
//                .csrf(csrf -> csrf.disable())
//
//                // 配置请求授权规则
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/public/**").permitAll()
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .anyRequest().authenticated()
//                )
//
//                // 表单登录配置
//                .formLogin(form -> form
//                        .loginPage("/login")  // 自定义登录页
//                        .defaultSuccessUrl("/home")
//                        .permitAll()
//                )
//
//                // 记住我功能
//                .rememberMe(remember -> remember
//                        .tokenValiditySeconds(86400)
//                )
//
//                // 退出登录配置
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout")
//                )
//
//                // 异常处理（无权限时跳转）
//                .exceptionHandling(ex -> ex
//                        .accessDeniedPage("/403")
//                );
//
//        return http.build();
//    }
}