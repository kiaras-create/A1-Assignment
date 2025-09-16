// import java.lang.reflect.Array;

// import com.apple.laf.AquaButtonBorder.Dynamic;

public class DynamicArray<T> implements IndexAccessADT<T> {

    int size; 
    T[] myArray;

    /**
     * Private utility to do array allocation
     */

    @SuppressWarnings("unchecked")
    private T[] allocate(int len) {
        return (T[]) new Object[len];
    }


    /**
     * base array constructor
     * @param size
     */
    public DynamicArray(int size) {
        this.myArray= allocate(size);
        this.size = size;
    }


    // GROUP TOGETHER
    /**
     * 
     * copy constructor that makes a deep copy and loops through base array to copy values
     * @param dynamicArray
     */
    public DynamicArray(T[] arr, int arraySize) {
        T[] myNewArray = allocate(arraySize);
        for (int i = 0; i < arraySize; i++) {
            myNewArray[i] = this.myArray[i];
        }

    }

    
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
      if (index > 0 && index < lenArray(myArray)) {
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
    public T setEle(int index, T newEle) {
        //Throwing exception if the index's out of bounds
        if(index < 0 || index > myArray.length){
            throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }

        
        //Saving the old element's index, replacing the old value with the new one, and returns old value's index
        //Cast and suppress warning
        @SuppressWarnings("unchecked")
        T oldEle =  (T) myArray[index];
        myArray[index] = newEle;
        return oldEle;

    }


   
    /**
     * 
     * @param arr array which user is passing in
     * @return length of the array
     */
    
    @Override
    public int lenArray(T[] arr) {
    
        int counter = 0;
        try  {
            while (true) {
                T temp = arr[counter];
                counter ++;
                //System.out.println(temp);
            } 
    

        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(("Error"));
        }
       // for (int i =0; i< size; i++){
            //counter ++;
        
        return counter;
            
        }



    // CHIASHI
    // DONE
    // NEED TO TEST
    /**
     * 
     * Inserts element in specified index and shifts subsequent elements to right
     * Throws exception if specified indicies are out of bounds
     * @param index 
     * @param element 
     */
    public void addElement(int index, T element) {
        if (index >= 0 && index < lenArray(myArray)) {
         DynamicArray<T> newArray = new DynamicArray<T>(lenArray(myArray) + 1);
         for (int i = 0; i < index; i++) {
            // T myEle = getEle(i);
            newArray.setEle(i, getEle(i));
         }
         newArray.setEle(index, element);
         for (int i = index; i < myArray.length; i++) {
            newArray.setEle(index+1, getEle(i));
        }
        } else {
         throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }
    }


    // CHIASHI
    // DONE
    // NEED TO TEST
     /**
     * 
     * Overloaded addElement method that appends element to end of array
     * @param element 
     */
     public void addElement(T element) {
        DynamicArray<T> newArray = new DynamicArray<T>(lenArray(myArray) + 1);
        for (int i = 0; i < myArray.length; i++) {
            newArray.setEle(i, getEle(i));
        }
        newArray.setEle(lenArray(myArray), element);
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
    public T[] appendArray(T[] dynamicArray) {
        DynamicArray<T> newArray =  new DynamicArray<T>(myArray.length + dynamicArray.length);

        for(int i = 0; i < myArray.length; i ++){
            newArray[i] = dynamicArray[i];
        }

        for(int i = 0; i < dynamicArray.length; i++){
            dynamicArray[myArray.length + i] = dynamicArray[1];
        }
         

         return dynamicArray;
        
    }



    // KIARA
    /**
     * 
     * @param index of the list
     * @param dynamicArray that will be removed from the dynamic array
     * Will remove a dynamic array from the specified indices
     * @return updated dynamic array
     */
    public DynamicArray<T> insertArray(T[] myDynamicArray, int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Incorrect Index");
             }
        
        int newLength = lenArray(myDynamicArray);
        int oldLength = lenArray(myArray);
        int totalLength = newLength + oldLength;


        DynamicArray<T> result = new DynamicArray<>(myArray, totalLength);
        for (int i = 0; i < index; i++ ){
            result.addElement(this.myArray[i]);
        }
        for (int j = 0; j < newLength; j++ ){
            result.addElement(myDynamicArray[j]);

        }
       
        for (int i = index; i < oldLength;  i++ ){
            result.addElement(this.myArray[i]);

        }
       
         return result;
        }
        




    // CHIASHI
    // DONE
    // NOT TESTED
    /**
     * 
     * returns elements from specified index and after as new dynamic array
     * throws exception if specified index is out of bounds
     * @param index
     * @return new dynamic array
     */
    public DynamicArray<T> splitSuffix(int index) {
        if (index >= 0 && index < lenArray(myArray)) {
            DynamicArray<T> newArray = new DynamicArray<>(myArray, (lenArray(myArray) - index));
            for (int i = index; i < lenArray(myArray); i++) {
                newArray.setEle(i-index, getEle(i));
            }
            return newArray;

        } else {
            throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }

    }

    /**
     * 
     * @param index
     * @return new dynamic array
     * returns elements before specified index as new dynamic array
     */
    public DynamicArray<T> splitPrefix(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Incorrect Index");
             }
        DynamicArray<T> result = new DynamicArray<>(myArray,index);
        for (int i = 0; i < index; i++ ){
            result.addElement(this.myArray[i]);
        }
       
         return result;
        }



    // CHIASHI
    // PARTIALLY DONE, SQUISHY ABOUT IF STATEMENT IN FOR LOOP
    // NOT TESTED
    /**
     * 
     * removes elements from first index up to other index in current array
     * throws an exception if specified indicies are out of bounds
     * @param startIndex
     * @param endIndex
     * @return updated dynamic array
     */
    public DynamicArray<T> deleteList(int startIndex, int endIndex) {
        if ((startIndex >= 0) && (startIndex < endIndex)) {
            if (endIndex > startIndex && endIndex <= lenArray(myArray)) {
                DynamicArray<T> updatedDArray = new DynamicArray<>(myArray, (lenArray(myArray) - (endIndex - startIndex)));
                for (int i = 0; i < lenArray(myArray); i++) {
                    // SQUISHY PART
                    if ((i < startIndex) || (i >= endIndex)) {
                        updatedDArray.setEle(i, getEle(i));
                    }
                }
                return updatedDArray;
            } else {
                throw new IndexOutOfBoundsException("Your end index is out of bounds.");
            }
        } else {
            throw new IndexOutOfBoundsException("Your start index is out of bounds.");
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
