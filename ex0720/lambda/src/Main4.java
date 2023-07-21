import java.util.function.IntBinaryOperator;

public class Main4 {
    private static int[] scores = {67,88,79};

    public static int maxOrMin(IntBinaryOperator op){
        int result = scores[0];
        for (int score : scores){
            result = op.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println("최대값 : "+maxOrMin((a,b)->{if(a>=b)return a;else return b;}));
        System.out.println("최대값 : "+maxOrMin((a,b)-> (int)Math.max(a, b) ));
        System.out.println("최소값 : "+maxOrMin((a,b)->{if(a<=b)return a;else return b;}));
    }
}
