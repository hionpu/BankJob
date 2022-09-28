import java.util.*;
import java.util.stream.Collectors;


public class BankJob {
    public static long ocean(int target, int[] type) {
        // TODO:

       int length = type.length;
        return counting(target, type, length);


    }
    public static long counting(int target, int[] type, int length) {
           // Basecase
            // 1.  => count ++
            // 1. queue의 마지막 값으로 target 이 나누어 떨어짐 => count += 1
            // 2. 나누어 떨어지지 않음 => count += 0
            if (target == 0) {
                return 1;
            }
            else if (target < 0) {
                return 0;
            }
            else if ( target > 0 && length == 0 ) {
                return 0;

            }
           return counting(target - type[length-1], type, length ) +
                   counting(target, type, length-1);
            }

    public static long countingDP(int target, int[] type, int length){
        long[] table = new long[target+1];
        Arrays.fill(table, 0);
        table[0] = 1;
        for (int i = 0; i < length; i++) {
            for (int j = type[i]; j <= target; j++) {
                table[j] += table[j - type[i]];
                System.out.printf("j: %d / type[i]: %d / j-type[i] : %d%n", j, type[i], j-type[i]);
                System.out.println(Arrays.toString(table));
            }
        }
        System.out.println(Arrays.toString(table));

        return table[target];
    }



    public static void main(String[] args) {
        int[] type = { 5,6,7};
        int target = 30;

        System.out.println(BankJob.ocean(target,type));
        System.out.println(countingDP(target,type,type.length));
    }
}
