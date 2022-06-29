package ru.schmidt.dictionaryreader;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.schmidt.dictionaryreader.translators.KeyStorage;

public class KeyStorageTest {
    Logger logger = LoggerFactory.getLogger(KeyStorageTest.class);

    @Test
    public void KeyStorageTest() {
        logger.info("Key Storage Test start");
        String key = KeyStorage.getKey();
        logger.info("Key: {}", key);
        Assert.assertNotNull(key);
        logger.info("Key Storage Test finished");
    }
}
