package HW4;

public class MyArrayHw {
    int numElements;
    int[] elements;
    public MyArrayHw(){
        numElements = 0;
        elements = new int[5];
    }
    void printArray(){
        System.out.printf("printArray(%d,%d): ", numElements,elements.length);
        for(int i=0; i<numElements; i++)
            System.out.print(elements[i] + " ");
        System.out.println();
    }
    private void enlarge(){
        // Increase the size of the array
        int[] newArray = new int[elements.length * 2];
        for(int i=0; i<numElements;i++)
            newArray[i] = elements[i];
        elements = newArray;
    }
    public void add(int val){
        if(isFull())
            enlarge();
        elements[numElements++] = val;
    }
    public int search(int val){
        return linearSearch(val);
    }
    private int linearSearch(int val){
        // return the index of an element equal to 'val'
        // return -1 if 'val' is not found
        for(int i=0; i<numElements; i++)
            if(val == elements[i])
                return i;
        return -1;
    }
    public void remove(int val){
        int idx = linearSearch(val);
        if(idx < 0)
            return;
        elements[idx] = elements[--numElements];
    }
    public boolean isFull() { return numElements == elements.length; }

    public int[] toArray() {
        // create and return a new array with the valid elements.
        // The size of the new array should be equal to numElements.
        int[] newarray = new int[numElements];
        for (int i = 0; i < newarray.length; i++) {
            newarray[i] = elements[i];
        }
        return newarray; // This is here to avoid syntax error. Change as needed
    }
    public int[] getEvenNumbers() {
        // create and return a new array that keeps only even numbers from 'elements'
        // eg) For elements with [3, 4, 10, 11, 8], this returns [4, 10, 8]
        // eg) For elements with [1, 2, 3, 5], this returns [2]
        // Hint: You need to count even numbers first to allocate memory as much as needed
        int evencounter = 0;
        int arraycounter = 0;
        for (int i = 0; i < numElements; i++) {
            if(elements[i] % 2 == 0)
                evencounter++;
        }
        int[] newarray = new int[evencounter];
        for (int i = 0; i < numElements; i++) {
            if(elements[i] % 2 == 0) {
                newarray[arraycounter] = elements[i];
                arraycounter++;
            }
        }
        return newarray; // This is here to avoid syntax error. Change as needed
    }
    public void add(int val, int pos) {
        // insert the given value 'val' at the given position 'pos'
        // Move the element originally at the position to the last position
        // eg) add(5, 1) for [10,20,30,40] will change it into [10,5,30,40,20]
        // Ignore and do nothing if 'pos' is invalid.
        // eg) For [10,20,30,40], valid insert position ranges from 0 to 4.
        if(pos > numElements || pos < 0){}
        else{
            if(isFull())
                enlarge();
            if(elements[pos] == 0)
                add(val);
            else {
                int temporary = elements[pos];
                elements[pos] = val;
                add(temporary);
            }
        }

    }
    public void shiftLeft(){
        // Make change to the array 'elements' by shifting elements to the left by 1.
        // The value at left-most position should go to the right-most position.
        // [10, 20, 30, 40] changes into [20, 30, 40, 10]
        int temp = elements[0];
        for (int i = 0; i < elements.length -1; i++) {
            elements[i] = elements[i + 1];

        }
        numElements--;
        add(temp);

    }
    public void trimSize(){
        // decrease the size of the array 'elements' just enough to keep existing elements.
        // eg) printArray(3, 10) will become printArray(3,3) after trimSize()
        int[] array = new int[numElements];
        for (int i = 0; i < array.length; i++) {
            array[i] = elements[i];

        }
        elements = array;

    }
}

