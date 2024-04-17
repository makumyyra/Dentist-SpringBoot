package Lab24.hammaslaakari;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/* Luokka tehty ChatGPT:n avulla 11.4.24 klo 22:34 --> 
Kun kysyin, "How do I guide admin to admin_index" (liitin kysymykseen sovelluksen luokan WebSecurityConfig.java), ChatGPT:n vastaus oli:
"To specify different default success URLs for different user roles, you can use the defaultSuccessUrl method with an 
AuthenticationSuccessHandler that determines the appropriate URL based on the user's role.
First, define a custom AuthenticationSuccessHandler implementation that redirects users based on their roles. 
Then, inject this custom success handler into your WebSecurityConfig class and use it in the formLogin configuration"

ChatGPT teki luokasta esimerkin, joka tarkistukseni mukaan olisi sopinut tarkoitukseeni. Alla suora kopio. En kuitenkaan saanut tätä toimimaan.
 * 
 */

@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        String redirectUrl = "/user_index";
        if (request.isUserInRole("ADMIN")) {
            redirectUrl = "/admin_index";
        }
        response.sendRedirect(request.getContextPath() + redirectUrl);
    }

    // @Bean
    // public AuthenticationHandler authenticationHandler() {
    // return new AuthenticationHandler();
    // }

}
