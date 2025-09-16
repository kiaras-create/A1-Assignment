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
        T[] myNewArray = allocate(lenArray(arr) + arraySize);
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
        if(index < 0 || index >= myArray.length){
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
        if (index > 0 && index < lenArray(myArray)) {
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
            if(index < 0 || index >= myArray.length){
                throw new IndexOutOfBoundsException("Your index is out of bounds.");
            }

            DynamicArray<T> newArray =  new DynamicArray<T>(lenArray(myArray) - 1);

            for(int i = 0; i < myArray.length; i++ ){
                newArray.setEle(i, getEle(i)); //saving the stuff from old array into the same indeces for the new one
            }

            for (int i = index + 1; i < myArray.length; i++){
                newArray.setEle(i - 1, getEle(i));
            }

            this.myArray = newArray.myArray; // this new shelf is my shelf now; not sure if needed

            return element;


        
    }


    // VICTORIA
    /**
     * @param dynamicArray that will be concatenated to the end of the array
     * Will add a the dynamic array to the end of the array
     * @return updated dynamic array
     */
    public DynamicArray<T> appendArray(DynamicArray<T> appendedArray) {
        DynamicArray<T> newArray =  new DynamicArray<T>(this.size + appendedArray.size);

        for(int i = 0; i < appendedArray.size; i ++){
            T value = appendedArray.getEle(i); //getting a variable type T name value that gets the element at that index
            newArray.setEle(this.size + i, value);
        }
         return newArray;
        
    }



    // KIARA
    /**
     * 
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
    /**
     * 
     * returns elements from specified index and after as new dynamic array
     * throws exception if specified index is out of bounds
     * @param index
     * @return new dynamic array
     */
    public DynamicArray<T> splitSuffix(int index) {
        if (index > 0 && index < myArray.length) {
            DynamicArray<T> newArray = new DynamicArray<T>(lenArray(myArray) - index);
            for (int i = index; i < myArray.length; i++) {
                newArray[i-index] = myArray[i];
            }
            return newArray;

        } else {
            throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }

    }

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
    public DynamicArray<T> deleteList(int startIndex, int endIndex) {
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
    public DynamicArray<T> extractArray(int fromIndex, int toIndex) {
        //making the new array
        DynamicArray<T> extractedArray =  new DynamicArray<T>( toIndex - fromIndex);

        //the value i is the value we are starting from, it should be less than the one we want to end at, and increment
        for(int i = fromIndex; i < toIndex; i ++){
            T value = getEle(i); //getting a variable type T name value that gets the element at that index
            extractedArray.setEle(i - fromIndex, value); //let the new array set that element into the array; from the index minus the starting value (this allows the value to be put in the right index position), and place that value there


        }

        return extractedArray; //returning array

    }

}
