import static java.lang.Math.abs;

public class Application {

    public static int manhattan(int x_value, int y_value,int x_goal,int y_goal){
        return abs(x_value - x_goal) + abs(y_value - y_goal);
    }

    public static void main(String[] args) {
        int maxNumber = 360000; //it's square root must be an integer
        int spiralDimension = (int) Math.sqrt(maxNumber);
        int[][] spiral = new int[spiralDimension][spiralDimension];
        int start_x = 0 ,start_y = 0 ,goal_x = 0 ,goal_y = 0;
        int input = 325489;
        int answer = 0;


        int value = maxNumber;
        int minCol = 0;
        int maxCol = spiralDimension-1;
        int minRow = 0;
        int maxRow = spiralDimension-1;
        while (value != 0)
        {
                for (int i = maxCol; i >= minCol; i--)
                {
                    spiral[maxRow][i] = value;
                    value--;
                }

                for (int i = maxRow - 1 ; i >= minRow; i--)
                {
                    spiral[i][minCol] = value;
                    value--;
                }

                for (int i = minCol + 1; i <= maxCol; i++)
                {
                    spiral[minRow][i] = value;
                    value--;
                }

                for (int i = minRow +1 ; i <= maxRow -1; i++)
                {
                    spiral[i][maxCol] = value;
                    value--;
                }
                minCol++;
                minRow++;
                maxCol--;
                maxRow--;
            }


        for (int i = 0; i < spiral.length; i++)
        {
            for (int j = 0; j < spiral.length; j++)
            {
//                System.out.print(spiral[i][j]+ "\t");
                if(spiral[i][j] == input){
                    goal_x = i;
                    goal_y = j;
                }
                if(spiral[i][j] == 1){
                  start_x = i;
                  start_y = j;
                }
            }

//            System.out.println();
        }
        answer = manhattan(goal_x,goal_y,start_x,start_y);
        System.out.println(answer);
    }
}
