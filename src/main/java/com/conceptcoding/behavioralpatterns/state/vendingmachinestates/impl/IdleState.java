package com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;

// Step 2a: Concrete State - IdleState
// When machine has no coin inserted
public class IdleState implements VendingMachineState {
    @Override
    public void beginTransaction(VendingMachine vendingMachine) throws Exception {
        System.out.println("CurrentState: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("A new Transaction has been started...");
        vendingMachine.setCurrentState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, String productCode) throws Exception {
        throw new Exception("Product cannot be chosen in IdleState. You need to begin transaction first.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Double amountPaid) throws Exception {
        throw new Exception("You cannot pay in IdleState. Choose a product first.");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Product cannot be dispensed in IdleState. Choose a product first and pay.");
    }
}

