/*
Sort out the classes
You are given 4 classes — Shape, Polygon, Square, Circle.

Classes Polygon and Circle both extend the class Shape, the class Square extends the class Polygon.

You need to implement a method that takes Shape array and adds every element to one of the provided Lists based on their class.
 */

class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
        // write your code here
        for (Shape shape : array) {
            if (shape instanceof Circle) {
                circles.add((Circle) shape);
            } else if (shape instanceof Square) {
                squares.add((Square) shape);
            } else if (shape instanceof Polygon) {
                polygons.add((Polygon) shape);
            } else {
                shapes.add(shape);
            }
        }
    }
}

//Don't change classes below
class Shape {
}

class Polygon extends Shape {
}

class Square extends Polygon {
}

class Circle extends Shape {
}