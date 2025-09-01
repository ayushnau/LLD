package com.conceptcoding.behavioralpatterns.state.vendingmachinestates;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;

// Step 1: Define the State interface
// All states will implement this interface
public interface VendingMachineState {
    void beginTransaction(VendingMachine vendingMachine) throws Exception;

    void chooseProduct(VendingMachine vendingMachine, String productCode) throws Exception;

    void insertCoin(VendingMachine vendingMachine, Double amount) throws Exception;

    void dispenseProduct(VendingMachine vendingMachine) throws Exception;
}
