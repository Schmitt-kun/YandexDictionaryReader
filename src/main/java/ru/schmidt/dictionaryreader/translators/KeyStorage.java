package ru.schmidt.dictionaryreader.translators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class KeyStorage {
    private static String key;
    //= "dict.1.1.20210927T190631Z.c11019384712914e.664d3a9836e350abbd1052c58d9cdd2b06177c1e";
    private static final Logger logger;

    static {
        logger = LoggerFactory.getLogger(KeyStorage.class);
        ClassPathResource cpr = new ClassPathResource("/yandex.key");
        try {
            File file = cpr.getFile();
            key = new String(Files.readAllBytes(file.toPath()));
            logger.info("Key loaded : {}", key);
        } catch (IOException e) {
            logger.error("Key loading error:", e);
        }
    }

    public static String getKey() {
        return key;
    }
}
