import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Main8 {
    public static void main(String[] args) {
        // 입력받은 값의 배수를 검사하는 로직
        // 2의 배수인가 아닌가
        IntPredicate predicateA = a -> (a%2) == 0;
        // 3의 배수인가 아닌가
        IntPredicate predicateB = a -> (a%3) == 0;
        //if(predicateA.test(9) && predicateB.test(9)){}
        IntPredicate predicateAB;
        boolean result;

        // and()
        predicateAB = predicateA.and(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2와 3의 배수입니까? : "+result);
        // or()
        predicateAB = predicateA.or(predicateB);
        result = predicateAB.test(9);
        System.out.println("9는 2 혹은 3의 배수입니까? : "+result);
        // nagate()
        predicateAB = predicateA.negate();
        result = predicateAB.test(9);
        System.out.println("9눈 홀수입니까? : "+result);

        Predicate<String> predicate = Predicate.isEqual("javaabc");
        System.out.println("비교 결과 : "+predicate.test("javaab"));
    }
}
