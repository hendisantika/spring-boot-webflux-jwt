package id.my.hendisantika.webfluxjwt.security;

import lombok.AllArgsConstructor;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 08:48
 * To change this template use File | Settings | File Templates.
 */
@AllArgsConstructor
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

    private AuthenticationManager authenticationManager;
    private SecurityContextRepository securityContextRepository;
}
