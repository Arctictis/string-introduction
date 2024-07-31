package telran.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @Test
    void number0_300TrueTest(){
        String regex = Strings.number0_300();
        assertTrue("0".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("1".matches(regex));

    }
    @Test
    void number0_300FalseTest(){
        String regex = Strings.number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("00".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse(" 20".matches(regex));
        assertFalse("1001".matches(regex));
    }
    @Test
    void ipV4OctetTrueTest(){
        String regex = Strings.ipV4Octet();
        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
    }
    @Test
    void ipV4OctetFalseTest(){
        String regex = Strings.ipV4Octet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }
    @Test
    void ipV4AddressTrueTest() {
        String regex = Strings.ipV4Address();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }
    @Test
    void ipV4AddressFalseTest() {
        String regex = Strings.ipV4Address();
        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0.-".matches(regex));
        assertFalse("0.0.0*0".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
    }
    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, Strings.stringWithJavaNames(names));
    }

    @Test
    public void testValidArithmeticExpressions() {
        assertTrue(Strings.isArithmeticExpression("2 + 3 * ( 4 - 1)"));
        assertTrue(Strings.isArithmeticExpression("a + b"));
        assertTrue(Strings.isArithmeticExpression("(x - y) / z"));
        assertTrue(Strings.isArithmeticExpression("((a + b) * (c / d))"));
        assertTrue(Strings.isArithmeticExpression("1 + 2 - 3 * 4 / 5"));
    }

    @Test
    public void testInvalidArithmeticExpressions() {
        assertFalse(Strings.isArithmeticExpression("2 + * 3"));
        assertFalse(Strings.isArithmeticExpression("a +"));
        assertFalse(Strings.isArithmeticExpression("(x - y / z"));
        assertFalse(Strings.isArithmeticExpression("((a + b) * (c / d))("));
        assertFalse(Strings.isArithmeticExpression("1 + (2 - 3 * 4 / 5"));
        assertFalse(Strings.isArithmeticExpression(""));
    }
}
    
