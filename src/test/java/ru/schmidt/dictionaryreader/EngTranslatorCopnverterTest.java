package ru.schmidt.dictionaryreader;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.schmidt.dictionaryreader.dto.Response;
import ru.schmidt.dictionaryreader.dto.Word;
import ru.schmidt.dictionaryreader.translators.Converter;
import ru.schmidt.dictionaryreader.translators.Translator;

public class EngTranslatorCopnverterTest {
    private final Logger logger = LoggerFactory.getLogger(EngTranslatorCopnverterTest.class);
    
    @Test
    public void translatorTest() throws Throwable{
        Translator t = new Translator("ru-en");
        String res = t.translate("источник");
        Response r = new Response(Response.getJson(res));
        logger.info(r.toString());
        Word w = Converter.convert(r);
        logger.info(w.toString());
        Assert.assertNotNull(w);
    }

    @Test
    public void translatorEnRuTest() throws Throwable{
        Translator t = new Translator("en-ru");
        String res = t.translate("source");
        Response r = new Response(Response.getJson(res));
        logger.info("{}", r);
        Word w = Converter.convert(r);
        logger.info("{}", w);
        Assert.assertNotNull(w);
    }
}
