package telran.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {
    public static String firstName(){
        //regex for strings starting with capital 
        //letter and rest as lowercase letters
        //minimal length is 5 letters
        return "^[A-Z][a-z]{4,}$";
    }
    public static String javaVariable(){
        return "^(?!_\\b)[a-zA-Z_$][a-zA-Z\\\\d_$]*$";
    }

    public static List<Integer> findInvalidVariableIndex(String variable, String[] name) {
        List<Integer> invalidIndex = new ArrayList<>();
        Pattern pattern = Pattern.compile(variable);
        for (int i = 0; i < name.length; i++) {
            Matcher matcher = pattern.matcher(name[i]);
            if (!matcher.matches() || reservedKeywords.contains(name[i]))  {
                invalidIndex.add(i);
            }
        }
        return invalidIndex ;
    }
    
    private static final Set<String> reservedKeywords = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default",
        "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient",
        "try", "void", "volatile", "while", "true", "false", "null"
    ));
    
}
