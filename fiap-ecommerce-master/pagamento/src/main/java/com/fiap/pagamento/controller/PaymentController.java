package com.fiap.pagamento.controller;

import com.fiap.pagamento.domain.Payment;
import com.fiap.pagamento.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(
        "/payments"
)
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(
            path = "{id}"
    )
    public ResponseEntity<PaymentDetailsResponse> details(@PathVariable("id") Long paymentId) {
        final Optional<Payment> by = paymentService.findBy(paymentId);

        if (by.isPresent()) {
            return ResponseEntity.ok(new PaymentDetailsResponse(by.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> create(@RequestBody CreatePaymentRequest createPaymentRequest) throws URISyntaxException {

        Payment payment = null;

        if (createPaymentRequest.getPaymentMethod().equals("VISA")) {
            payment = paymentService.payWithVisa(createPaymentRequest.getUserId(), createPaymentRequest.getAmount());
        } else if (createPaymentRequest.getPaymentMethod().equals("MASTER")) {
            payment = paymentService.payWithMaster(createPaymentRequest.getUserId(), createPaymentRequest.getAmount());
        } else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.created(
                new URI("/payments/" + payment.getId())
        ).body(new PaymentResponse(payment));
    }


}
