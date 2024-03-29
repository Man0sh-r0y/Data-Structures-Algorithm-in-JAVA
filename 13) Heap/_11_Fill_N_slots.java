import java.util.*;

public class _11_Fill_N_slots {
    // We have to find minimum time to fill N slots

    public static int fillSlots(int[] arr, int N, int k) {
        Queue<Integer> q = new LinkedList<>();
        boolean visitedElement[] = new boolean[N + 1];// whatever element we will go, that would be in visited element
        int time = 0;

        for (int i = 0; i < k; i++) {
            q.add(arr[i]);// adding element
            visitedElement[arr[i]] = true;// visited marked
        }
        // Level Order Traversal Method
        while (!q.isEmpty()) {
            int size = q.size();
            boolean isAdded = false;// if adjacent alement will be added then it'll be true
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                // adding left adjacent element
                if (curr - 1 >= 1 && !visitedElement[curr - 1]) {
                    visitedElement[curr - 1] = true;
                    isAdded = true;// element added that' why it's true
                    q.add(curr - 1);
                }
                // adding right adjacent element
                if (curr + 1 <= N && !visitedElement[curr + 1]) {
                    visitedElement[curr + 1] = true;
                    isAdded = true;// element added that' why it's true
                    q.add(curr + 1);
                }
            }

            if (isAdded)// if adjacent element added then only time will be incremented
                time++;
        }
        return time;
    }

    public static void main(String[] args) {
        int N = 6, K = 2, arr[] = { 2, 6 };
        // N => number of slots
        // K => size of the array
        System.out.println(fillSlots(arr, N, K));
    }
}
