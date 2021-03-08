package com.saurabh.moustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

public final class MustacheUtil {

    private static final MustacheFactory MUSTACHE_FACTORY = new DefaultMustacheFactory();

    private MustacheUtil() {
    }

    public static MustacheFactory getMustacheFactory() {
        return MUSTACHE_FACTORY;
    }

}