// import java.lang.reflect.Array;

public class DynamicArray<T> implements IndexAccessADT<T> {

    int size; 
    Object[] myArray;


    /**
     * base array
     * @param size
     */
    public DynamicArray(int size) {
    this.myArray = new Object[size];
    this.size = size;
    }


    // GROUP TOGETHER
    /**
     * SPECIAL CONSTRUCTOR ABOUT DYNAMIC ARRAY
     * copy constructor that makes a deep copy
     * @param dynamicArray
     */
    // public Array(T[] dynamicArray) {
    //    T[] newArray = 
    // }

    
    // CHIASHI
    // ASK IF WRITING ABOUT GENERIC ARRAY OR DEEP ARRAY "MYARRAY"
    /**
     * 
     * returns element at specific index
     * will throw an exception if specified index is out of bounds
     * @param index 
     * @return element which was accessed
     */
    public T getEle(int index) {
      if (index > 0 && index < myArray.length) {
         return myArray[index];
      } else {
         throw new IndexOutOfBoundsException("Your index is out of bounds.");
      }

    }

    
    // VICTORIA
    /**
     * 
     * @param index of element the user is attempting to modify
     * change/set the element at specified index
     * will throw an exception if the specified index is out of bounds
     * @return element which was modified
     */
    public T setEle(int index) {

    }


   
    /**
     * 
     * @param arr array which user is passing in
     * @return length of the array
     */
    
    @Override
    public int lenArray(T[] arr) {
    
        int counter = 0;
        for (int i =0; i<arr.length; i++){
            counter ++;
        }
        return counter;
            
        }



    // CHIASHI
    /**
     * 
     * Inserts element in specified index and shifts all other elements accordingly
     * Throws exception if specified indicies are out of bounds
     * @param index 
     * @param element 
     * @return updated dynamic array
     */
    public T addElement(int index, T element) {
        if (index > 0 && index < myArray.length) {
         T[] newArray = new DynamicArray(myArray.length + 1);
         for (int i = 0; i < index; i++) {
            newArray[i] = myArray[i];
         }
         newArray[index] = element;
         for (int i = index; i < myArray.length; i++) {
            newArray[index + i] = myArray[i];
         }
         return newArray;
        } else {
         throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }
    }


     /**
     * 
     * Overloaded addElement method that appends element to end of array
     * @param element 
     * @return updated dynamic array
     */
     public T addElement(T element) {
        T[] newArray = new DynamicArray(myArray.length + 1);
        for (int i = 0; i < myArray.length; i++) {
            newArray[i] = myArray[i];
        }
        newArray[newArray.length - 1] = element;
        return newArray;
     }



    // VICTORIA
    /**
     * 
     * @param index of element user wants to remove
     * @param element that will be removed at the specified index
     * Removes element at specified index and shifts all other elements left 
     * @return updated dynamic array
     */
        public T removeElement(int index, T element) {
        
    }


    // VICTORIA
    /**
     * @param dynamicArray that will be concatenated to the end of the array
     * Will add a the dynamic array to the end of the array
     * @return updated dynamic array
     */
    public T appendArray(T dynamicArray) {
        
    }



    // KIARA
    /**
     * 
     * @param index of the list
     * @param dynamicArray that will be removed from the dynamic array
     * Will remove a dynamic array from the specified indices
     * @return updated dynamic array
     */
    public T insertArray(T dynamicArray, int index) {
        
    }



    // CHIASHI
    /**
     * 
     * returns elements from specified index and after as new dynamic array
     * throws exception if specified index is out of bounds
     * @param index
     * @return new dynamic array
     */
    public T splitSuffix(int index) {
        if (index > 0 && index < myArray.length) {
            T[] newArray = new DynamicArray(myArray.length - index);
            for (int i = index; i < myArray.length; i++) {
                newArray[i-index] = myArray[i];
            }
            return newArray;

        } else {
            throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }

    }



    // KIARA
    /**
     * 
     * @param index
     * @return new dynamic array
     * returns elements before specified index as new dynamic array
     */
    public T splitPrefix(int index) {

    }



    // CHIASHI
    // NOT DONE
    // QUESTION ABOUT HOW TO FORMAT ARGUMENT FOR IF STATEMENT
    /**
     * 
     * removes elements from first index up to other index in current array
     * throws an exception if specified indicies are out of bounds
     * @param startIndex
     * @param endIndex
     * @return updated dynamic array
     */
    public T deleteList(int startIndex, int endIndex) {
        if ((startIndex > 0 && startIndex < myArray.length) && (endIndex > 0 && endIndex <= myArray.length)) {
            T[] newArray = new DynamicArray(myArray.length - (endIndex - startIndex));
            for (int i = 0; i < startIndex; i++) {
                newArray[i] = myArray[i];
            }
            // QUESTION ABOUT INDICIES FOR NEWARRAY ELEMENT
            for (int i = endIndex; i < myArray.length; i++) {
                newArray[endIndex - startIndex] = myArray[i];
            }
            return newArray;
        } else {
            throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }
        
    }


    // VICTORIA
    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return new dynamic array
     */
    public T extractArray(int fromIndex, int toIndex) {
        
    }

}
