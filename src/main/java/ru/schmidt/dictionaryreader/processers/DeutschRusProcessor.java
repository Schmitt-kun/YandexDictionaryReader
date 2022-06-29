package ru.schmidt.dictionaryreader.processers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.schmidt.dictionaryreader.dto.Response;
import ru.schmidt.dictionaryreader.dto.Word;

public class DeutschRusProcessor {
    private Logger logger = LoggerFactory.getLogger(DeutschRusProcessor.class);

    public Word process(Response response) {
        logger.info("Start processing: {}", response.getText());
        Word word = new Word(response.getText(), "");

        if ("noun".equals(response.getPos())) {
            String article;
            switch(response.getGen()) {
                case "м":
                    article = "der ";
                    break;
                case "ж":
                    article = "die ";
                    break;
                case "с":
                    article = "das ";
                    break;
                default:
                    article = "";
            }
            //word.setForeignLang(article + word.getForeignLang());
        }

        StringBuilder translate = new StringBuilder("");
        if (response.getTranslate() != null) {
            translate.append(response.getTranslate());
        }
        if (response.getTranslateSynonyms() != null && !response.getTranslateSynonyms().isEmpty()) {
            for (int i = 0; i < 3 && i <= response.getTranslateSynonyms().size(); i++) {
                if (translate.length() != 0)
                    translate.append(", ");
                translate.append(response.getTranslateSynonyms().get(i));
            }
        }
        word.setNativeLang(translate.toString());
        return word;
    }
}
