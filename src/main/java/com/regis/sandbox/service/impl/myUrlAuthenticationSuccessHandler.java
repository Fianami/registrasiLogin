package com.regis.sandbox.service.impl;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class myUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	protected Log logger = LogFactory.getLog(this.getClass());
	 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		
	}
	
	protected void handle(HttpServletRequest request, 
		      HttpServletResponse response, Authentication authentication) throws IOException {
		        String targetUrl = determineTargetUrl(authentication);
		 
		        if (response.isCommitted()) {
		            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
		            return;
		        }
		 
		        redirectStrategy.sendRedirect(request, response, targetUrl);
		    }
	protected String determineTargetUrl(Authentication authentication) {
        boolean isadmindaftar = false;
        boolean isadminperiksa = false;
        boolean isapoteker = false;
        boolean iskasir = false;
        boolean issuperadmin = false;
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN_DAFTAR")) {
            	isadmindaftar = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN_PERIKSA")) {
            	isadminperiksa = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_APOTEKER")) {
            	isapoteker = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_KASIR")) {
            	iskasir = true;
                break;
            }else if (grantedAuthority.getAuthority().equals("ROLE_SUPER_ADMIN")) {
            	issuperadmin = true;
                break;
            }
        }
 
        if (isadmindaftar) {
            return "/home_admin_daftar";
        } else if (isadminperiksa) {
            return "/home_admin_periksa";
        } else if (isapoteker) {
            return "/home_apoteker";
        } else if (iskasir) {
            return "/home_kasir";
        } else if (issuperadmin) {
            return "/home_super_admin";
        } else {
            throw new IllegalStateException();
        }
    }
	
	 protected void clearAuthenticationAttributes(HttpServletRequest request) {
	        HttpSession session = request.getSession(false);
	        if (session == null) {
	            return;
	        }
	        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	    }
	 
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }
	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }
	

}
