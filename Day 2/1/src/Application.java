import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int checksum = 0;
        File file = new File("input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            String input = sc.nextLine();
            input = input.replaceAll("[^-?0-9]+", " ");  // [^-?0-9]+    ^ = not , -? = character , 0-9 = interval
            List<String> tempArr = Arrays.asList(input.trim().split(" "));
            for (String number : tempArr) {
                int temp = Integer.parseInt(number);
                if(min > temp){
                    min = temp;
                }
                if(max < temp){
                    max = temp;
                }
            }
            checksum += max-min;
        }
        System.out.println(checksum);
    }
}
