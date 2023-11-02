import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        System.out.println(decipherThis("72olle 103doo 100ya"));
        System.out.println(encryptThis("what is going wow"));
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i< str.length(); i++) {
            if (str.charAt(i) == '(') {
                leftCount++;
            }
            if (str.charAt(i) == ')') {
                rightCount++;
            }
        }
        return leftCount == rightCount;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String str = "" + num;
        String output = "";
        for (int i = str.length()-1; i >= 0; i--) {
            output = output + str.charAt(i);
        }
        return output;
    }
    // 3. encryptThis
    public static String encryptThis(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            int code = (int) words[i].charAt(0);
            String stringCode = "" + code;
            String lastChar = words[i].substring(words[i].length()-1);
            String middleString = "";
            String secChar = "";
            if (words[i].length() > 2) {
                middleString = words[i].substring(2, words[i].length()-1);
                secChar = words[i].substring(1,2);
            } else {
                middleString = "";
                secChar = words[i].substring(2);
            }
            words[i] = stringCode + lastChar + middleString + secChar;
        }
        return String.join(" ", words);
    }
    // 4. decipherThis
    public static String decipherThis(String str) {
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            int code = 0;
            String word = "";
            for (int j = 0; j < words[i].length(); j++) {
                if (!Character.isDigit(words[i].charAt(j))) {
                    code = Integer.parseInt(words[i].substring(0, j));
                    word = words[i].substring(j-1);
                    break;
                }
            }
            char codeToChar = (char) code;
            String lastChar = words[i].substring(words[i].length() - 1);
            String middleString;
            String secChar;
            if (word.length() > 2) {
                middleString = word.substring(2, word.length() - 1);
                secChar = word.substring(1, 2);
            } else {
                middleString = "";
                secChar = "";
            }
            words[i] = codeToChar + lastChar + middleString + secChar;
        }
        return String.join(" ", words);
    }
}