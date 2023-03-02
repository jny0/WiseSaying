package words;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("==명언 앱==");

        int i = 1;
        while( i>0 ){
            System.out.print("명령) ");
            String input = sc.nextLine();

            if(input.equals("등록")){
                System.out.print("명언 : ");
                String 명언 = sc.nextLine();

                System.out.print("작가 : ");
                String 작가 = sc.nextLine();
                System.out.println(i + "번 명언이 등록되었습니다.");
                i++;
            } else if(input.equals("종료")){
                break;
            }
        }

        sc.close();

    }
}
