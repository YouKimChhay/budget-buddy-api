package edu.miu.cs489.budgetbuddyapi.repository;

import edu.miu.cs489.budgetbuddyapi.model.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingRepository extends JpaRepository<Saving, Long> {
}
