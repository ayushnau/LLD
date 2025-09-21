package com.conceptcoding.behavioralpatterns.interpreter;

// Client code
public class Client {
    public static void main(String[] args) {
        System.out.println("##### Interpreter Design Pattern #####");

        // Context
        Context context = new Context();
        context.setVariable("x", 12);
        context.setVariable("y", 5);
        context.setVariable("z", 3);
        System.out.println("Context: " + context);

        // Expression: x + y
        AbstractExpression expression1 = new AddNonTerminalExpression(
                new NumberTerminalExpression("x"),
                new NumberTerminalExpression("y"));
        System.out.println("Expression: (x+y) = " + expression1.interpret(context)); // Output: 17

        // Expression: x * y
        AbstractExpression expression2 = new MultiplyNonTerminalExpression(
                new NumberTerminalExpression("x"),
                new NumberTerminalExpression("y")
        );
        System.out.println("Expression: (x*y) = " + expression2.interpret(context)); // Output: 60

        // Complex Expression: (x + y) * z
        AbstractExpression expression3 = new MultiplyNonTerminalExpression(
                new AddNonTerminalExpression(
                        new NumberTerminalExpression("x"),
                        new NumberTerminalExpression("y")
                ),
                new NumberTerminalExpression("z")
        );
        System.out.println("Expression: ((x+y)*z) = " + expression3.interpret(context)); // Output: 51
    }
}
