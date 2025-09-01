package com.conceptcoding.behavioralpatterns.state;


import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;

// Client code - Interacts with Context Class (VendingMachine)
public class VendingMachineAppDemo {

    public static void main(String[] args) {
        System.out.println("###### State Design Pattern - Vending Machine App Demo ######");

        VendingMachine vendingMachine = new VendingMachine(); // Stock up the vending machine
        System.out.println("Flow: Begin Transaction > Choose Product > Pay > Collect Dispensed Product");
        vendingMachine.displayInventory();
        try {
            // Happy Flow 1: User Buys Lays
            System.out.println("--------------------------------------------------------------------------");
            vendingMachine.beginTransaction();
            vendingMachine.chooseProduct("201"); // Lays - 20 rupees
            vendingMachine.insertCoin(20.00);
            vendingMachine.dispenseProduct();

            // Happy Flow 2: User Buys Snickers
            System.out.println("--------------------------------------------------------------------------");
            vendingMachine.beginTransaction();
            vendingMachine.chooseProduct("303"); // Snickers - 35 rupees
            vendingMachine.insertCoin(50.00); // Change to be returned: 15 rupees
            vendingMachine.dispenseProduct();

            // Negative Flow 1: User pays insufficient amount
            System.out.println("--------------------------------------------------------------------------");
            vendingMachine.beginTransaction();
            vendingMachine.chooseProduct("103"); // Sprite - 50 rupees
            vendingMachine.insertCoin(20.00); // throws exception - INSUFFICIENT PAYMENT:
            vendingMachine.dispenseProduct(); // This line will not execute

            // Negative Flow 2: User tries to buy product without beginning a transaction
            System.out.println("--------------------------------------------------------------------------");
            // vendingMachine.chooseProduct("201"); // throws exception
            // vendingMachine.insertCoin(50.00); // throws exception
            // vendingMachine.dispenseProduct(); // throws exception

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("Flow: Begin Transaction > Choose Product > Pay > Collect Dispensed Product");
            vendingMachine.displayInventory();
        }
    }
}
