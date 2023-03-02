package WiseSaying;

import java.util.ArrayList;
import java.util.Scanner;

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

            }


        }
    }
}

