package com.example.paymentservice.service;

import com.example.paymentservice.client.PayementGatwaySelector;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    PayementGatwaySelector payementGatwaySelector;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper = new ObjectMapper();

    public PaymentServiceImpl(PayementGatwaySelector payementGatwaySelector) {
        this.payementGatwaySelector = payementGatwaySelector;
    }
    @Override
    public String initiatePayment(String name, String phonenumber, String email, Double amount, String Description) {
        return payementGatwaySelector
                .getPaymentGateway()
                .generatePaymentLink(name, phonenumber, email, amount, Description);
    }
}
