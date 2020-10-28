package com.fiap.pagamento.service;

import com.fiap.pagamento.domain.Payment;
import com.fiap.pagamento.domain.PaymentMethod;
import com.fiap.pagamento.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(final PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment payWithVisa(final long userId, final BigDecimal amount) {
        return pay(userId, amount, PaymentMethod.CREDIT_CARD_VISA);
    }

    public Payment payWithMaster(final long userId, final BigDecimal amount) {
        return pay(userId, amount, PaymentMethod.CREDIT_CARD_MASTER);
    }

    private Payment pay(final long userId, final BigDecimal amount, final PaymentMethod creditCardMaster) {
        return paymentRepository.save(new Payment(userId,
                amount,
                1,
                creditCardMaster,
                LocalDateTime.now()));
    }

    public Page<Payment> getAllPayments() {
        return paymentRepository.findAll(PageRequest.of(0, 10));
    }

    public Optional<Payment> findBy(final Long paymentId) {
        return paymentRepository.findById(paymentId);
    }
}
