package com.example.paymentservice.client;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelectorImpl implements PayementGatwaySelector {
    private final StripeGateway stripeGateway;

    public PaymentGatewaySelectorImpl(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }
    @Override
    public PaymentGateway getPaymentGateway() {

        return stripeGateway;
    }
}