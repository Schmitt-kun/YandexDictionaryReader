package ru.schmidt.dictionaryreader.dto;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private String text;
    private String pos;
    private String gen;
    private String translate;
    private List<String> translateSynonyms = new ArrayList<>();

    public Response(ResponseJson responseJson) {
        text = responseJson.def[0].text;
        pos = responseJson.def[0].pos;
        gen = responseJson.def[0].gen;
        for (ResponseJson.Translate translates : responseJson.def[0].tr) {
            translateSynonyms.add(translates.text);
        }
    }

    public static ResponseJson getJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ResponseJson.class);
    }

    public static String test(String json) {
        Gson gson = new Gson();
        ResponseJson respJson = gson.fromJson(json, ResponseJson.class);
        return respJson.def[0].text + " " + respJson.def[0].tr[0].text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public List<String> getTranslateSynonyms() {
        return translateSynonyms;
    }

    public void setTranslateSynonyms(List<String> translateSynonyms) {
        this.translateSynonyms = translateSynonyms;
    }

    @Override
    public String toString() {
        return "ResponseJson{" +
                "text='" + text + '\'' +
                ", pos='" + pos + '\'' +
                ", gen='" + gen + '\'' +
                ", translate='" + translate + '\'' +
                ", translateSynonyms=" + translateSynonyms +
                '}';
    }
}
