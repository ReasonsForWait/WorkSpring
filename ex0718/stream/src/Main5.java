import domain.Member;

import java.util.Arrays;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        List<Member> list = Arrays.asList(
                new Member("가가가", Member.MALE, 30),
                new Member("나나나", Member.FEMALE, 20),
                new Member("다다다", Member.MALE, 45),
                new Member("라라라", Member.FEMALE, 27)
        );

        int a = list.stream()
                // 숫자 추출/데이터 추출
                .mapToInt(Member :: getAge)
                // 연산수행 (평균)
                //.average();
                // 최대값
                .max()
                // 최소값
                // .min()
                // 합계
                // .sum()
                // 카운트
                // .count()
                .getAsInt();

        System.out.println("max : "+a);

    }
}
