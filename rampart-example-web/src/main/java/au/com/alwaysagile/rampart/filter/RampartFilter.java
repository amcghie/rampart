package au.com.alwaysagile.rampart.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class RampartFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(RampartFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Optional.of(servletRequest)
                .filter(HttpServletRequest.class::isInstance)
                .map(HttpServletRequest.class::cast)
                .ifPresent(request -> {
                    LOGGER.info("remoteAddr={}, remoteHost={}, method={}, requestURI={}, requestURL={}, xForwardedFor={}, userAgent={}",
                            request.getRemoteAddr(),
                            request.getRemoteHost(),
                            request.getMethod(),
                            request.getRequestURI(),
                            request.getRequestURL(),
                            request.getHeader("X-Forwarded-For"),
                            request.getHeader("User-Agent"));
                });
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
