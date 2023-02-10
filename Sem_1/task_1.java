package Sem_1;

public class task_1 {
    public static void main(String[] args) {
        int[] a = { 1, 9, 9, 0, 2, 8, 0, 9 };
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j] && j < i)
                    break;
                else if (a[i] == a[j] && j >= i) {
                    count++;
                }
            }
            if (count != 0) {
                if (count > 1 && count < 5) {
                    System.out.printf("%d встречается %d раза", a[i], count);
                } else {
                    System.out.printf("%d встречается %d раз", a[i], count);
                }
                System.out.println();
                count = 0;
            }
        }
    }
}

// package Sem_1;

// public class task_1 {
//     public static void main(String[] args) {
//         int[] a = { 1, 9, 9, 0, 2, 8, 0, 9 };
//         int count = 0;

//         for (int i = 0; i < a.length; i++) {
//             if (a[i] != Integer.parseInt(null)) {
//                 for (int j = i; j < a.length; j++) {
//                     if (a[i] == a[j]) {
//                         count++;
//                         a[j] = Integer.parseInt(null);
//                     }
//                 }
//             }
//             if (count != 0) {
//                 if (count > 1 && count < 5) {
//                     System.out.printf("%d встречается %d раза", a[i], count);
//                 } else {
//                     System.out.printf("%d встречается %d раз", a[i], count);
//                 }
//                 System.out.println();
//                 count = 0;
//             }
//         }
//     }
// }
