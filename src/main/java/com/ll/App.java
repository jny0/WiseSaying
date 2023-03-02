package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public void run() {
        System.out.println("==명언 앱==");

        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
        long lastWiseSayingId = 0;

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController();

        while (lastWiseSayingId >= 0) {

            System.out.print("명령) ");
            String input = Container.getScanner().nextLine().trim();
            Rq rq = new Rq(input);

            switch (rq.getActionCode()) {
                case "종료":
                    systemController.exit();
                    return;
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
            }


        }
    }
}

