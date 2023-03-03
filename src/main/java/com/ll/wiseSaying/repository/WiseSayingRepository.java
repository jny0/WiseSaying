package com.ll.wiseSaying.repository;

import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private final List<WiseSaying> wiseSayings;
    private long lastWiseSayingId ;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastWiseSayingId = 0;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById(long id) {
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.getId() == id){
                return wiseSaying;
            }
        }
        return null;
    }

    public long write(String 명언, String 작가) {
        long id = lastWiseSayingId +1;

        wiseSayings.add(new WiseSaying(id, 명언, 작가));

        lastWiseSayingId = id; // 증가

        return id;
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);

    }
    public void modify(WiseSaying wiseSaying, String 명언, String 작가) {
        wiseSaying.set명언(명언);
        wiseSaying.set작가(작가);
    }
}
