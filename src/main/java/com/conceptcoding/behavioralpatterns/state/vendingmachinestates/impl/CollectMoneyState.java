package com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;

// Step 2c: Concrete State - CollectMoneyState
// When the customer makes the payment for selected product
public class CollectMoneyState extends VendingMachineState {

    @Override
    public void insertCoin(VendingMachine vendingMachine, Double amountPaid) throws Exception {
        System.out.println("Current State: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("You Paid: " + amountPaid);
        if (amountPaid < vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.initiateRefund(amountPaid);
            vendingMachine.setCurrentState(new IdleState());
            throw new Exception("INSUFFICIENT AMOUNT: Amount paid is less than the product price. Amount Refunded.");
        }
        vendingMachine.setPaymentMade(amountPaid);
        vendingMachine.setCurrentState(new DispenseState());
    }
    
}

