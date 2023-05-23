package com.lawrence.expensetrackerapi.service;

import com.lawrence.expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Expense expense, Long id);
    List<Expense> readByCategory(String category,Pageable page);
    List<Expense> readByName(String name, Pageable page);
    List<Expense> readByDate(Date startDate, Date endDate, Pageable page);

}
