package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> names = readAndValidateNames();
        int tryCount = readAndValidateTryCount();
        List<Integer> cnt = new ArrayList<>();
        // 초기화
        for (int i = 0; i < names.size(); i++) {
            cnt.add(0);
        }
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            for (int j = 0; j < names.size(); j++){
                Integer ramdom_num = Randoms.pickNumberInRange(0, 9);
                if (ramdom_num >= 4){
                    cnt.set(j, cnt.get(j) + 1);
                }
                String name = names.get(j);
                String bar = "-".repeat(cnt.get(j));
                System.out.println(name + " : " + bar);
            }
            System.out.println(); // 차수 사이 빈 줄
        }
        List<String> winners = new ArrayList<>();
        Integer max_cnt = 0;
        for (int j = 0; j < names.size(); j++){
            if (cnt.get(j) > max_cnt){
                max_cnt = cnt.get(j);
                // 더 전진횟수가 많은 사람일 경우 배열 초기화
                winners = new ArrayList<>();
                winners.add(names.get(j));
            } else if (cnt.get(j) == max_cnt) {
                winners.add(names.get(j));
            }
        }
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    private static List<String> readAndValidateNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String raw = Console.readLine();
        String trimmed = safeTrim(raw);
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("이름 입력이 비어 있습니다.");
        }

        String[] tokens = trimmed.split(",");
        List<String> names = new ArrayList<>();

        for (String t : tokens) {
            String name = safeTrim(t);
            if (name.isEmpty()) {
                // 예: "pobi,,jun" 같은 빈 토큰 금지
                throw new IllegalArgumentException("빈 이름이 포함되어 있습니다.");
            }
            validateNameLength(name);
            names.add(name);
        }
        return names;
    }

    private static void validateNameLength(String name) {
        // 이름 길이: 1~5자
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    // -----------------------
    // A-2) 시도 횟수 입력/검증
    // -----------------------
    private static int readAndValidateTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raw = Console.readLine();
        String trimmed = safeTrim(raw);

        int n = parsePositiveInt(trimmed);
        if (n <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }
        return n;
    }

    private static int parsePositiveInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
    }

    // -----------------------
    // 공용 유틸
    // -----------------------
    private static String safeTrim(String s) {
        if (s == null) return "";
        return s.trim();
    }
}
