public class SandGlassPattern {

    public static void sandGlass(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= 2 * n - 1; j++) {
                if (i == 1 && j == n || i == n) {
                    System.out.print("* ");
                } else if (j == n + 1 - i || j == n - 1 + i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        sandGlass(5);
    }
}
