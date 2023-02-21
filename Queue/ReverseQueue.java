import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseQueue {

    public static void reverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <= 5; i++) {
            q.add(i);
        }
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }
}
