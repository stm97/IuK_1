public class Fakultaet_4_1_2 {

    private void Fakultaet(int n){
        int fakultaet;
        int i = 1;
        while (i<=n)
        {
           n *= i;
           i++;
        }
        fakultaet = n;
        System.out.println(fakultaet);

    }

}
