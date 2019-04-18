public class q48 {
    public void rotate(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix[0].length];
        
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int now = matrix[i][j]; // the next int to be processed
                ans[j][matrix[0].length-1-i] = now;
            }
    
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}