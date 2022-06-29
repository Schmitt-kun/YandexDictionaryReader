package ru.schmidt;

import org.junit.Assert;
import org.junit.Test;
import ru.schmidt.dictionaryreader.translators.KeyStorage;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Logger;

public class TestGetLang {
    Logger logger = Logger.getLogger("GetLang");

    String key = KeyStorage.getKey();
    @Test
    public void testGetLang() throws Throwable {
        String uri = "https://dictionary.yandex.net/api/v1/dicservice.json/getLangs?key=";

        logger.info(String.format("%s", uri + key));

        SSLContext ctx = SSLContext.getInstance("TLS");
        URL url = new URL(uri + key);
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
        while((line = reader.readLine()) != null) {
            result.append(line);
        }

        logger.info(result.toString());
        Assert.assertNull(null);
    }

}
