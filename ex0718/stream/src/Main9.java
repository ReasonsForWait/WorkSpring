import domain.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main9 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("가가가", 10),
                new Student("나나나", 20),
                new Student("다다다", 30)
        );

//        list.stream().sorted()
//                .forEach(s -> System.out.println(s));

//        Comparator<Student> comp = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return 0;
//            }
//        }

//        list.stream().sorted(
//                (o1, o2) -> Integer.compare(o1.getScore(), o2.getScore())
//        ).forEach(o -> System.out.println(o));

        list.parallelStream().sorted(
                (o1, o2) -> Integer.compare(o2.getScore(), o1.getScore())
        ).forEach(o -> System.out.println(o));

    }
}
