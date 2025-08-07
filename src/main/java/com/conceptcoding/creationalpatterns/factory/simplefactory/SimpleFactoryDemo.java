package com.conceptcoding.creationalpatterns.factory.simplefactory;

import com.conceptcoding.creationalpatterns.factory.Circle;
import com.conceptcoding.creationalpatterns.factory.Rectangle;
import com.conceptcoding.creationalpatterns.factory.Shape;
import com.conceptcoding.creationalpatterns.factory.Square;
import com.conceptcoding.creationalpatterns.factory.simplefactory.ShapeFactory;

// Step 3: Simple Factory Demo (Bloated Design)
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        System.out.println("======= Simple Factory Design Pattern ======");

        // set the type you want
        ShapeType shapeType = ShapeType.SQUARE;
        // get the shape
        Shape shape = ShapeFactory.createShapeInstance(shapeType);
        shape.draw();
        shape.computeArea();
    }

}
