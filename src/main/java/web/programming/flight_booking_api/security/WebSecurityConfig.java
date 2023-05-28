package web.programming.flight_booking_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import web.programming.flight_booking_api.security.services.UserDetailsServiceImpl;
import web.programming.flight_booking_api.security.services.Jwt.AuthEntryPointJwt;
import web.programming.flight_booking_api.security.services.Jwt.AuthTokenFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //validación antes que llame al método
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizationHandler;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }
    //Este de aca abajo nos permite inyectar nuestro password encriptado, codificado
    //Escribe un password y enseguida valida con el que esta en la base de datos
    //cuando creemos un usuario en la base de datos tiene que estar encriptado o no lo vamos a poder hacer
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //El filtro de autenticación
    @Bean 
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    //Este valida si las peticiones tienen las caracteristicas para ingresar a ella o no
    //Aqui abajo esta toda la parte de seguridad
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizationHandler).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests().antMatchers("/v3/api-docs/**","/configuration/ui","/swagger-resources/**","/swagger-ui/**","/configuration/security","/swagger-ui-custom.html/**","/webjars/**").permitAll()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/model/flights/**").permitAll()
            .antMatchers("/api/model/arrivals/**").permitAll()
            .antMatchers("/api/model/departures/**").permitAll()
            .anyRequest().authenticated();

        
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
