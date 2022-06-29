package ru.schmidt.dictionaryreader.dto;

public class Word {
    private String nativeLang;
    private String foreignLang;

    public Word(String foreignLang, String nativeLang) {
        this.nativeLang = nativeLang;
        this.foreignLang = foreignLang;
    }

    public String getNativeLang() {
        return nativeLang;
    }

    public void setNativeLang(String nativeLang) {
        this.nativeLang = nativeLang;
    }

    public String getForeignLang() {
        return foreignLang;
    }

    public void setForeignLang(String foreignLang) {
        this.foreignLang = foreignLang;
    }

    @Override
    public String toString() {
        return "Word{" +
                "nativeLang='" + nativeLang + '\'' +
                ", foreignLang='" + foreignLang + '\'' +
                '}';
    }
}
