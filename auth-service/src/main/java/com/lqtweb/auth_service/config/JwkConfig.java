package com.lqtweb.auth_service.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;
import java.util.UUID;

@Configuration
@Slf4j
public class JwkConfig {

    //Dùng để log có thể không cần config mặc định của security mã hóa sẵn
    @Bean
    public JWKSource<SecurityContext> jwkSource() throws NoSuchAlgorithmException {
        KeyPair keyPair = generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        log.info("Generated RSA Key Pair:");
        log.info("Public Key Algorithm: {}", publicKey.getAlgorithm());
        log.info("Public Key Format: {}", publicKey.getFormat());
        log.info("Public Key Modulus (Base64): {}", Base64.getEncoder().encodeToString(publicKey.getModulus().toByteArray()));
        log.info("Public Key Exponent (Base64): {}", Base64.getEncoder().encodeToString(publicKey.getPublicExponent().toByteArray()));

        log.info("Private Key Algorithm: {}", privateKey.getAlgorithm());
        log.info("Private Key Format: {}", privateKey.getFormat());

        RSAKey rsaKey = new RSAKey.Builder(publicKey)
                .privateKey(privateKey)
                .keyID(UUID.randomUUID().toString())
                .build();

        JWKSet jwkSet = new JWKSet(rsaKey);
        log.info("JWKSet: {}", jwkSet.toJSONObject());

        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);

    }

    private KeyPair generateRsaKey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Key size 2048 bits
        return keyPairGenerator.generateKeyPair();
    }


}