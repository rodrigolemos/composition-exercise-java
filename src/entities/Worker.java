/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Rodrigo Lemos
 */
public class Worker {
    
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();
    
    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary,
            Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract) {
        this.contracts.add(contract);
    }
    
    public void removeContract(HourContract contract) {
        this.contracts.remove(contract);
    }
    
    public double income(int year, int month) {

        double sum = this.baseSalary;
        Calendar cal = Calendar.getInstance();

        for (HourContract contract : contracts) {
            
            cal.setTime(contract.getDate());
            int contractYear = cal.get(Calendar.YEAR);
            int contractMonth = cal.get(Calendar.MONTH) + 1;

            if (contractYear == year && contractMonth == month) {
                sum += contract.totalValue();
            }
        }

        return sum;

    }
}
