import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int answer = 0;
        File file = new File("input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            boolean found = false;
            String input = sc.nextLine();
            input = input.replaceAll("[^-?0-9]+", " ");  // [^-?0-9]+    ^ = not , -? = character , 0-9 = interval
            List<String> tempArr = Arrays.asList(input.trim().split(" "));

            for (String number : tempArr) {
                int temp = Integer.parseInt(number);
                for (String number2 : tempArr) {
                    int temp2 = Integer.parseInt(number2);
                    if(temp != temp2){
                        if(temp % temp2 == 0){
                            answer = answer + (temp / temp2);
                            System.out.println(temp + " " + temp2);
                            found = true;
                            break;
                        }
                        if(temp2 %  temp == 0){
                            answer = answer + (temp2 / temp);
                            System.out.println(temp2  + " " +  temp);
                            found = true;
                            break;
                        }
                    }

                }
                if(found){
                    break;
                }
            }
        }
        System.out.println("Answer: " + answer);
    }
}
