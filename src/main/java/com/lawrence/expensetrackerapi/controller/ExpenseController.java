package com.lawrence.expensetrackerapi.controller;

import com.lawrence.expensetrackerapi.entity.Expense;
import com.lawrence.expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
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
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam("id") Long id){
        expenseService.deleteExpenseById(id);
    }
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@Valid @RequestBody Expense expense){
        return expenseService.saveExpenseDetails(expense);
    }
    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@Valid @RequestBody Expense expense,@PathVariable Long id){
        return  expenseService.updateExpenseDetails(expense, id);
    }
    @GetMapping("/expenses/category")
    public List<Expense> getAllExpensesByCategory(@RequestParam String category, Pageable page){
        return expenseService.readByCategory(category, page);
    }

    @GetMapping("/expenses/name")
    public List<Expense> readByName(@RequestParam String name, Pageable page){
        return expenseService.readByName(name, page);
    }
    @GetMapping("/expenses/date")
    public List<Expense> getAllExpensesByName(@RequestParam(required = false) Date startDate,
                                              @RequestParam(required = false) Date endDate,
                                              Pageable page){
        return expenseService.readByDate(startDate, endDate, page);
    }
}
