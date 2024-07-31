package telran.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
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
        //return "((?!_$)[a-zA-Z$_][\\w$]*)";
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
    static final String Keywords[] = { "abstract", "assert", "boolean",
    "break", "byte", "case", "catch", "char", "class", "const",
    "continue", "default", "do", "double", "else", "enum", "extends", "false",
    "final", "finally", "float", "for", "goto", "if", "implements",
    "import", "instanceof", "int", "interface", "long", "native",
    "new", "null", "package", "private", "protected", "public",
    "return", "short", "static", "strictfp", "super", "switch",
    "synchronized", "this", "throw", "throws", "transient", "true",
    "try", "void", "volatile", "while" };

    private static final Set<String> reservedKeywords = new HashSet<>(Arrays.asList(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default",
        "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public",
        "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient",
        "try", "void", "volatile", "while", "true", "false", "null"
    ));
    public static String number0_300() {
       
        return "[1-9]\\d?|[1-2]\\d\\d|300|0";
    }
    public static String ipV4Octet(){
        
        return "([0-1]?\\d{1,2}|2([0-4]\\d|5[0-5]))";
    }
    public static String ipV4Address(){
        String octetExpr = ipV4Octet();
        return String.format("%s(\\.%s){3}", octetExpr, octetExpr);
    }
    public static String stringWithJavaNames(String names) {
       String [] tokens = names.split("\\s+");
       int i = getJavaNameIndex(tokens, -1);
       String res = "";
       if (i >= 0) {
         res = tokens[i];
       }
       while((i = getJavaNameIndex(tokens, i)) > 0) {
            res += " " + tokens[i];
       }
       
        return res;
    }

    private static int getJavaNameIndex(String[] tokens, int i) {
        i++;
        while(i < tokens.length && !isJavaName(tokens[i])) {
            i++;
        }
        return i < tokens.length ? i : -1;
    }

    private static boolean isJavaName(String string) {
        
        return string.matches(javaVariable()) && java.util.Arrays.binarySearch(Keywords, string) < 0;
}

public static boolean isArithmeticExpression(String expr) {
    String operand = "[a-zA-Z_$][a-zA-Z\\d_$]*|\\d+(\\.\\d+)?";
    String operator = "[+*/-]";
    String regex = "\\s*(" + operand + ")\\s*(" + operator + "\\s*(" + operand + ")\\s*)*";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(stack(expr));
    boolean checker = true;
        if (!matcher.matches()) {
            checker = false;
        }
    return bracketsValidity(expr) && checker;
}




//Additional Mehods
public static String stack(String expr) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder newExpr = new StringBuilder(expr);
        for (int i = 0; i < newExpr.length(); i++) { 
            char ch = newExpr.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    int start = stack.pop();
                    newExpr.replace(start, i + 1, "1");
                    i = start;
                }
            }
        }
        return newExpr.toString();
    }

    public static boolean bracketsValidity (String expr){
        int counter = 0;
    for (char ch : expr.toCharArray()){
        if (ch == '(') {
            counter++;
        } else if (ch == ')') {
            counter--;
            if (counter < 0) {
                return false;
            }
        }
    }
        return counter == 0 ? true : false;
    }

    //1. brackets
    //right position of open / close bracket is matter of regex
    //matching between open and close bracket is matter of the method you are supposed to write
    //based on a counter. If counter is negative - no matching;
    // if at ending up going through a string the counter doesn't equal 0 - no matching
    //matching may be only in one case: at the ending up of going the counter will be 0
    // Operator - regular expression for one out of 4 arithemetic operators [*/+-]
    //Operand may be either Java variable name or number (better any)

}
