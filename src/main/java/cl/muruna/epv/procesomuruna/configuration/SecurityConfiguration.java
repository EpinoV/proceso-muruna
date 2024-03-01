package cl.muruna.epv.procesomuruna.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] AUTH_WHITE_LIST = {
            // -- Swagger UI v2
            "/proceso-muruna/doc/v2/api-docs",
            "/proceso-muruna/doc/swagger-resources",
            "/proceso-muruna/doc/swagger-resources/**",
            "/proceso-muruna/doc/configuration/ui",
            "/proceso-muruna/doc/configuration/security",
            "/proceso-muruna/doc/swagger-ui.html",
            "/proceso-muruna/doc/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/proceso-muruna/doc/v3/api-docs/**",
            "/proceso-muruna/doc/swagger-ui/**",
            "/proceso-muruna/doc/**",
            "/proceso-muruna/api/v1/auth/**",

            "/swagger-ui/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/v2/api-docs",
            "/configuration/ui",
            "/configuration/security"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        AUTH_WHITE_LIST
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return httpSecurity.build();
    }
}
