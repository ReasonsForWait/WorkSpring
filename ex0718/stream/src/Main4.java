import domain.Student;

import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("가가가", 30),
                new Student("나나나", 35),
                new Student("다다다", 40)
        );

        double avg = list.stream()
                //학생 객체를 점수로 매핑
                .mapToInt(Student :: getScore)
                // 평균을 구하기
                .average()
                // double로 출력
                .getAsDouble();

        System.out.println("평균점수 : "+avg);
    }
}
