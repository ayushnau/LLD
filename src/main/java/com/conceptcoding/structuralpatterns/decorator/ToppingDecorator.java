package com.conceptcoding.structuralpatterns.decorator;

// Step 3: Define the Abstract Base Decorator
public abstract class ToppingDecorator implements BasePizza { // is-a relation ship with basepizza
    BasePizza pizza; // has-a relationship with basepizza

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }

}
