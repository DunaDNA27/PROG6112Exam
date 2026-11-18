/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport;

/**
 *
 * @author oarat
 */
import java.util.Scanner;

public class SalesReport 
{
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        final int PRODUCTS = 3;
        final int MONTHS = 3;
        String[] productNames = {
            "Cozy nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"};
                double[][] sales = new double[PRODUCTS][MONTHS];

        // Input sales data
        System.out.println("Enter number of sales (units sold) for each product over 3 months:");
        for (int product = 0; product < PRODUCTS; product++) {
            System.out.println("\nProduct: " + productNames[product]);
            for (int month = 0; month < MONTHS; month++) {
                while (true) {
                    System.out.printf("Month %d sales: ", month + 1);
                    if (scanner.hasNextDouble()) {
                        double value = scanner.nextDouble();
                        if (value >= 0) { // No negative sales
                            sales[product][month] = value;
                            break;
                        } else {
                            System.out.println("Sales cannot be negative. Try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a numeric value.");
                        scanner.next(); // Clear invalid input
                    }
                }
            }
        }

        // Call report method
        product.report(productNames, sales);
    }
   
}
