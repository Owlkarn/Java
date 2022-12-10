// public class program {
//     public static void main(String[] args) {
//         int[][] arr = new int [3][5];

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[i].length; j++) {
//                 System.out.printf("%d ", arr[i][j]);
//             }
//             System.out.println();
//         }
//     }
// }

/**
 * program
 */
import java.util.Scanner;
public class program {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("a = ");
        boolean flag = iScanner.hasNextInt();
        if (flag) {
            int a = iScanner.nextInt();
            System.out.printf("b = ");
            int b = iScanner.nextInt();
            int c = a/b;
            System.out.println(c);
        }
        else {
            System.out.println("non");
        }
        iScanner.close();
        
    }
}