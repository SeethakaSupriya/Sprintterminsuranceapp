package com.cg.terminsurancepayment.service;

/** The IPaymentServiceImpl class provides access to repository methods to CRUD operations Cart details 
 * 
 * 
 * @author G5
 *
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.cg.terminsurancepayment.entity.Payment;
import com.cg.terminsurancepayment.exception.PaymentIdNotFoundException;
import com.cg.terminsurancepayment.repository.PaymentDaoImpl;
import com.cg.terminsurancepayment.exception.DuplicatePaymentException;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentDaoImpl payment;
	public Payment savePayment(Payment u) throws DuplicatePaymentException{

		return payment.save(u);
	}
	public Payment updatePayment(Integer paymentId, Payment u) throws PaymentIdNotFoundException {
		Payment u1 = payment.findById(paymentId)
				.orElseThrow(() -> new PaymentIdNotFoundException("Payment  not found for this id :: " + paymentId));
		u1.setPaymentId(u.getPaymentId());
		u1.setType(u.getType());
		u1.setStatus(u.getStatus());
		u1.setCardName(u.getCardName());
		u1.setCardNumber(u.getCardNumber());
		u1.setCardExpiry(u.getCardExpiry());
		u1.setCvv(u.getCvv());
		final Payment updatedPayment = payment.save(u1);
		return updatedPayment;
	}
	public Payment findPaymentById(@PathVariable(value = "id") Integer paymentId) throws PaymentIdNotFoundException {

		Payment u = payment.findByPaymentId(paymentId);
		if (u == null) {
			new PaymentIdNotFoundException("Payment not found for this id :: " + paymentId);
		}
		return u;
	}
	public List<Payment> getAllPayments() {
		return payment.findAll();
	}
}
