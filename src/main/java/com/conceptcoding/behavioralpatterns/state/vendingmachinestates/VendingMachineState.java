package com.conceptcoding.behavioralpatterns.state.vendingmachinestates;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;

// Step 1: Define the State interface(abstract class)
// All states will implement this interface
public abstract class VendingMachineState {

    public void beginTransaction(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Transaction already in progress. Cancel to end the transaction.");
    }

    public void chooseProduct(VendingMachine vendingMachine, String productCode) throws Exception {
        throw new Exception("Product cannot be chosen in DispenseState. You need to begin transaction first.");
    }

    public void insertCoin(VendingMachine vendingMachine, Double amountPaid) throws Exception {
        throw new Exception("You cannot pay in DispenseState.  You need to begin transaction first.");
    }

    public void dispenseProduct(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Product cannot be dispensed in CollectMoneyState. You need to pay first.");
    }
    
}
