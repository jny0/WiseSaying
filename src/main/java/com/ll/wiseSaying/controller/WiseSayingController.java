package com.ll.wiseSaying.controller;

import com.ll.Container;
import com.ll.wiseSaying.entity.WiseSaying;
import com.ll.Rq;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    private List<WiseSaying> wiseSayings;
    private long lastWiseSayingId ;

    public WiseSayingController() {
        this.wiseSayings = new ArrayList<>();
        this.lastWiseSayingId = 0;
    }


    public void write(){
        long id = lastWiseSayingId +1;
        System.out.print("명언 : ");
        String 명언 = Container.getScanner().nextLine().trim();

        System.out.print("작가 : ");
        String 작가 = Container.getScanner().nextLine().trim();

        wiseSayings.add(new WiseSaying(id, 명언, 작가));

        System.out.println(id + "번 명언이 등록되었습니다.");

        lastWiseSayingId = id; // 증가
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for(int i = wiseSayings.size()-1; i>=0;  i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.println(wiseSaying.toString());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);

        if (wiseSaying==null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }


        wiseSayings.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    private WiseSaying findById(int id) {
        for(WiseSaying wiseSaying : wiseSayings){
            if(wiseSaying.getId() == id){
                return wiseSaying;
            }
        }
        return null;
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = findById(id);
        System.out.printf("명언(기존) : %s \n명언 : ", wiseSaying.get명언());
        wiseSaying.set명언(Container.getScanner().nextLine().trim());
        System.out.printf("작가(기존) : %s \n작가 : ", wiseSaying.get작가());
        wiseSaying.set작가(Container.getScanner().nextLine().trim());

    }
}
