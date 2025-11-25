package com.conceptcoding.interviewquestions.carrental.payment;

import com.conceptcoding.interviewquestions.carrental.Bill;

import java.util.Date;

public class Payment {
    Bill bill;
    PaymentDetails paymentDetails;

    public Payment(Bill bill) {
        this.bill = bill;
    }

    public void processPayment(PaymentMode paymentMode) {
        this.bill.setBillPaid(true);
        this.setPaymentDetails(generatePaymentDetails(paymentMode));
    }

    private PaymentDetails generatePaymentDetails(PaymentMode paymentMode) {
        PaymentDetails details = new PaymentDetails();
        details.setPaymentId(965);
        details.setAmountPaid(bill.getTotalBillAmount());
        details.setDateOfPayment(new Date());
        details.setRefundable(false);
        details.setPaymentMode(paymentMode);
        this.setPaymentDetails(details);
        return details;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}
