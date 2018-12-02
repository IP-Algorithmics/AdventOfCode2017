
public class Application {
    private static int answer = 0;
    private static boolean foundAnswer = false;
    private static int input = 325489;

    private static int spiralDimension = oddDimension(input);// an odd integer
    private static int maxNumber = spiralDimension * spiralDimension;
    private static int[][] spiral = new int[spiralDimension][spiralDimension];
    private static int value = 1; // count at what square it is at the moment

    private static Integer insertValue(int i, int j) {
        if (value == 1) {
            return value;
        } else {
            int temp = 0;
            for (int row = i - 1; row <= i + 1; row++) {
                for (int col = j - 1; col <= j + 1; col++) {
                    if (row != i || col != j) {
                        if ((row < spiralDimension && row >= 0 && col < spiralDimension && col >= 0) && spiral[row][col] != 0) {
                            temp = temp + spiral[row][col];
                        }
                    }
                }
            }
            if (temp > input && !foundAnswer) {
                foundAnswer = true;
                answer = temp;
            }
            return temp;
        }
    }

    // used to find the smallest odd dimension that includes the input
    private static Integer oddDimension(int input) {
        int dimension = 1;
        for (int i = 1; i < input; i++) {
            if (i % 2 == 1 && i * i >= input) {
                dimension = i;
                break;
            }
        }
        return dimension;
    }

    public static void main(String[] args) {

        // this initialization works only for matrices with odd dimensions that have only one center
        int minCol = spiralDimension / 2;
        int maxCol = spiralDimension / 2;
        int minRow = spiralDimension / 2;
        int maxRow = spiralDimension / 2;

        while (value <= maxNumber) {
            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                spiral[i][maxCol] = insertValue(i, maxCol);
                value++;
            }
            for (int j = maxCol; j >= minCol; j--) {
                spiral[minRow][j] = insertValue(minRow, j);
                value++;
            }
            for (int i = minRow + 1; i <= maxRow; i++) {
                spiral[i][minCol] = insertValue(i, minCol);
                value++;
            }
            for (int j = minCol + 1; j <= maxCol; j++) {
                spiral[maxRow][j] = insertValue(maxRow, j);
                value++;
            }

            minCol--;
            minRow--;
            maxCol++;
            maxRow++;
        }
//print the matix
//        System.out.println(spiral.length);
//        for (int i = 0; i < spiral.length; i++)
//        {
//            for (int j = 0; j < spiral.length; j++)
//            {
//                System.out.print(spiral[i][j]+ "\t");
//            }
//
//            System.out.println();
//        }
        System.out.println(answer);
    }
}
