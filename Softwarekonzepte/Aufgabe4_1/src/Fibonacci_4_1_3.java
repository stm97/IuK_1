public class Fibonacci_4_1_3 {
    public static void main(String[] args) {
        fibonacci();
    }
    private static void fibonacci(){
        int eins = 0;
        int zwei = 1;
        int drei = eins+zwei;
        System.out.println(eins);
        System.out.println(zwei);

        for(int i=0;i<10;i++){
            eins = zwei;
            zwei = drei;
            drei = eins+zwei;
            System.out.println(drei);
        }
    }
}
