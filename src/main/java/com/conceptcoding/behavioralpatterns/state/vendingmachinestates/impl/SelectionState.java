package com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;

// Step 2b: Concrete State - SelectionState
// When the customer is selecting a product
public class SelectionState implements VendingMachineState {

    @Override
    public void beginTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You have already begun a transaction. Cancel to end the transaction.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String productCode) throws Exception {
        System.out.println("CurrentState: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("Product Selection in progress...");
        System.out.println("Product selected: " + productCode);
        vendingMachine.setSelectedProduct(vendingMachine.getInventory()
                .stream()
                .filter(product -> product.getProductCode().equals(productCode)).findFirst().get());
        vendingMachine.setCurrentState(new CollectMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Double amount) throws Exception {
        throw new Exception("You cannot before you choose a product.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Product cannot be dispensed in SelectionState. Select a product first and pay.");
    }
}

