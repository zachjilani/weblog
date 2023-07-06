package com.weblog.security;

import com.weblog.views.LoginView;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

import com.vaadin.flow.spring.security.VaadinWebSecurity;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends VaadinWebSecurity {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    setLoginView(http, LoginView.class);

  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().requestMatchers("/images/**");
    super.configure(web);
  }

  @Bean
  protected UserDetailsService userDetailsService() {
    UserDetails user = User.withUsername("user")
        .password("{noop}userpass")
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
  }

}
