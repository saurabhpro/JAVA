package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * JEP 470 — PEM Encodings of Cryptographic Objects (preview through JDK 26).
 *
 * <p>Before this JEP, reading or writing the {@code -----BEGIN PRIVATE KEY-----}
 * format meant pulling in BouncyCastle or hand-stitching Base64 + DER. JEP 470
 * promotes PEM to a first-class encoding alongside DER via {@link PEMEncoder}
 * and {@link PEMDecoder} in {@code java.security}.
 *
 * <p>Compile + run with {@code --enable-preview}.
 */
public class PemEncodingsDemo {

    private static final Logger LOG = LoggerFactory.getLogger(PemEncodingsDemo.class);

    public static void main(String[] args) throws Exception {
        var kp = generateKeyPair();
        var publicPem = PEMEncoder.of().encodeToString(kp.getPublic());
        var privatePem = PEMEncoder.of().encodeToString(kp.getPrivate());

        LOG.info("public PEM:\n{}", publicPem);
        LOG.info("private PEM (truncated): {}…", privatePem.substring(0, Math.min(privatePem.length(), 64)));

        PublicKey decodedPublic = PEMDecoder.of().decode(publicPem, PublicKey.class);
        PrivateKey decodedPrivate = PEMDecoder.of().decode(privatePem, PrivateKey.class);
        LOG.info("round-trip public  algo={} format={}", decodedPublic.getAlgorithm(), decodedPublic.getFormat());
        LOG.info("round-trip private algo={} format={}", decodedPrivate.getAlgorithm(), decodedPrivate.getFormat());
    }

    static KeyPair generateKeyPair() throws Exception {
        var generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        return generator.generateKeyPair();
    }
}
