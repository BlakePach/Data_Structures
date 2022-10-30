package HW2;

public class ArrayPractice {

    static void printArray(int[] nums) {
        // This function is complete. Here to help your test
        System.out.print("printArray(): ");
        for(int i=0; i<nums.length;i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }

    static void shiftRightArray(int[] nums) {
        // make change to nums.
        // Shift the elements to the right by 1 position. left most elements goes to the right most pos.
        // nums = [10,2,3,-5]. shiftRightArray(nums) will change it to [-5, 10, 2,3]
        int temporary = nums[nums.length - 1];
        for (int i = nums.length - 2; i >=  0 ; i--) {
            nums[i + 1] = nums[i];
            
        }
        nums[0] = temporary;

    }

    static int[] generateEvenNumbers(int count) {
        // Return a new int array filled with n even numbers starting from 2.
        // eg) generateEvenNumbers(3) returns [2,4,6]
        // eg) generateEvenNumbers(5) returns [2,4,6,8,10]
        int [] evens = new int[count];

        for (int i = 0; i < evens.length; i++) {
            evens[i] = (i+1) * 2;

        }
        return evens;
    }

    static int[] insertKeepOrder(int[] nums, int idx, int val) {
        // Return a new int array.
        // insert the given 'val' at index 'idx' pushing numbers to the right.
        //        insertKeepOrder([10,20,30],0,5) will return [5, 10, 20, 30]
        //        insertKeepOrder([10,20,30],1,5) will return [10, 5, 20, 30]

        int[] bigger = new int[nums.length + 1];
        int temporary = nums[idx];

        for(int i = 0; i < nums.length; i++){
            if(i == idx) {
                bigger[idx] = val;
                bigger[idx+1] = temporary;
                i++;
                for(int j = i; j < nums.length; j++){
                    bigger[j+1] = nums[j];

                }
                i = nums.length;

            }
            else
                bigger[i] = nums [i];
        }

        return bigger;
    }


    static int[] reverseNew(int[] nums) {
        // Return a new int array that is reversed version of nums
        // eg) reverseNew([1,2,3]) returns [3,2,1]
        // eg) reverseNew([5,1,2,3]) returns [3,2,1,5]
        int[] reversed = new int[nums.length];
        int index = nums.length - 1;

        for (int i = 0; i < nums.length ; i++) {
            reversed[index] = nums[i];
            index = index -1 ;

        }
        return reversed;


    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {10,2,3,-5,20,10,4};
// add you test codes below. You have freedom how to test.
		shiftRightArray(nums1);
		printArray(nums1);
        printArray(generateEvenNumbers(3));
        printArray(generateEvenNumbers(5));
        printArray(insertKeepOrder(new int[]{10, 20, 30},0,5));
        printArray(insertKeepOrder(new int[]{10, 20, 30},1,5));
        printArray(reverseNew(new int[]{1,2,3}));
        printArray(reverseNew(new int[]{5,1,2,3}));


    }

}
