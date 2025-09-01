package com.conceptcoding.behavioralpatterns.state.context;

import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl.IdleState;

import java.util.ArrayList;

// Step 3: Context class - VendingMachine
// Holds reference to current state of the vending machine
public class VendingMachine {
    public ArrayList<Product> inventory;
    private VendingMachineState currentState;
    private Product selectedProduct;
    private double paymentMade;
    private double changeToReturn;

    public VendingMachine() {
        this.currentState = new IdleState(); // Initial state
        this.inventory = stockUpVendingMachine(); // Load the vending machine with products
    }

    public VendingMachineState getCurrentState() {
        return this.currentState;
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public double getPaymentMade() {
        return this.paymentMade;
    }

    public void setPaymentMade(double paymentMade) {
        this.paymentMade = paymentMade;
        this.changeToReturn = paymentMade - selectedProduct.getPrice();
        if (changeToReturn < 0) {
            throw new IllegalArgumentException("INSUFFICIENT PAYMENT: Payment made is less than the product price.");
        }
    }

    public double getChangeToReturn() {
        return this.changeToReturn;
    }

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    private ArrayList<Product> stockUpVendingMachine() {
        System.out.println("Stocking up the vending machine...");
        inventory = new ArrayList<>();
        // Shelf 1 - Soft Drinks
        inventory.add(new Product(ProductType.SOFT_DRINKS, "Coke(300ml)", "101", 70.00));
        inventory.add(new Product(ProductType.SOFT_DRINKS, "Pepsi(250ml)", "102", 50.00));
        inventory.add(new Product(ProductType.SOFT_DRINKS, "Sprite(250ml)", "103", 50.00));
        // Shelf 2 - Chips
        inventory.add(new Product(ProductType.CHIPS, "Lays", "201", 20.00));
        inventory.add(new Product(ProductType.CHIPS, "Nachos", "202", 60.00));
        inventory.add(new Product(ProductType.CHIPS, "Pringles", "203", 50.00));
        // Shelf 3 - Chocolates
        inventory.add(new Product(ProductType.CHOCOLATE, "Munch", "301", 20.00));
        inventory.add(new Product(ProductType.CHOCOLATE, "Snickers", "302", 50.00));
        inventory.add(new Product(ProductType.CHOCOLATE, "5star", "303", 35.00));

        return inventory;
    }

    public void displayInventory() {
        System.out.println("Inventory:");
        for (Product product : inventory) {
            System.out.println(product.toString());
        }
    }

    // State methods
    public void beginTransaction() throws Exception {
        currentState.beginTransaction(this);
    }

    public void chooseProduct(String productCode) throws Exception {
        currentState.chooseProduct(this, productCode);
    }

    public void insertCoin(Double amountPaid) throws Exception {
        currentState.insertCoin(this, amountPaid);
    }

    public void dispenseProduct() throws Exception {
        currentState.dispenseProduct(this);
    }
}

