import domain.Student;
import dto.OutDTO1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("가가가", 10),
                new Student("나나나", 20),
                new Student("다다다", 30)
        );

        list.stream().mapToInt(Student::getScore).forEach(score -> System.out.println(score));

        List<OutDTO1> resultList = new ArrayList<>();

        list.stream().map(OutDTO1::new).forEach(resultList :: add);
    }
}
