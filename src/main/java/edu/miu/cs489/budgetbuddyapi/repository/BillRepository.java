package edu.miu.cs489.budgetbuddyapi.repository;

import edu.miu.cs489.budgetbuddyapi.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> getBillsByUserId(Long userId);
    Optional<Bill> getBillByIdAndUserId(Long billId, Long userId);
}
