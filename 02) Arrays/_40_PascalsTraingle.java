import java.util.ArrayList;
import java.util.List;

public class _40_PascalsTraingle {

    public static void initializeList(List<List<Integer>> ans, int indx) {
        List<Integer> list = ans.get(indx);
        list.add(0, 1);// put 1 at the starting index of arraylist
        list.add(list.size() - 1, 1); // put 1 at the last index of arraylist
    }

    public static List<List<Integer>> pascalsTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(new ArrayList<>());
        ans.get(ans.size() - 1).add(0,1);// at index 0, inserted element 1
        
        if(n == 1) 
            return ans;

        for(int i=1; i<n; i++){
            ans.add(new ArrayList<>());
            initializeList(ans, i);
            List<Integer> currList = ans.get(ans.size()-1);
            List<Integer> prevList = ans.get(ans.size() - 2);
            int sum = prevList.get(0);
            for(int j=1; j<prevList.size(); j++) {
                sum += prevList.get(j);
                currList.add(j, sum);
                sum = prevList.get(j);
            }
        }

        return ans;
    }

    // print any number in Pascal's Traingle at given row and column
    public static int getNumber(int row, int col) {
        int ans = 1;

        for(int i=0; i<col; i++) {
            ans = ans * (row - i);
            ans = ans / (i + 1);
        }

        return ans;
    }

    // Brute Force Method to generate any Nth row in Pascal's Traingle
    public static void generateNthRow(int N) {
        for(int i=0; i<=N; i++) {
            System.out.print(getNumber(N, i) + " ");
        }
        System.out.println();
    }

    // Optimal Method to generate any Nth row in Pascal's Traingle
    public static void generateNthRowOptimal(int N) {
        int ans = 1;

        for(int i=0; i<=N; i++) {
            System.out.print(ans + " ");
            ans = ans * (N - i);
            ans = ans / (i + 1);
        }
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(pascalsTriangle(n));
        System.out.println(getNumber(6, 3));
        generateNthRow(5);
        generateNthRowOptimal(5);
    }
}
