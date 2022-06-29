package ru.schmidt.dictionaryreader.translators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Translator {
    private final Logger logger = LoggerFactory.getLogger(Translator.class);
    private final String dict;
    private final String key;
    private final String baseUri = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=%s&lang=%s&&text=%s";

    public Translator(String dict) {
        this.dict = dict;
        key = KeyStorage.getKey();

    }

    public String translate(String text) throws Throwable {
        String uri = String.format(baseUri, key, dict, text);

        SSLContext ctx = SSLContext.getInstance("TLS");
        URL url = new URL(uri);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        int code = connection.getResponseCode();
        String response = connection.getResponseMessage();
        logger.info("Code {}, Text: {}", code, response);

        if (code != 200)
            return null;


        StringBuilder result = new StringBuilder();
        try (InputStream is = connection.getInputStream()) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
