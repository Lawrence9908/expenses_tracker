package com.lawrence.expensetrackerapi.controller;

import com.lawrence.expensetrackerapi.entity.Expense;
import com.lawrence.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpense(Pageable page){
        return expenseService.getAllExpenses(page).toList();
    }
    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable("id") Long id){
        return expenseService.getExpenseById(id);
    }
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam("id") Long id){
        expenseService.deleteExpenseById(id);
    }
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }
    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense,@PathVariable Long id){
        return  expenseService.updateExpenseDetails(expense, id);
    }

}
