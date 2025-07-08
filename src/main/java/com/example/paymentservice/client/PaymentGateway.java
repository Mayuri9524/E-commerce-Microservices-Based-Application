package com.example.paymentservice.client;

public interface PaymentGateway {
  String generatePaymentLink(String name, String phonenumber, String email, Double amount, String Description);
}

