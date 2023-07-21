import domain.Student;
import domain.Student2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main5 {

    private static List<Student2> list = Arrays.asList(
            new Student2("홍길동","남자", 90),
            new Student2("김순희","여자", 80),
            new Student2("임꺽정","남자", 60),
            new Student2("박한나","여자", 95)
    );

    public static double avg(Predicate<Student2> predicate){
        int count = 0;int sum =0;
        for (Student2 student2 : list){
            if(predicate.test(student2)) {
                count++;
                sum += student2.getScore();
            }
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        // 남자 평균
        System.out.println("남자 평균 점수 : "+ avg(t -> t.getGender().equals("남자")));
        // 여자 평균
        System.out.println("여자 평균 점수 : "+ avg(t -> t.getGender().equals("여자")));

    }
}
