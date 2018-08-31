package de.cdelmonte.authentication.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;


@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Value("${security.oauth2.resource.id}")
  private String resourceId;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(resourceId).stateless(false);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.anonymous().disable().authorizeRequests().antMatchers(
        "/auth/**").authenticated().and()
        .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
  }
}
