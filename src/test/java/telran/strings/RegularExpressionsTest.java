package telran.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    @Test
    void javaVariableTest(){
        String[] str = {"myVar", "1stVar", "$dollar","var-name", "_underscore", "my var", "var123", "#var", "v_$1", ""};
         List<Integer> expectedInvalidIndex = Arrays.asList(1, 3, 5, 6, 7, 8, 9);
         List<Integer> invalidIndex = Strings.findInvalidVariableIndex(Strings.javaVariable(), str);
    assertEquals(expectedInvalidIndex , invalidIndex);
    String[] str2 = {"Hello", "Java", "World"};
    List<Integer> expectedInvalidIndex2 = Arrays.asList();
    List<Integer> invalidIndex2 = Strings.findInvalidVariableIndex(Strings.javaVariable(), str2);
assertEquals(expectedInvalidIndex2 , invalidIndex2);
String[] str3 = {"Hello", "Java", "World","_", "while"};
    List<Integer> expectedInvalidIndex3 = Arrays.asList(3,4);
    List<Integer> invalidIndex3 = Strings.findInvalidVariableIndex(Strings.javaVariable(), str3);
assertEquals(expectedInvalidIndex3 , invalidIndex3);
    }


}
