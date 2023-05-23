package com.lawrence.expensetrackerapi.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="tbl_expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "expense_name")
    @NotNull(message = "Expense name must not be null")
    @Size(min = 3, message = "Expense name must be minimum of 3 characters")
    private String name;

    private String description;

    @Column(name ="expense_amount")
    @NotBlank(message = "Expense amount should not be null")
    private BigDecimal amount;

    @Column(name ="category")
    @NotNull(message = "Category should not be null")
    private String category;


    @Column(name = "date")
    @NotNull(message = "Date must not be null")
    private Date date;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updateAt;

}
