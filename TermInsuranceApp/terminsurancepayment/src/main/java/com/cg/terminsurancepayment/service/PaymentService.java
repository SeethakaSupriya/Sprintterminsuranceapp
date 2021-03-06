package com.cg.terminsurancepayment.service;

/** This is an interface which defines CRUD methods for Payment service
 * 
 * @author G5
 *
 */
import java.util.List;
import com.cg.terminsurancepayment.entity.Payment;
import com.cg.terminsurancepayment.exception.DuplicatePaymentException;
import com.cg.terminsurancepayment.exception.PaymentIdNotFoundException;

public interface PaymentService {
	public Payment savePayment(Payment payment) throws DuplicatePaymentException;

	public Payment updatePayment(Integer paymentId, Payment payment) throws PaymentIdNotFoundException;

	public Payment findPaymentById(Integer paymentId) throws PaymentIdNotFoundException;

	public List<Payment> getAllPayments();
}
