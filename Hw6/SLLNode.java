package HW6;

public class SLLNode<E> {
    E info;
    SLLNode<E> next;
    public SLLNode(E e){
        info = e;
        next = null;
    }
    public String toString() {
        return "SLLNode(" + info + ")";
    }
}
