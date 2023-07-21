import OutDTO.OutDTO1;
import domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동", 30),
                new Student("김근형", 25)
        );

        List<OutDTO1> dtoList = new ArrayList<>();

        Stream<Student> stream = list.stream();
//        stream.forEach(s -> System.out.println(s.getName() + "-" + s.getScore()));
        stream.forEach(s -> dtoList.add(new OutDTO1(s.getName() + "-" + s.getScore())));
    }
}
