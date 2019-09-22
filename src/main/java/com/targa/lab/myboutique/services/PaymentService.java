package com.targa.lab.myboutique.services;


import com.targa.lab.myboutique.dto.PaymentDto;
import com.targa.lab.myboutique.entities.Order;
import com.targa.lab.myboutique.entities.Payment;
import com.targa.lab.myboutique.enumeration.PaymentStatus;
import com.targa.lab.myboutique.repository.OrderRepository;
import com.targa.lab.myboutique.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public static PaymentDto mapToDto(Payment payment) {
        if (payment != null) {
            return new PaymentDto(payment.getId(),
                    payment.getPaypalPaymentId(),
                    payment.getStatus().name(),
                    payment.getOrder().getId()
            );
        }
        return null;
    }

    public List<PaymentDto> findAll() {
        log.debug("Request to get all Payments");
        return this.paymentRepository.findAll()
                .stream()
                .map(PaymentService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PaymentDto findById(Long id) {
        log.debug("Request to get Payment : {}", id);
        return this.paymentRepository.findById(id).map(PaymentService::mapToDto).orElse(null);
    }

    public PaymentDto create(PaymentDto paymentDto) {
        log.debug("Request to create Payment : {}", paymentDto);
        Order order = this.orderRepository.findById(paymentDto.getOrderId()).orElseThrow(() -> new IllegalStateException("The Order does not exist!"));
        return mapToDto(this.paymentRepository.save(new Payment(paymentDto.getPaypalPaymentId(),
                PaymentStatus.valueOf(paymentDto.getStatus()),
                order
        )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Payment : {}", id);
        this.paymentRepository.deleteById(id);
    }

}
