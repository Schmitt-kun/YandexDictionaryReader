package ru.schmidt.dictionaryreader.translators;

import ru.schmidt.dictionaryreader.dto.Response;
import ru.schmidt.dictionaryreader.dto.Word;

public class Converter {
    public static Word convert(Response response) {
        StringBuilder res = new StringBuilder();
        if (response.getTranslate() != null) {
            res.append(response.getTranslate());
        }
        for (String str : response.getTranslateSynonyms()) {
            if(res.length() > 0) res.append(", ");
            res.append(str);
            if (res.length() > 64)
                break;
        }
        return new Word(res.toString(), response.getText());
    }
}
