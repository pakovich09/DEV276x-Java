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
         text = text.replaceAll("[\\s.,:;'!?()/\"]", "").toUpperCase();
        return text;
    }

    public static String caesarify(String normalized_text, int n){
        String result = "";
        String alphabet = shiftAlphabet(n);
        for(int i = 0; i < normalized_text.length(); i++)
            result += alphabet.charAt((int) normalized_text.charAt(i) - 65);
        return result;
    }

    public static String groupify(String encripted_text, int n){
        String result = "";
        for(int i = 0; i < encripted_text.length(); i+=n){
            if(i+n < encripted_text.length()){
                result += encripted_text.substring(i, i+n);
                result += " ";
            }
            else{
                String rest = encripted_text.substring(i);
                result += rest;
                for(int j = 0; j < n - rest.length(); j++)
                    result += "x";
            }
        }
        return result;
    }
    
    public static String obify(String text){
        String result = "";
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ('A')||text.charAt(i) == ('E')||text.charAt(i) == ('I')||
            text.charAt(i) == ('O')||text.charAt(i) == ('U')||text.charAt(i) == ('Y')){
                result += text.charAt(i);
                result += "ob ";
            }
            else{
                result += text.charAt(i);
            }
        }
        return result;
    }
    
    public static String encryptString(String text, int shift, int group){
        text = normalizeText(text);
        text = caesarify(text, shift);
        text = groupify(text, group);
        return text;
    }
    
    public static String ungroupify(String groupified_text){
        String result = "";
        for(int i = 0; i < groupified_text.length(); i++){
            if(groupified_text.charAt(i) == ' ' || groupified_text.charAt(i) == 'x')
                continue;
            result += groupified_text.charAt(i);
        }
        return result;
    }
    
    public static String decryptString(String encrypted_text, int shift){
        String result = "";
        
        for(int i = 0; i < encrypted_text.length(); i++){
            int ascii = (int) encrypted_text.charAt(i) - shift;
            if(ascii < 65)
                ascii = 91 - (65 -  ascii);
             else if(ascii > 90)
                 ascii = ascii - 90 + 64;
            char ch = (char) ascii;
            result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        String text = normalizeText("This is some \"really\" great. (Text)!?");
        System.out.println(text);
        System.out.println(caesarify(text, 4) + "\n");
        System.out.println(shiftAlphabet(4));
        System.out.println(shiftAlphabet(0));

        System.out.println();
        System.out.println(groupify("THISISSOMEREALLYGREATTEXT", 3));
        
        System.out.println(encryptString("This is some \"really\" great. (Text)!?", 4, 3));
        
        System.out.println(obify(text));
        System.out.println(ungroupify(groupify("THISISSOMEREALLYGREATTEXT", 3)));
        
        System.out.println(decryptString("XLMWMWWSQIVIEPPCKVIEXXIBX", 4));
    }
}
