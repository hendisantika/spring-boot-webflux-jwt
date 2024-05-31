package id.my.hendisantika.webfluxjwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 08:46
 * To change this template use File | Settings | File Templates.
 */
@Component
public class PBKDF2Encoder implements PasswordEncoder {

    @Value("${app.password.encoder.secret}")
    private String secret;

    @Value("${app.password.encoder.iteration}")
    private Integer iteration;

    @Value("${app.password.encoder.keylength}")
    private Integer keylength;

}
