package com.conceptcoding.behavioralpatterns.state.vendingmachinestates.impl;

import com.conceptcoding.behavioralpatterns.state.context.VendingMachine;
import com.conceptcoding.behavioralpatterns.state.vendingmachinestates.VendingMachineState;

// Step 2a: Concrete State - IdleState
// When machine has no coin inserted
public class IdleState extends VendingMachineState {

    @Override
    public void beginTransaction(VendingMachine vendingMachine) throws Exception {
        System.out.println("CurrentState: " + vendingMachine.getCurrentState().getClass().getSimpleName());
        System.out.println("A new Transaction has been started...");
        vendingMachine.setCurrentState(new SelectionState());
    }
    
}

