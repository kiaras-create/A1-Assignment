import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTests{

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
        compareToString(a1.appendArray(a2), "abcdefwxyz");
        compareToString(a2.appendArray(a1), "wxyzabcdef");
    }

    /**
     * Tests that appending a non-empty array to itself results in
     * a new array containing the elements repeated twice.
     */
    @Test
    public void testAppendSelf() {
        compareToString(a1.appendArray(a1), "abcdefabcdef");
        compareToString(a2.appendArray(a2), "wxyzwxyz");
    }

    /**
     * Tests that appending a non-empty array and an array of
     * length one results in a new array containing the elements
     * of both, in order.
     */
    @Test
    public void testAppendSingle() {
    compareToString(a1.appendArray(s),"abcdefs");
    compareToString(s.appendArray(a1),"sabcdef");
    compareToString(s.appendArray(s),"ss");
    }

    /**
     * Tests that appending an empty array
     * results in a new array that matches the other array
     */
    @Test
    public void testAppendEmpty() {
        compareToString(a1.appendArray(empty), "abcdef");
        compareToString(empty.appendArray(a1), "abcdef");
        compareToString(empty.appendArray(empty), "");
    }



    // ~*~*~*~*~ Add Extract Tests Below ~*~*~*~*~

//    /**
//     * Tests that if the entire array is being extracted 
//     */
   @Test
   public void testExtractEntire() {
       DynamicArray<Character> extracted = a1.extractArray(0, 6);
       assertEquals("6", extracted.lenArray(extracted.myArray));
   }
    /**
    * Tests that user attempts to extract zero elements
    */
    @Test
    public void testExtractZero() { 
        DynamicArray<Character> extracted = empty.extractArray(0, 0);
        assertEquals(0, extracted.lenArray(extracted.myArray));
    }


    /**
    * Tests that user attempts to extract an empty array  
    */
    @Test
    public void TestExtractNone(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(0, 5);
        });
       
        assertTrue(ex.getMessage().contains("Array is empty"));
    }



    /**
     * Tests that extract throws the proper exception
     * when called on invalid indices
     */

    @Test
    public void testExtractMethodException(){
           ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(-1, 10);
        });
        assertTrue(ex.getMessage().contains("Start index is negative and is out of bounds"));
    }
    /**
     * Test if the upper bound is too large
     */
    @Test
    public void testExtractUpperBound(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(1, 10);


        });
        assertTrue(ex.getMessage().contains("End index (toIndex) is out of bounds"));
    }
    /**
     * Test if the lower bound is too large
     */
    @Test
    public void testExtractLowerBound(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(9, 11);

        });
        assertTrue(ex.getMessage().contains("Start index (fromIndex) is too large"));
    }
    /**
     * Tests if the upper bound is negative
     */
    @Test
    public void TestExtractNegativeUpper(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(0, -1);

        });
        assertTrue(ex.getMessage().contains("End index (toIndex) is negative"));
    }
    /**
     * Tests if the upper bound is smaller than lower boudn
     */
    @Test
    public void textExtractUpperSize(){
        ArrayIndexOutOfBoundsException ex = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            a1.extractArray(4, 3);


        });
        assertTrue(ex.getMessage().contains("Start index (fromIndex) is larger than end index(toIndex)"));

      
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExtractBounds() {
        DynamicArray<Character> extract = a1.extractArray(-1, 5);
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


    // addElement method with index parameter tests 

    
    /**
     * Tests the add method, where you can add an element at any index
     */
    @Test
    public void testAddElementWithIndex(){
        a1.addElement(1, 'Z');

        assertEquals(4, a1.lenArray(a1.myArray));
        assertEquals("A", a1.getEle(0));
        assertEquals("B", a1.getEle(1));
        assertEquals("Z", a1.getEle(2));
        assertEquals("C", a1.getEle(3));
    }


    /**
     * Tests that method throws exception when index where element is added is less than 0
     */
    @Test
    public void testAddMethodThrowsException1() {
        IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> {
        a1.addElement(-1, 'z');

        });

        assertEquals("Your index is less than 0. It is out of bounds.", ex.getMessage());

    }


    /**
     * Tests that method throws exception when index where element is added is greater than array length
     */
    @Test
    public void testAddMethodThrowsException2() {
        IndexOutOfBoundsException ex = assertThrows(IndexOutOfBoundsException.class, () -> {
        a2.addElement(6, 'z');

        });

        assertEquals("Your index is greater than the array length. It is out of bounds", ex.getMessage());

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
     * tests that element is added to end of empty array
     */
    @Test
    public void testAddEleMethodWithNoIndex3() {
        empty.addElement('r');
        assertEquals(a1.getEle(0), 'r');

    }



}


   
   






