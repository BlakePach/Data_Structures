package HW5;

public class RightTriangle implements Comparable<RightTriangle> {

    double side1;
    double side2;

    public RightTriangle(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getArea(){
        return side1 * side2 / 2;
    }

    public double getPerimeter(){
        return side1 + side2 + (Math.sqrt(Math.pow(side1,2) + Math.pow(side2,2)));
    }


    public boolean equals(Object object) {
        RightTriangle temporary = (RightTriangle) object;
        return this.getPerimeter() == temporary.getPerimeter();
    }

    public int compareTo(RightTriangle object) {
        if(this.getPerimeter() < object.getPerimeter())
            return -1;
        else if(this.getPerimeter() > object.getPerimeter())
            return  1;
        else
            return 0;
    }

    public String toString(){
        return "RightTriangle( "+side1+","+side2+" )";
    }
}

