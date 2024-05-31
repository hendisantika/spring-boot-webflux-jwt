package id.my.hendisantika.webfluxjwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
@Component
public class JWTUtil {

    @Value("${app.jjwt.secret}")
    private String secret;

    @Value("${app.jjwt.expiration}")
    private String expirationTime;

    private Key key;

}