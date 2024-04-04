package com.grupo.spring.logueo.filtros;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo.spring.logueo.dtos.LoginDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtLogueoFiltro extends UsernamePasswordAuthenticationFilter {

	public static final SecretKey SECRET = Jwts.SIG.HS256.key().build();
	private AuthenticationManager authMan;
	private ObjectMapper mapper = new ObjectMapper();
	public JwtLogueoFiltro(AuthenticationManager authManValue) {
		super(authManValue);
		this.authMan = authManValue;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		LoginDto dto = null;
		String nick = null;
		String pass = null;
		
		
		try {
			dto = mapper.readValue(request.getInputStream(), LoginDto.class);
			nick = dto.getNick();
			pass = dto.getPass();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UsernamePasswordAuthenticationToken loQueLeSirveASpring = new UsernamePasswordAuthenticationToken(nick, pass);
		
		return this.authMan.authenticate(loQueLeSirveASpring);
		
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		Map<String, String> errorMapa = new HashMap<>();
		
		errorMapa.put("error", failed.getMessage());
		errorMapa.put("mensaje","ERROR ERROR ERROR");
		
		response.getWriter().write(mapper.writeValueAsString(errorMapa));
		response.setStatus(401);
		response.setContentType("application/json");
		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		User elUsuario = (User) authResult.getPrincipal();
		
		String nick = elUsuario.getUsername();
		
		Claims claims = Jwts.claims().add("nick", nick).build();
		
		String token = Jwts.builder()
				.subject(nick)
				.claims(claims)
				.expiration(new Date(System.currentTimeMillis()+3600000))
				.issuedAt(new Date())
				.signWith(SECRET)
				.compact();
		
		Map<String,String> mapa = new HashMap<>();
		mapa.put("token", token);
		mapa.put("nick", nick);
		mapa.put("mensaje", String.format("Bienvenido %s", nick));
		
		response.getWriter().write(mapper.writeValueAsString(mapa));
		response.setStatus(200);
		response.setContentType("application/json");
		
	}
	
	
	
	
	
	
	
}
