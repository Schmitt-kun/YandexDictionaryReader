package ru.schmidt;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.schmidt.dictionaryreader.dto.Response;
import ru.schmidt.dictionaryreader.processers.DeutschRusProcessor;
import ru.schmidt.dictionaryreader.translators.KeyStorage;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class TestTranslate {
    private final Logger logger = LoggerFactory.getLogger(TestTranslate.class);
    private final String key = KeyStorage.getKey();
    private DeutschRusProcessor dp = new DeutschRusProcessor();

    @Test
    public void translateTest() {
        translate("поток");
        translate("хватать");
        translate("медный");
        translate("быстро");
        translate("к");
    }

    public void translate(String text) {
        String baseUri = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=";
        String lang = "ru-de";

        String uri = baseUri + key + "&lang=" + lang + "&text=" + text;
        logger.info(String.format("%s", uri));
        try {
            SSLContext ctx = SSLContext.getInstance("TLS");
            URL url = new URL(uri);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            int code = connection.getResponseCode();
            logger.info("Result: " + code);
            String res = connection.getResponseMessage();

            logger.info(res);
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            logger.info(result.toString());
            logger.info(Response.test(result.toString()));
            Response r = new Response(Response.getJson(result.toString()));
            logger.info(r.toString());
            //logger.info(dp.process(r).toString());
            Assert.assertNull(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
