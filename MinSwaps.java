import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MinSwaps {

    public static void main(String[] args) {
        minSwapsQuestion();
    }

    public static void minSwapsQuestion() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(minSwaps(a, n));
        sc.close();
    }

    public static int minSwaps(int[] arr, int N) {
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();

        Arrays.sort(temp);

        for (int i = 0; i < N; i++) {
            h.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];
                swap(arr, i, h.get(temp[i]));
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}