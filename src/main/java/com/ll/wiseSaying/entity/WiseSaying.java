package com.ll.wiseSaying.entity;

public class WiseSaying {
    private long id;
    private String 명언;
    private String 작가;

    public WiseSaying (long id, String 명언, String 작가) {
        this.id = id;
        this.명언 = 명언;
        this.작가 = 작가;
    }

    public long getId() {
        return id;
    }

    public String get명언() {
        return 명언;
    }

    public String get작가() {
        return 작가;
    }

    public void set명언(String 명언) {
        this.명언 = 명언;
    }

    public void set작가(String 작가) {
        this.작가 = 작가;
    }

    @Override
    public String toString() {
        return  id + " / " + 명언 +  " / " + 작가 ;
    }
}