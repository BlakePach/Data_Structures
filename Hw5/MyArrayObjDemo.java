package HW5;

public class MyArrayObjDemo {
    public static void main(String[] args) {
        MyArray<Rectangle> rectangles = new MyArray<Rectangle>();
        Rectangle r1 = new Rectangle(2, 5);
        Rectangle r2 = new Rectangle(2, 4.9);

        System.out.println(r1.getArea() + ", " + r1.getPerimeter()); // 10.0, 14.0
        rectangles.add(r1); rectangles.add(r2); rectangles.add(new Rectangle(1,9));
        rectangles.printArray(); // printArray(3,5): Rect(2.0,5.0) Rect(2.0,4.9) Rect(1.0,9.0)
        System.out.println(rectangles.search(r2)); // 1
        System.out.println(rectangles.search(new Rectangle(5.0,2.0))); // 0
        rectangles.sort(); rectangles.printArray(); // printArray(3,5): Rect(1.0,9.0) Rect(2.0,4.9) Rect(2.0,5.0)

        MyArray<RightTriangle> rTriagles = new MyArray<RightTriangle>();
        RightTriangle rt1 = new RightTriangle(3, 4);
        RightTriangle rt2 = new RightTriangle(1, 1);

        System.out.println(rt1.getArea() + ", " + rt1.getPerimeter()); // 6.0, 12.0
        rTriagles.add(rt1); rTriagles.add(rt2); rTriagles.add(new RightTriangle(3.1, 3.9));
        rTriagles.printArray(); // printArray(3,5): RT(3.0,4.0) RT(1.0,1.0) RT(3.1,3.9)
        System.out.println(rTriagles.search(rt2)); // 1
        System.out.println(rTriagles.search(new RightTriangle(4,3))); // 0
        rTriagles.sort(); rTriagles.printArray(); // printArray(3,5): RT(1.0,1.0) RT(3.1,3.9) RT(3.0,4.0)

    }
}
