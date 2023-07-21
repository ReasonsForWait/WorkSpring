import domain.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Main3 {
    private static List<Student> list = Arrays.asList(
            new Student("홍길동", 90, 95),
            new Student("김근형", 80, 70)
    );

    private  static void printString(Function<Student,String> function){
        for(Student student : list){
            System.out.print(function.apply(student) + " ");
        }
        System.out.println();
    }

    private  static void printInt(ToIntFunction<Student> function){
        for(Student student : list){
            System.out.print(function.applyAsInt(student) + " ");
        }
        System.out.println();
    }

    private static void printAvg(ToIntFunction<Student> function){
        double a = 0.0;
        for(Student student : list){
            a += function.applyAsInt(student);
        }
        double avg = a / list.size();
        System.out.println(avg);
    }

    public static void main(String[] args) {
        System.out.println("[학생 이름]");
        printString( t -> t.getName());

        System.out.println("[영어 점수]");
        printInt(t -> t.getEnglishScore());

        System.out.println("[수학 점수]");
        printInt(t -> t.getMathScore());

        System.out.println("영어 점수 평균 : ");
        printAvg(t -> t.getEnglishScore());

        System.out.println("수학 점수 평균 : ");
        printAvg(t -> t.getMathScore());
    }
}
