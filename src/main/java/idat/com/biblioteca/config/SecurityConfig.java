package idat.com.biblioteca.config;

import idat.com.biblioteca.exepctions.JwtAuthenticationEntryPoint;
import idat.com.biblioteca.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                )
                .authorizeHttpRequests(authz -> authz
                        // 1. Endpoints públicos (Login y Registro)
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()

                        // 2. Reglas para LIBROS
                        // Listar libros: accesible para admin y user
                        .requestMatchers(HttpMethod.GET, "/libros/**").hasAnyAuthority("admin", "user")
                        // Crear, Editar, Borrar libros: SOLO admin
                        .requestMatchers(HttpMethod.POST, "/libros/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "/libros/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "/libros/**").hasAuthority("admin")

                        // 3. Reglas para USUARIOS
                        // Gestión de usuarios: SOLO admin
                        .requestMatchers(HttpMethod.POST, "/usuarios/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.PUT, "/usuarios/**").hasAuthority("admin")
                        .requestMatchers(HttpMethod.DELETE, "/usuarios/**").hasAuthority("admin")

                        // 4. Reglas para MOVIMIENTOS
                        // Préstamos y devoluciones: accesible para admin y user
                        .requestMatchers("/movimientos/**").hasAnyAuthority("admin", "user")

                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permitimos cualquier origen para pruebas (en producción se restringe)
        configuration.setAllowedOriginPatterns(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(false);
        configuration.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}