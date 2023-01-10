import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballTest {
    static void run(Scanner sc, List<Integer> com) {
        setNum(com);
        while(true) {
            System.out.print("숫자를 입력해주세요 : ");
            int num = sc.nextInt();
            if (num < 100 || num > 999) {
                throw new IllegalArgumentException();
            }
            // 확인 차 컴퓨터의 숫자 표시
            System.out.println("컴퓨터: "  + com.get(0) + com.get(1) + com.get(2));
            // 볼, 스트라이크를 출력해주고 3스트라이크일 때는 true 값을 반환하는 check 메소드
            if(check(num, com)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                com.clear();
                break;
            }
        }
    }
    // 3자리 무작위 수 생성
    static void setNum(List<Integer> com) {
        while(com.size() < 3) {
            int randomNum = (int)(Math.random()*9) + 1;
            if(!com.contains(randomNum)) {
                com.add(randomNum);
            }
        }
    }

    // 사용자가 입력받은 숫자와 컴퓨터의 숫자를 비교하여 출력
    static boolean check(int num, List<Integer> com) {
        int strike = 0, ball = 0;
        //사용자가 입력한 숫자를 각 자릿수로 나누기
        int num1 = num / 100;
        int num2 = (num / 10) - (num / 100) * 10;
        int num3 = num - (num1 * 100 + num2 * 10);

        int comNum1 = com.get(0);
        int comNum2 = com.get(1);
        int comNum3 = com.get(2);

        if(com.contains(num1)) {
            if(num1 == comNum1) {
                strike++;
            } else ball++;
        }
        if(com.contains(num2)) {
            if(num2 == comNum2) {
                strike++;
            } else ball++;
        }
        if(com.contains(num3)) {
            if(num3 == comNum3) {
                strike++;
            } else ball++;
        }
        if(strike == 0) {
            if(ball == 0) {
                System.out.println("낫싱");
            }
            else {
                System.out.println(ball + "볼");
            }
        } else if(ball == 0) {
            if (strike == 3) {
                System.out.println("3스트라이크");
                return true;
            } else {
                System.out.println(strike + "스트라이크");
            }
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Scanner sc = new Scanner(System.in);
        while(true) {
            List<Integer> com = new ArrayList<>(3);
            run(sc, com);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int input = sc.nextInt();
            // 입력 받은 숫자가 1과 2가 아니면 예외 발생
            if (input == 2) {
                break;
            } else if (input != 1) {
                throw new IllegalArgumentException();
            }
        }
        sc.close();
    }
}
