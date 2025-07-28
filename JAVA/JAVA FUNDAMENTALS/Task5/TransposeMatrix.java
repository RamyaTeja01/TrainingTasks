package JavaFundamentals;


public class TransposeMatrix {

	public static void main(String[] args) {
		 int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		 for (int i = 0; i < 3; i++)
		 for (int j = i; j < 3; j++) {
		 int temp = matrix[i][j];
		 matrix[i][j] = matrix[j][i];
		 matrix[j][i] = temp;
		 }
		 for (int[] row : matrix) {
		 for (int val : row)
		 System.out.print(val + " ");
		 System.out.println();
		 }
	}
}
		