import domain.Calculator;
import domain.Member;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntBiFunction;

public class Main11 {
    public static void main(String[] args) {
        IntBinaryOperator operator;

        // 정적 메소드 참조
//        operator = (x, y) -> Calculator.staticMethod(x, y);
        operator = Calculator :: staticMethod;
        System.out.println(operator.applyAsInt(1,2));

        // 인스턴스 메소드 참조
        Calculator calc = new Calculator();
        operator = calc :: instanceMethod;
        System.out.println(operator.applyAsInt(3,4));

        // 매개변수의 메소드 참조
        ToIntBiFunction<String, String> func;
//        func = (a, b) -> a.compareToIgnoreCase(b);
        func = String :: compareToIgnoreCase;
        System.out.println(func.applyAsInt("Java17","JAVA17"));

        // 생성자 참조
        BiFunction<String, String, Member> func2 = Member :: new;
        Member member2 = func2.apply("aaaa","bbbb");
        System.out.println("func1, name : "+member2.getName());

    }
}
