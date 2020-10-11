/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositionexercise;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Rodrigo Lemos
 */
public class CompositionExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        // Configuring inputs
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        // Capturing worker data
        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        
        System.out.println("Enter worker data: ");
        
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();
        
        // Init worker
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),
                baseSalary, new Department(departmentName));
        
        // Capturing contracts data
        System.out.print("How many contracts to this worker? ");
        int qtdContracts = sc.nextInt();
        
        for (int i = 1; i <= qtdContracts; i++) {
            
            System.out.println("Enter contract #" + i + " data");
            
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            
            // Init contract
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            
            // Associate contract to worker
            worker.addContract(contract);

        }
        
        System.out.println();

        // Capturing data to calculate
        System.out.print("Enter month and year to calculate income (YY/MMMM): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        
        // Showing result
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": "
                + String.format("%.2f", worker.income(year, month)));
        
        sc.close();

    }
    
}
