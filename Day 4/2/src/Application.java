import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Application {
    public static boolean anagram(String s1, String s2){
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }


    public static void main(String[] args) {
        File file = new File("input.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int passwords = 0;
        int notValid = 0;

        while (sc.hasNextLine()) {
            passwords ++;
            String input = sc.nextLine();
            List<String> tempArr = Arrays.asList(input.trim().split(" "));
            System.out.println(tempArr);
            for(int i=0; i< tempArr.size() ; i++){
                boolean found = false;
                for(int j=0; j< tempArr.size() ; j++){
                    if(i != j){
                        if(anagram(tempArr.get(i),tempArr.get(j))){
                            notValid ++;
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
        System.out.println(passwords - notValid);
    }
}
