import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class midterm {

    public static void khooneyeSabz(int[][] mb_array, String str) {
        int n = mb_array.length;
        String[][] results = new String[n][n];
        for (int j = 0; j < n-1; j++) {
            int value = mb_array[0][j];
            switch (value) {
                case 1:
                    results[0][j] = reverseString(str);
                    break;
                case 2:
                    results[0][j] = DoubleCharacters(str);
                    break;
                case 3:
                    results[0][j] = DoubleStrings(str);
                    break;
                case 4:
                    results[0][j] = moveLastCharacterFirst(str);
                    break;
                case 5:
                    results[0][j] = abc(str);
                    break;
            }
        }

        for (int i = 1; i < n-1; i++) {
            int value = mb_array[i][0];
            switch (value) {
                case 1:
                    results[i][0] = reverseString(str);
                    break;
                case 2:
                    results[i][0] = DoubleCharacters(str);
                    break;
                case 3:
                    results[i][0] = DoubleStrings(str);
                    break;
                case 4:
                    results[i][0] = moveLastCharacterFirst(str);
                    break;
                case 5:
                    results[i][0] = abc(str);
                    break;
            }
        }

        // Print the results
        for (int a = 0; a < n-1; a++) {
            for (int b = 0; b < n-1; b++) {
                if (results[a][b] != null) {
                    System.out.print(results[a][b]);
                }
            }
        }
    }
static String abc(String str) {
            String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                    "r", "s", "t", "u", "v", "w", "x", "y", "z"};
            String[] str2 = str.split("");
            for (int i = 0; i < str2.length; i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (str2[i].equals(alphabet[j])) {
                        int p = 25 - j;
                        if (p < 0){
                            p = -p;

                        }
                        System.out.print(alphabet[p]);
                    }
                }
            }
        return str;
    }


    public static String reverseString(String str) {
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        return reversedStr;
    }

    //static void blackFunction(int[][] arrayb, int rowIndex, int columnIndex) {
        //int numRows = arrayb.length;
        //int numCols = arrayb[0].length;
        //Scanner scanner = new Scanner(System.in);
        //String str = scanner.next();
        //String reversedStr = "";
        //if (arrayb[rowIndex][columnIndex] == 1) {
           // for (int i = 0; i < str.length(); i++) {
                //reversedStr = str.charAt(i) + reversedStr;
            //}
            //System.out.println(reversedStr);
        //}

    //}
    public static String DoubleCharacters(String str) {
        String doubledString = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            doubledString += c;
            doubledString += c;
        }
        return doubledString;
    }

    public static String DoubleStrings(String str) {
        String repeatStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            repeatStr = str + str;
        }
        return repeatStr;
    }

    public static String moveLastCharacterFirst(String input) {
        char lastChar = input.charAt(input.length() - 1);
        String remainingString = input.substring(0, input.length() - 1);
        return lastChar + remainingString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        Random random = new Random();
        String[] str2 = str.split("");
        //System.out.println(Arrays.toString(str2));
        int[][] mb_array = new int[n][n];

        String reversedStr = "";
        String doubledString = "";
        String repeatStr = "";

        for (int i = 0; i < n; i++) {
            //System.out.println();
            for (int j = 0; j < n; j++) {
                mb_array[i][j] = random.nextInt(5) + 1;
                //System.out.print((mb_array[i][j]) + " ");
            }
        }
        //System.out.println();

            for (int i = 0 ; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == n - 1 && i != 0) {
                    continue;
                    }
                    if (i == n - 1 && j != 0) {
                       continue;
                    }

                    if (mb_array[i][j] == 1) {
                        reversedStr += reverseString(str);
                    }

                    if (mb_array[i][j] == 2){
                        doubledString += DoubleCharacters(str);
                    }
                    if (mb_array[i][j] == 3) {
                        repeatStr += DoubleStrings(str);
                    }
                    if (mb_array[i][j] == 4){
                        moveLastCharacterFirst(str);
                    }
                    if (mb_array[i][j] == 5){
                        abc(str);
                    }
                }
            }//khooneyeSabz(mb_array, str);
            //System.out.println();
            System.out.print(reversedStr);
            System.out.print(doubledString);
            System.out.print(repeatStr);
            System.out.print(moveLastCharacterFirst(str));
            abc(str);
    }
}