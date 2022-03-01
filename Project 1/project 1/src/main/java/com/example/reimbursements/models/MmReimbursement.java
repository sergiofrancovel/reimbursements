package com.example.reimbursements.models;

import javax.persistence.*;

@Entity
@Table(name = "mm_reimbursements")
public class MmReimbursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee", nullable = false)
    private MmUser employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "manager", nullable = false)
    private MmUser manager;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "status", nullable = false)
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public MmUser getManager() {
        return manager;
    }

    public void setManager(MmUser manager) {
        this.manager = manager;
    }

    public MmUser getEmployee() {
        return employee;
    }

    public void setEmployee(MmUser employee) {
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MmReimbursement(MmUser employee, MmUser manager, Integer amount, String status) {
        this.employee = employee;
        this.manager = manager;
        this.amount = amount;
        this.status = status;
    }

    public MmReimbursement() {
    }
}