package com.saurabh.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.constant.ConstantDescs.CD_String;
import static java.lang.constant.ConstantDescs.CD_void;
import static java.lang.constant.ConstantDescs.MTD_void;
import static java.lang.classfile.ClassFile.ACC_PUBLIC;
import static java.lang.classfile.ClassFile.ACC_STATIC;

/**
 * JEP 484 — Class-File API (final in JDK 24).
 *
 * <p>A standard, in-JDK API for reading, transforming, and writing {@code .class}
 * files. Replaces ad-hoc dependence on third-party libraries like ASM, Byte Buddy,
 * or Javassist for tools that just need to peek at or rewrite bytecode.
 *
 * <p>This demo does two things:
 * <ol>
 *   <li>parses {@link ClassFileApiDemo}'s own {@code .class} file and lists every method;</li>
 *   <li>emits a tiny synthetic {@code Generated} class with a {@code main} method that
 *       just returns, then writes it to {@code java.io.tmpdir}.</li>
 * </ol>
 */
public class ClassFileApiDemo {

    private static final Logger LOG = LoggerFactory.getLogger(ClassFileApiDemo.class);

    public static void main(String[] args) throws Exception {
        readOwnClass();
        var generated = writeSyntheticClass();
        LOG.info("synthetic class written to {}", generated);
    }

    private static void readOwnClass() throws Exception {
        var url = ClassFileApiDemo.class.getResource("ClassFileApiDemo.class");
        if (url == null) {
            LOG.warn("class file not found on the classpath; run after `mvn compile`");
            return;
        }
        try (var in = url.openStream()) {
            ClassModel model = ClassFile.of().parse(in.readAllBytes());
            LOG.info("parsed {} ({} methods)", model.thisClass().asInternalName(), model.methods().size());
            model.methods().forEach(m ->
                    LOG.info("  {} {}", m.methodName().stringValue(), m.methodTypeSymbol().displayDescriptor())
            );
        }
    }

    private static Path writeSyntheticClass() throws Exception {
        ClassDesc generated = ClassDesc.of("com.saurabh.java.Generated");
        MethodTypeDesc mainSig = MethodTypeDesc.of(CD_void, CD_String.arrayType());

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

        Path out = Path.of(System.getProperty("java.io.tmpdir"), "Generated.class");
        Files.write(out, bytes);
        return out;
    }
}
