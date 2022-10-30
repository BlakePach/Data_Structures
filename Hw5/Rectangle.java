package HW5;

public class Rectangle implements Comparable<Rectangle>{

    double h;
    double w;

    public Rectangle(double h, double w){
        this.h = h;
        this.w = w;
    }

    public double getArea(){
        return h * w;
    }

    public double getPerimeter(){
        return w *2 + h *2;
    }

    public boolean equals(Object object) {
        Rectangle temp = (Rectangle) object;
        return this.getArea() == temp.getArea();
    }


    public int compareTo(Rectangle object) {
        if(this.getArea() < object.getArea())
            return -1;
        else if(this.getArea() > object.getArea())
            return  1;
        else
            return 0;
    }

    public String toString(){
        return "Rectangle( "+ h +","+ w +" )";
    }

}


