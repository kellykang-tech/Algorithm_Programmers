package section02.section0211;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr) {
        int studentIndex = 0;
        int[] result = new int[n];
        List<Integer> done = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int matching = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != k) {
                        if (arr[i][j] == arr[k][j] && !done.contains(k)) {
                            done.add(k);    //[1, 4]
                            matching++;
                        }
                    }
                }//for3-k
            }//for2-j
            result[i] = matching;
//            System.out.println(i + "번째 학생 = " + matching);
        }//for1-i

        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            if (max < result[i]) {
                max = result[i];        // 2
                studentIndex = i + 1;   // 3
            }
        }

        return studentIndex;
    }

    public static void main(String[] args) {
        final Main M = new Main();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(M.solution(n, arr));
    }
}
