package edu.miu.cs489.budgetbuddyapi.advice;

import edu.miu.cs489.budgetbuddyapi.utils.UserContextUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAdvice {

    @Before("(execution(* edu.miu.cs489.budgetbuddyapi.controller.IncomeController.*(..)) && args(userId,..)) ||" +
            "(execution(* edu.miu.cs489.budgetbuddyapi.controller.CategoryController.*(..)) && args(userId,..)) ||" +
            "(execution(* edu.miu.cs489.budgetbuddyapi.controller.ExpenseController.*(..)) && args(userId,..)) ||" +
            "(execution(* edu.miu.cs489.budgetbuddyapi.controller.SummaryController.*(..)) && args(userId,..)) ||" +
            "(execution(* edu.miu.cs489.budgetbuddyapi.controller.BillController.*(..)) && args(userId,..))")
    public void validateUserForCategoryController(JoinPoint joinPoint, Long userId) {
        UserContextUtil.validateUser(userId);
    }
}
