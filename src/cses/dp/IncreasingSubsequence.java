package cses.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class IncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] x = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(LongestIncreasingSubsequenceLength(x));
    }

    static int LongestIncreasingSubsequenceLength(int v[])
    {
        if (v.length == 0) return 0;

        int[] tail = new int[v.length];
        int length = 1;
        tail[0] = v[0];

        for (int i = 1; i < v.length; i++) {

            if (v[i] > tail[length - 1]) {
                tail[length++] = v[i];
            }
            else {
                int idx = Arrays.binarySearch(
                        tail, 0, length - 1, v[i]);
                if (idx < 0)
                    idx = -1 * idx - 1;

                tail[idx] = v[i];
            }
        }
        return length;
    }
}
