public class GGT_4_1_4 {
    public static void main(String[] args) {
        GGT();
    }
    private static void GGT(){
        int ggt = 1;
        int eins = 15;
        int zwei = 9;
        int kl = Math.min(eins,zwei);

        for(int i = 1; i<=kl; i++){
            if(eins%i ==0 && zwei%i ==0){
                ggt=i;
            }

        }
        System.out.println(ggt);
    }

}
