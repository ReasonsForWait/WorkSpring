import domain.Fruit;

import java.util.function.BinaryOperator;

public class Main10 {
    public static void main(String[] args) {
        BinaryOperator<Fruit> binaryOperator;
        Fruit fruit;

        binaryOperator = BinaryOperator.maxBy(
                (f1, f2) -> Integer.compare(f1.price, f2.price)
        );
        fruit = binaryOperator.apply(
                new Fruit("딸기", 6000),
                new Fruit("수박", 10000)
        );
        System.out.println(fruit.name);
    }
}
