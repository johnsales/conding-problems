package edu.problems.cracking_code_interview.chapter1;

public class URLify {
    public static void main(String[] args) {
        System.out.println(urlify("Maria de Joao"));
    }

    static String urlify(String string){
        int spaceCount = 0;
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' '){
                spaceCount++;
            }
        }

        char[] finalArray = new char[string.length() + spaceCount * 2]; // Two additional spots for each space
        for (int i = 0, j = 0; i < string.length(); i++) {
            if(string.charAt(i) == ' '){
                finalArray[j++] = '%';
                finalArray[j++] = '2';
                finalArray[j++] = '0';
            }else{
                finalArray[j] = string.charAt(i);
                j++;
            }
        }

        return new String(finalArray);
    }
}
