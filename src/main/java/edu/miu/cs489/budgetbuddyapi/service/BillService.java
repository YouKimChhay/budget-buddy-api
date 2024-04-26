package edu.miu.cs489.budgetbuddyapi.service;

import edu.miu.cs489.budgetbuddyapi.model.Bill;
import edu.miu.cs489.budgetbuddyapi.model.Expense;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface BillService {
    Bill addNewBill(Long userId, Bill bill);
    List<Bill> getAllBills(Long userId);
    Bill getBillById(Long userId, Long billId) throws EntityNotFoundException;
    Bill updateBillById(Long userId, Long billId, Bill updatedBill) throws EntityNotFoundException;
    void deleteBillById(Long userId, Long billId);
    Expense payBill(Long userId, Long billId) throws EntityNotFoundException;
}
