package com.ll.wiseSaying.service;

import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    public WiseSaying findById(long id) {
        return wiseSayingRepository.findById(id);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public long write(String 명언, String 작가) {
        return wiseSayingRepository.write(명언, 작가);
    }



    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }


    public void modify(WiseSaying wiseSaying, String 명언, String 작가) {
        wiseSayingRepository.modify(wiseSaying, 명언, 작가);
    }


}

