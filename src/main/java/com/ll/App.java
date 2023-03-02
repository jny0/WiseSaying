package com.ll;

import java.util.ArrayList;
import java.util.Scanner;
import com.ll.wiseSaying.entity.WiseSaying;

public class App {
    private final Scanner sc;
    public App (Scanner sc){
        this.sc = sc;
    }

    public void run() {
        System.out.println("==명언 앱==");

        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();

        long lastWiseSayingId  = 0;
        while( lastWiseSayingId >= 0 ){
            System.out.print("명령) ");
            String input = sc.nextLine().trim();

            if(input.equals("등록")){

                long id = lastWiseSayingId +1;
                System.out.print("명언 : ");
                String 명언 = sc.nextLine();

                System.out.print("작가 : ");
                String 작가 = sc.nextLine();

                wiseSayings.add(new WiseSaying(id, 명언, 작가));

                System.out.println(id + "번 명언이 등록되었습니다.");

                lastWiseSayingId = id; // 증가

            } else if(input.equals("종료")){
                break;
            } else if(input.equals("목록")){
                System.out.println("번호 / 작가 / 명언");
                System.out.println("-".repeat(30));

                for(int i = 0; i< wiseSayings.size(); i++){
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.get작가(), wiseSaying.get명언());
                }

            } else if (input.contains("삭제")){
                String[] splitList = input.split("id=");
                int count = 0;

                for(int i = 0; i< wiseSayings.size(); i++){
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    if(wiseSaying.getId()==Integer.valueOf(splitList[1])) {
                        wiseSayings.remove(i);
                        System.out.println(splitList[1]+"번 명언이 삭제되었습니다.");
                        count++;
                    }
                }

                if(count ==0){
                    System.out.println((splitList[1])+"번 명언은 존재하지 않습니다.");
                }
            } else if (input.contains("수정")){
                String[] splitList = input.split("id=");

                for(int i = 0; i< wiseSayings.size(); i++){
                    WiseSaying wiseSaying = wiseSayings.get(i);
                    if(wiseSaying.getId()==Integer.valueOf(splitList[1])) {
                        System.out.printf("명언(기존) %s \n명언 : ", wiseSaying.get명언());
                        wiseSaying.set명언(sc.nextLine());
                        System.out.printf("작가(기존) %s \n작가 : ", wiseSaying.get작가());
                        wiseSaying.set작가(sc.nextLine());
                    }
                }

            }
        }
    }
}

