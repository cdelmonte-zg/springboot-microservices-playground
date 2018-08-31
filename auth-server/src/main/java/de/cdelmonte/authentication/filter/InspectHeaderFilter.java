package de.cdelmonte.authentication.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class InspectHeaderFilter implements Filter {

  private static final Logger LOGGER = LoggerFactory.getLogger(InspectHeaderFilter.class);

  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    LOGGER.debug("I AM HITTING THE AUTH SERVER: {}", httpServletRequest.getHeader("Authorization"));
    chain.doFilter(httpServletRequest, response);
  }

  @Override
  public void destroy() {
    // Auto-generated method stub
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // Auto-generated method stub  
  }
}
