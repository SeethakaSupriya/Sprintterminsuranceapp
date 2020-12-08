package com.cg.terminsurancepayment.control;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.terminsurancepayment.entity.Payment;
import com.cg.terminsurancepayment.exception.PaymentIdNotFoundException;
import com.cg.terminsurancepayment.exception.DuplicatePaymentException;
import com.cg.terminsurancepayment.service.PaymentService;

@RestController
@RequestMapping("/api/v2")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@PostMapping("/savepayment")
	public Payment savePayment( @RequestBody Payment payment ) throws DuplicatePaymentException{
		return paymentService.savePayment(payment);
	}

	@PutMapping("/updatepayment/{id}")
	public ResponseEntity<Payment> updatePaymentById(@PathVariable(value = "id") Integer paymentId,
			 @RequestBody Payment payment) throws PaymentIdNotFoundException {
		Payment payment1= paymentService.updatePayment(paymentId, payment);
		return  ResponseEntity.ok(payment1);
	}

	@GetMapping("/findpayment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable(value = "id") Integer paymentId) throws PaymentIdNotFoundException {
		Payment payment= paymentService.findPaymentById(paymentId);
		return  ResponseEntity.ok(payment);
	}
	@GetMapping("/getAllPayments")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}
}
