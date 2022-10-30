package HW6;

public class ListDemoHw {
    public static void printLinkedList(SLLNode<Integer> node) {
        // display all elements in the linked list
        while(node != null) {
            System.out.print(node.info + " ");
            node = node.next; // move to the next node
        }
        System.out.println();
    }
    static SLLNode<Integer> generateLL_sorted(int a, int b) {
        // Create/return a new linked list that has the two integers in ascending order
        // eg) generateLL2(10,20) returns a list {10,20}
        // eg) generateLL2(20,10) also returns a list {10,20}
        SLLNode<Integer> n1 = new SLLNode<>(a);
        SLLNode<Integer> n2 = new SLLNode<>(b);
        if(n1.info > n2.info){
            n2.next = n1;
            return n2;
        }
        else
            n1.next = n2;
            return n1;

    }
    static SLLNode<Integer> cons(int a, SLLNode<Integer> ls) {
        // Given an integer and a linked list
        // Create/return a new linked list that has the integer at the beginning.
        // eg) Suppose ls1={1,2,3}, cons(10, ls1) returns a new list {10, 1, 2, 3}
        SLLNode<Integer> Node = new SLLNode<>(a);
        Node.next = ls;
        return Node;
    }
    static SLLNode<Integer> cdr(SLLNode<Integer> ls) {
        // Given a non-empty linked list, remove the first node and return the rest of it.
        // eg) Suppose ls1={1,2,3}, cdr(ls1) removes 1 and returns the rest of list {2, 3}
        // eg) Suppose ls1={1}, cdr(ls1) removes 1 and returns null
        ls = ls.next;
        return ls; // This is here to avoid syntax error. Change as needed.
    }
    static SLLNode<Integer> generateLL_with_array(int[] nums) {
        // Create/return a new linked list using the given int array
        // Return null if the array is empty (size is zero).
        // eg) generateLL3(new int[]{2,3,4}) returns a list {2,3,4}
        SLLNode<Integer> n1, n2, head;
        if(nums.length == 1)
            return new SLLNode<>(nums[0]);
        n1 = new SLLNode<>(nums[0]);
        head = n1;
        for (int i = 1; i < nums.length; i++) {
            n2 = new SLLNode<>(nums[i]);
            n1.next = n2;
            n1 =n2;
        }
        return head; // This is here to avoid syntax error. Change as needed.
    }
    static SLLNode<Integer> getTail(SLLNode<Integer> ls){
        // Return the last node of the list.
        // Return null if the list is empty.
        if(ls.info == null)
            return null;
        while(ls.next != null){
            ls = ls.next;
        }
        return ls; // This is here to avoid syntax error. Change as needed.
    }
    static void attach(SLLNode<Integer> ls1, SLLNode<Integer> ls2) {
        // Given two linked lists, attach the second list at the end of the first list
        // eg) Suppose ls1={1,2,3}, ls2={50,60} as lists, attach(ls1, ls2) makes ls1 = {1,2,3,50,60}
        // Assume ls1 is not empty.
        // Hint: You need to go to the last node of ls1 and make a connection from it to the ls2
        getTail(ls1).next = ls2;
    }
    public static void main(String[] args) {
        printLinkedList(generateLL_sorted(3, 2)); // 2 3
        SLLNode<Integer> ls1 = generateLL_sorted(10, 20);
        printLinkedList(ls1); // 10 20

        ls1 = cons(30, ls1);
        printLinkedList(ls1); // 30 10 20
        printLinkedList(cons(-5,null)); // -5
        printLinkedList(cons(-10, cons(-5,null))); // -10 -5

        printLinkedList(cdr(ls1)); // 10 20
        printLinkedList(cdr(cdr(ls1))); // 20
        printLinkedList(cdr(cdr(cdr(ls1)))); // (blank line)

        printLinkedList(generateLL_with_array(new int[] {2})); // 2
        SLLNode<Integer> ls2 = generateLL_with_array(new int[] {2,3,4,5});
        printLinkedList(ls2); // 2 3 4 5

        System.out.println(getTail(ls1)); // SLLNode(20)
        System.out.println(getTail(ls2)); // SLLNode(5)

        attach(ls1,ls2); printLinkedList(ls1); // 30 10 20 2 3 4 5
        attach(ls1,generateLL_sorted(-1,-2)); printLinkedList(ls1); // 30 10 20 2 3 4 5 -2 -1
    }
}
