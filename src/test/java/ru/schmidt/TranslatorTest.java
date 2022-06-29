package ru.schmidt;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.schmidt.dictionaryreader.dto.Response;
import ru.schmidt.dictionaryreader.translators.Translator;

public class TranslatorTest {
    private final Logger logger = LoggerFactory.getLogger(TranslatorTest.class);
    
    @Test
    public void translatorTest() throws Throwable{
        Translator t = new Translator("ru-de");
        String res = t.translate("Магия");
        Response r = new Response(Response.getJson(res));
        logger.info(r.toString());
        Assert.assertNull(null);
    }
}
