package com.cg.terminsurancepayment.repository;
/** This is a repository class for Payment module 
 * 
 * @author G5
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.terminsurancepayment.entity.Payment;

@Repository
public interface PaymentDaoImpl extends JpaRepository<Payment, Integer>{
	@Query(value = "select * from payment where payment_id=?1", nativeQuery = true)
	Payment findByPaymentId(int paymentId);
}
