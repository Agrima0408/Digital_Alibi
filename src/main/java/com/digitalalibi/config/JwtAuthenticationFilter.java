package com.digitalalibi.config;

import com.digitalalibi.service.CustomUserDetailsService;
import com.digitalalibi.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(
            JwtService jwtService,
            CustomUserDetailsService userDetailsService) {

        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        //Retrieves the JWT sent by Postman or your frontend.

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);//Remove Bearer
        String email = jwtService.extractEmail(token);//Extract email

        if (email != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(email); //Load the user

            if (jwtService.validateToken(token)) {

                UsernamePasswordAuthenticationToken authentication =
                        //Creates an authenticated Spring Security object.
                        new UsernamePasswordAuthenticationToken(
                                userDetails, //The user we loaded from the database
                                null,//No password credentials needed for this JWT authentication
                                userDetails.getAuthorities() //User's granted permissions
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );
                //Store authentication: Now Spring Security knows which user is making this request.
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }
        //Allows the request to proceed to the next filter.
        filterChain.doFilter(request, response);
    }
}
