public class Fakultaet_4_1_2 {
    public static void main(String[] args) {
        Fakultaet();
    }
    private static void Fakultaet(){
        int n = 9;
        int fakultaet = 1;
        int i = 1;
        while (i<=n)
        {
           fakultaet *= i;
           i++;
        }

        System.out.println(fakultaet);

    }

}
