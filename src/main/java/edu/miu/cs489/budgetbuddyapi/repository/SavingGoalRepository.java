package edu.miu.cs489.budgetbuddyapi.repository;

import edu.miu.cs489.budgetbuddyapi.model.SavingGoal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingGoalRepository extends JpaRepository<SavingGoal, Long> {
}
