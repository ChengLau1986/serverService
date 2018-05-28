package com.lzapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
    private static Logger log = LoggerFactory.getLogger(test.class);
    public static void main(String[] args) {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
    }
}
