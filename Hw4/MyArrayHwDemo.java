package HW4;

public class MyArrayHwDemo {
    static void showArray(int[] nums){
        System.out.print("[");
        for(int i=0; i<nums.length-1; i++)
            System.out.print(nums[i] + ",");
        if(nums.length>0)
            System.out.print(nums[nums.length-1]);
        System.out.println("]");
    }
    public static void main(String[] args) {
        MyArrayHw nums1;

        nums1 = new MyArrayHw();
        nums1.add(10); nums1.add(1); nums1.add(4);
        nums1.printArray(); // printArray(3,5): 10 1 4

        System.out.println("testing toArray()");
        showArray(nums1.toArray()); // [10,1,4]

        System.out.println("testing getEvenNumbers()");
        showArray(nums1.getEvenNumbers()); // [10,4]

        System.out.println("testing add(int val, int pos)");
        nums1.add(99,1); nums1.printArray(); // printArray(4,5): 10 99 4 1
        nums1.add(44,0); nums1.printArray(); // printArray(5,5): 44 99 4 1 10
        nums1.add(-5,5); nums1.printArray(); // printArray(6,10): 44 99 4 1 10 -5
        nums1.add(66,-1); nums1.printArray(); // printArray(6,10): 44 99 4 1 10 -5
        nums1.add(66,7); nums1.printArray(); // printArray(6,10): 44 99 4 1 10 -5

        System.out.println("testing shiftLeft()");
        nums1.shiftLeft(); nums1.printArray(); // printArray(6,10): 99 4 1 10 -5 44

        System.out.println("testing trimSize()");
        nums1.trimSize(); nums1.printArray(); // printArray(6,6): 99 4 1 10 -5 44
    }
}

