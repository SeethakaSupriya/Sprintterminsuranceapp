package com.cg.terminsurancepayment.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.terminsurancepayment.entity.Payment;
//import com.cg.terminsurancepayment.exception.DuplicatePaymentException;
//import com.cg.terminsurancepayment.exception.PaymentIdNotFoundException;
import com.cg.terminsurancepayment.repository.PaymentDaoImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceTest {

	@MockBean
	private PaymentDaoImpl paymentDaoImpl;


	@Autowired
	private PaymentService paymentService;

	@Test
	public void testSavePayment() {
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);
	}

	@Test
	void testUpdatePaymentById() throws Exception {
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);

		Mockito.when(paymentDaoImpl.findByPaymentId(102345)).thenReturn(payment);
		payment.setStatus("Failed");
		Mockito.when(paymentDaoImpl.save(payment)).thenReturn(payment);
		System.out.println(payment.getStatus());
		// assertThat(paymentService.updatePayment(102345,
		// payment)).isEqualTo(payment);
	}

	@Test
	void testGetPaymentById() throws Exception {
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);

		Mockito.when(paymentDaoImpl.findByPaymentId(102345)).thenReturn(payment);
		// findPaymentById()).get()).thenReturn(payment);
		// Mockito.when(paymentDaoImpl.findById(payment.getPaymentId()).get()).thenReturn(payment);
		assertThat(paymentService.findPaymentById(102345)).isEqualTo(payment);
	}

	@Test
	void testGetAllPayments() throws Exception {
		Payment payment = new Payment();
		payment.setPaymentId(102345);
		payment.setType("Debit");
		payment.setStatus("Success");
		payment.setCardName("Girija");
		payment.setCardNumber("6565 1234 5453 7771");
		payment.setCardExpiry("02/2022");
		payment.setCvv(123);

		Payment payment1 = new Payment();
		payment1.setPaymentId(102334);
		payment1.setType("Credit");
		payment1.setStatus("Failed");
		payment1.setCardName("sarayu");
		payment1.setCardNumber("6747 2234 5888 3241");
		payment1.setCardExpiry("12/2032");
		payment1.setCvv(634);
		Payment payment2 = new Payment();
		payment2.setPaymentId(102222);
		payment2.setType("Credit");
		payment2.setStatus("Failed");
		payment2.setCardName("Sravya");
		payment2.setCardNumber("0134 4354 6935 2734");
		payment2.setCardExpiry("11/2040");
		payment2.setCvv(331);
		Payment payment3 = new Payment();
		payment3.setPaymentId(102277);
		payment3.setType("Credit");
		payment3.setStatus("Failed");
		payment3.setCardName("Sravani");
		payment3.setCardNumber("1124 4054 0935 2234");
		payment3.setCardExpiry("07/2032");
		payment3.setCvv(326);
		Payment payment4 = new Payment();
		payment4.setPaymentId(123477);
		payment4.setType("Debit");
		payment4.setStatus("Success");
		payment4.setCardName("Divya");
		payment4.setCardNumber("0084 4783 0389 6214");
		payment4.setCardExpiry("08/2022");
		payment4.setCvv(396);

		List<Payment> paymentList = new ArrayList<>();
		paymentList.add(payment);
		paymentList.add(payment1);
		paymentList.add(payment2);
		paymentList.add(payment3);
		paymentList.add(payment4);
		
		Mockito.when(paymentDaoImpl.findAll()).thenReturn(paymentList);
		assertThat(paymentService.getAllPayments()).isEqualTo(paymentList);
	}

}
