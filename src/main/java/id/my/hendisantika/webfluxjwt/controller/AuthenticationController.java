package id.my.hendisantika.webfluxjwt.controller;

import id.my.hendisantika.webfluxjwt.dto.AuthRequest;
import id.my.hendisantika.webfluxjwt.dto.AuthResponse;
import id.my.hendisantika.webfluxjwt.security.JWTUtil;
import id.my.hendisantika.webfluxjwt.security.PBKDF2Encoder;
import id.my.hendisantika.webfluxjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-webflux-jwt
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/31/24
 * Time: 09:50
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final JWTUtil jwtUtil;
    private final PBKDF2Encoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest ar) {
        return userService.findByUsername(ar.getUsername())
                .filter(userDetails -> passwordEncoder.encode(ar.getPassword()).equals(userDetails.getPassword()))
                .map(userDetails -> ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(userDetails))))
                .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
}
