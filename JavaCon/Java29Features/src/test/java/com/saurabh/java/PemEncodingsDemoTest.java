package com.saurabh.java;

import org.junit.jupiter.api.Test;

import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PemEncodingsDemo} (JEP 470, preview through JDK 26). Verifies a
 * full encode → decode round-trip returns the same key material and the well-known
 * PEM markers are present in the output.
 */
class PemEncodingsDemoTest {

    @Test
    void public_key_pem_starts_with_PUBLIC_KEY_marker_and_round_trips() throws Exception {
        // given
        var kp = PemEncodingsDemo.generateKeyPair();
        var encoder = PEMEncoder.of();
        var decoder = PEMDecoder.of();

        // when
        var pem = encoder.encodeToString(kp.getPublic());
        PublicKey decoded = decoder.decode(pem, PublicKey.class);

        // then
        assertThat(pem).startsWith("-----BEGIN PUBLIC KEY-----");
        assertThat(pem).contains("-----END PUBLIC KEY-----");
        assertThat(decoded.getEncoded()).isEqualTo(kp.getPublic().getEncoded());
        assertThat(decoded.getAlgorithm()).isEqualTo("RSA");
    }

    @Test
    void private_key_pem_starts_with_PRIVATE_KEY_marker_and_round_trips() throws Exception {
        // given
        var kp = PemEncodingsDemo.generateKeyPair();
        var encoder = PEMEncoder.of();
        var decoder = PEMDecoder.of();

        // when
        var pem = encoder.encodeToString(kp.getPrivate());
        PrivateKey decoded = decoder.decode(pem, PrivateKey.class);

        // then
        assertThat(pem).startsWith("-----BEGIN PRIVATE KEY-----");
        assertThat(pem).contains("-----END PRIVATE KEY-----");
        assertThat(decoded.getEncoded()).isEqualTo(kp.getPrivate().getEncoded());
        assertThat(decoded.getAlgorithm()).isEqualTo("RSA");
    }
}
