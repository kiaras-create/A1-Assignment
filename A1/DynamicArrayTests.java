import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTests {

    private DynamicArray<Character> a1;
    private DynamicArray<Character> a2;
    private DynamicArray<Character> empty;
    private DynamicArray<Character> s;

    /**
     * Initializes DynamicArray<Character> instances to be used for testing.
     * Re-initializes before each test.
     * This ensures that tests do not interfere with one another.
     */
    @Before
    public void setUp() {
        a1 = stringToArray("abcdef");
        a2 = stringToArray("wxyz");
        empty = stringToArray("");
        s = stringToArray("s");
    }

    /**
     * Puts the characters of a string into an array structure
     */
    public DynamicArray<Character> stringToArray(String s) {
        DynamicArray<Character> result = new DynamicArray<Character>(s.length());
        for (int i = 0; i < s.length(); i++) {
            result.addElement(i, s.charAt(i));
            
        }
        return result;
    }

    /**
     * Compares the sizes of a DynamicArray<Character> and a string
     */
    public void compareSize(DynamicArray<Character> arr, String s){
        assertEquals("["+s+"] Array lengths are equal", arr.size(), s.length());
    }

    /**
     * Compares each element in a DynamicArray<Character>
     * against those in a string.
     */
    public void compareToString(DynamicArray<Character> arr, String s) {
        for (int i = 0; i < arr.size(); i++) {
            assertEquals("["+s+"] Elements are equal at index " + i, arr.getEle(i).charValue(), s.charAt(i));
        }
    }

    // ~*~*~*~*~ Append Tests Below ~*~*~*~*~

    /**
     * Tests that appending two non-empty arrays results in
     * a new array containing the elements of both, in order.
     */
    @Test
    public void testAppendStandard() {
        compareToString(a1.append(a2), "abcdefwxyz");
        compareToString(a2.append(a1), "wxyzabcdef");
    }

    /**
     * Tests that appending a non-empty array to itself results in
     * a new array containing the elements repeated twice.
     */
    @Test
    public void testAppendSelf() {
        compareToString(a1.append(a1), "abcdefabcdef");
        compareToString(a2.append(a2), "wxyzwxyz");
    }

    /**
     * Tests that appending a non-empty array and an array of
     * length one results in a new array containing the elements
     * of both, in order.
     */
    @Test
    public void testAppendSingle() {
    compareToString(a1.append(s),"abcdefs");
    compareToString(s.append(a1),"sabcdef");
    compareToString(s.append(s),"ss");
    }

    /**
     * Tests that appending an empty array
     * results in a new array that matches the other array
     */
    @Test
    public void testAppendEmpty() {
        compareToString(a1.append(empty), "abcdef");
        compareToString(empty.append(a1), "abcdef");
        compareToString(empty.append(empty), "");
    }



    // ~*~*~*~*~ Add Extract Tests Below ~*~*~*~*~

//    /**
//     * Tests that ...
//     */
//    @Test
//    public void testExtractStandard() {
//        // fill in standard cases
//    }
//
//    /**
//     * Tests that ..
//     */
//    @Test
//    public void testExtractEntire() {
//        // fill in extracting the entire array
//    }
//
//    /**
//     * Tests that ..
//     */
//    @Test
//    public void testExtractZero() {
//        // fill in extracting zero elements
//    }
//
//    /**
//     * Tests that ..
//     */
//    @Test
//    public void testExtractEmpty() {
//        // fill in extracting from an empty array
//    }

    /**
     * Tests that extract throws the proper exception
     * when called on invalid indices
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testExtractBounds() {
        DynamicArray<Character> extract = a1.extract(-1, 5);
        // More bounds that you can check:
        // low index is negative => throws ArrayIndexOutOfBoundsException
        // high index is greater than array length => throws ArrayIndexOutOfBoundsException
        // low index is greater than array length => throws ArrayIndexOutOfBoundsException
        // high index is negative => throws ArrayIndexOutOfBoundsException
        // high index is less than low
    }

    // ~*~*~*~*~ Write More Tests Below ~*~*~*~*~

    // write tests for the other methods here


    // getEle method tests

    /**
     * Tests that element at specific index can be accessed 
     * Returns accessed element
     */
    @Test
    public void testGetMethod() {
       assertEquals(a1.getEle(1), 'a');
    }

    /**
     * Tests that element at specific index can be accessed 
     * Returns accessed element
     */
    @Test
    public void testGetMethod2() {
       assertEquals(a2.getEle(3), 'z');
    }


    /**
     * tests that method throws expected exception when index is greater than array length
     */
    @Test
    public void testGetMethodThrowsExpectedException() {
        IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            a1.getEle(7);
        });

        assertEquals("Your index is greater than the array length. It is out of bounds.", ex.getMessage());
    }

    /**
     * tests that method throws expected exception when index is less than 0
     */
    @Test
    public void testGetMethodThrowsExpectedException2() {
        IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> {
            a1.getEle(-1);
        });

        assertEquals("Your index is less than 0. It is out of bounds.", ex.getMessage());
    }


    // extractArray method tests

    @Test
    public void testExtractMethodException(){
           ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(-1, 10);
        });
        assertTrue(ex.getMessage().contains("Start index is negative and is out of bounds"));
    }

    @Test
    public void testExtractUpperBound(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(1, 10);


        });
        assertTrue(ex.getMessage().contains("End index (toIndex) is out of bounds"));
    }

    @Test
    public void testExtractLowerBound(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(8, 10);

        });
        assertTrue(ex.getMessage().contains("Start index (fromIndex) is too large"));
    }

    @Test
    public void TestExtractNegativeUpper(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(0, -1);

        });
        assertTrue(ex.getMessage().contains("End index (toIndex) is negative"));
    }

    @Test
    public void textExtractUpperSize(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(4, 3);


        });
        assertTrue(ex.getMessage().contains("Start index (fromIndex) is larger than end index(toIndex)"));

      
    }


    // addElement method with index parameter tests 

    /**
     * tests that element is added to array at correct index
     */
    @Test
    public void testAddElementMethod() {

    }


    // addElement method with no index parameter tests 

    /**
     * tests that element is added to end of array
     */
    @Test
    public void testAddEleMethodWithNoIndex() {
        a1.addElement('g');
        assertEquals(a1.getEle(7), 'g');

    }

    /**
     * tests that element is added to end of array
     */
    @Test
    public void testAddEleMethodWithNoIndex2() {
        s.addElement('v');
        assertEquals(a1.getEle(1), 'v');

    }

    /**
     * tests that element is added to end of array
     */
    @Test
    public void testAddEleMethodWithNoIndex3() {
        empty.addElement('r');
        assertEquals(a1.getEle(0), 'r');

    }



}


   
   






