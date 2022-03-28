public class KnapSack {
    public static void main(String[] args) {
        // Create a new instance of the class Main
        KnapSack knapSack = new KnapSack ();

        // To test the program, create an array of weights and values
        int val[] = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        int wt[] = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int W = 165;
        int n = val.length;
        System.out.println("The maximum value that can be put in the knapsack is " + knapSack.knapSnack(val, wt, W, n));
    }

    // knapSack function to solve the knapsack problem and save the result in the vetor
    int knapSnack (int val[], int wt[], int W, int n) {
        int i, w;
        int K[][] = new int[n+1][W+1];
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i-1] <= w) {
                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w]);
                } else {
                    K[i][w] = K[i-1][w];
                }
            }
        }
        return K[n][W];
    }
}
