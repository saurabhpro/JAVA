package com.saurabh.java;

import org.junit.jupiter.api.Test;

import java.lang.classfile.ClassFile;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;

import static java.lang.classfile.ClassFile.ACC_PUBLIC;
import static java.lang.classfile.ClassFile.ACC_STATIC;
import static java.lang.constant.ConstantDescs.CD_String;
import static java.lang.constant.ConstantDescs.CD_void;
import static java.lang.constant.ConstantDescs.MTD_void;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the Class-File API (JEP 484, final in JDK 24). Demonstrates that the
 * standard JDK API can both read existing bytecode and emit a usable {@code .class}
 * file from scratch — exactly the use cases that previously required ASM.
 */
class ClassFileApiDemoTest {

    @Test
    void parses_existing_class_and_finds_main_method() {
        // given
        var url = ClassFileApiDemo.class.getResource("ClassFileApiDemo.class");

        // when
        assertThat(url).as("compiled .class on the classpath").isNotNull();
        var bytes = readBytes(url);
        var model = ClassFile.of().parse(bytes);

        // then
        assertThat(model.thisClass().asInternalName())
                .isEqualTo("com/saurabh/java/ClassFileApiDemo");
        assertThat(model.methods())
                .extracting(m -> m.methodName().stringValue())
                .contains("main");
    }

    @Test
    void emits_synthetic_class_with_expected_shape() {
        // given
        ClassDesc generated = ClassDesc.of("com.saurabh.java.GeneratedForTest");
        MethodTypeDesc mainSig = MethodTypeDesc.of(CD_void, CD_String.arrayType());

        // when
        byte[] bytes = ClassFile.of().build(generated, classBuilder -> classBuilder
                .withFlags(ACC_PUBLIC)
                .withMethodBody("main", mainSig, ACC_PUBLIC | ACC_STATIC,
                        codeBuilder -> codeBuilder.return_())
                .withMethodBody("<init>", MTD_void, ACC_PUBLIC,
                        codeBuilder -> codeBuilder
                                .aload(0)
                                .invokespecial(ClassDesc.of("java.lang.Object"), "<init>", MTD_void)
                                .return_())
        );

        // then — round-trip the bytes back through the parser to prove they form a
        // valid class file with the expected name and methods
        var model = ClassFile.of().parse(bytes);
        assertThat(model.thisClass().asInternalName()).isEqualTo("com/saurabh/java/GeneratedForTest");
        assertThat(model.methods())
                .extracting(m -> m.methodName().stringValue())
                .containsExactlyInAnyOrder("main", "<init>");
    }

    private static byte[] readBytes(java.net.URL url) {
        try (var in = url.openStream()) {
            return in.readAllBytes();
        } catch (java.io.IOException e) {
            throw new AssertionError(e);
        }
    }
}
