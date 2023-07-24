import domain.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Main12 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("가가가", 92),
            new Student("나나나", 88),
            new Student("다다다", 75)
        );

        int sum1 = list.stream().mapToInt(Student :: getScore).sum();

        int sum2 = list.stream().mapToInt(Student :: getScore)
                .reduce(0,(a, b)-> a+b);

        OptionalInt sum3 = list.stream().mapToInt(Student :: getScore)
                .reduce((a, b)-> a+b);

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3.getAsInt());
    }
}
