package ru.schmidt.dictionaryreader.dto;

import java.util.Map;

public class ResponseJson {
    public class Def{
        public String text;
        public String pos;
        public String gen;
        public String anm;
        public Translate[] tr;
    }

    public class Translate {
        public String text;
        public String pos;

        public String gen;
        public Field[] syn;
        public Field[] mean;
        public Example[] ex;
    }

    public class Field {
        public String text;
    }

    public class Example {
        public String text;
        public Field[] tr;
    }

    public Field head;
    public Def[] def;
}
