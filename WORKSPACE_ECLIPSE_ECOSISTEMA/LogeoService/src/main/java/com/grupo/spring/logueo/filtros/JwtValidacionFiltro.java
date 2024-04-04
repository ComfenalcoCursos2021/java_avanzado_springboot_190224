package com.grupo.spring.logueo.filtros;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidacionFiltro extends BasicAuthenticationFilter {

	private ObjectMapper mapper = new ObjectMapper();
	
	public JwtValidacionFiltro(AuthenticationManager authManValue) {
		super(authManValue);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}
		
		String token = header.replace("Bearer ", "");
		try {
			Claims claims = Jwts.parser().verifyWith(JwtLogueoFiltro.SECRET).build()
					.parseSignedClaims(token).getBody();
			UsernamePasswordAuthenticationToken authToken
			= new UsernamePasswordAuthenticationToken(
				claims.getSubject(), null, null
			);
			
			SecurityContextHolder.getContext().setAuthentication(authToken);
			chain.doFilter(request, response);
		} catch (Exception e) {
			Map<String, String> error = new HashMap<>();
			error.put("error", e.getMessage());
			response.getWriter().write(mapper.writeValueAsString(error));
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
		}
		
		
	}
	
	
}
