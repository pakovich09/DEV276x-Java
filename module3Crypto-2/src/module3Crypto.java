public class module3Crypto {
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result += currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result += currChar;
            }
        }
        return result;
    }

    public static String normalizeText(String text){
         temp = text.replaceAll("[\\s.,:;'!?()/\"]", "").toUpperCase();
        return temp;
    }

    public static String caesarify(String text, int n){
        String temp = shiftAlphabet(n);
        int i = 0;
        for(char currChar = 'A'; currChar <= 'Z'; ++currChar) {
            text = text.replaceAll(currChar, temp.charAt(i));
            i++;
        }
        return text;
    }
//
//    public static String groupify(String text, int n){
//
//    }

    public static void main(String[] args) {
        String text = normalizeText("asfasf/???asfa?.asfsf");
        System.out.println(text);
        text = caesarify(text, 4);
        System.out.print(text);
        shiftAlphabet(4);
    }
}
