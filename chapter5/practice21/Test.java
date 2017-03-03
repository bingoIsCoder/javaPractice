enum Money{
    ONE, TWO, FIVE, TEN, HUNDRED
}

public class Test{
    public static void main(String []args){
        for(Money e : Money.values())
            System.out.println(e + ", " + e.ordinal());
    }
}
