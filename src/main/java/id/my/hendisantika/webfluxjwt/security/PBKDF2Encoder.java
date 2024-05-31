package id.my.hendisantika.webfluxjwt.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

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
    private Integer keyLength;

    /**
     * More info (https://www.owasp.org/index.php/Hashing_Java) 404 :(
     *
     * @param cs password
     * @return encoded password
     */
    @Override
    public String encode(CharSequence cs) {
        try {
            byte[] result = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(new PBEKeySpec(cs.toString().toCharArray(), secret.getBytes(), iteration, keyLength))
                    .getEncoded();
            return Base64.getEncoder().encodeToString(result);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        return encode(cs).equals(string);
    }
}
