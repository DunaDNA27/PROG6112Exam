/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author oarat
 */
import java.util.Scanner;

public class product 
{
    //Object for scanner 
    Scanner scanner = new Scanner(System.in);
    
    // Method to generate and display the report
    public static void report(String[] productNames, double[][] sales) {
        final int PRODUCTS = sales.length;
        final int MONTHS = sales[0].length;

        double[] totalSalesPerProduct = new double[PRODUCTS];
        double grandTotalSales = 0;
        int mostPopularProductIndex = 0;
        double highestSales = 0;

        // Calculate totals and find most popular product
        for (int product = 0; product < PRODUCTS; product++) {
            double sum = 0;
            for (int month = 0; month < MONTHS; month++) {
                sum += sales[product][month];
            }
            totalSalesPerProduct[product] = sum;
            grandTotalSales += sum;

            if (sum > highestSales) {
                highestSales = sum;
                mostPopularProductIndex = product;
            }
        }

        // Calculate overall average sales
        double overallAverageSales = grandTotalSales / (PRODUCTS * MONTHS);

        // Output results
        System.out.println("\n=== Sales Report ===");
        for (int product = 0; product < PRODUCTS; product++) {
            System.out.printf("%s - Total Sales: %.0f units%n",
                    productNames[product], totalSalesPerProduct[product]);
        }
        System.out.printf("Grand Total Sales (All Products): %.0f units%n", grandTotalSales);
        System.out.printf("Overall Average Sales: %.2f units%n", overallAverageSales);
        System.out.printf("Most Popular Product: %s (Total Sales: %.0f units)%n",
        productNames[mostPopularProductIndex], highestSales);
    }
}

public class Product implements IProduct {
    private String name;
    private double[] monthlySales;

    // Static array to keep track of all products for popularity check
    private static Product[] allProducts;

    public Product(String name, double[] monthlySales) {
        this.name = name;
        this.monthlySales = monthlySales;
    }

    // Setter for all products (used to determine most popular)
    public static void setAllProducts(Product[] products) {
        allProducts = products;
    }

    @Override
    public int getTotalProductSold() {
        int total = 0;
        for (double sales : monthlySales) {
            total += sales;
        }
        return total;
    }

    @Override
    public double getAverageProductSold() {
        return getTotalProductSold() / (double) monthlySales.length;
    }

    @Override
    public String getMostPopularProduct() {
        if (allProducts == null || allProducts.length == 0) {
            return "No products available";
        }

        Product mostPopular = allProducts[0];
        for (Product p : allProducts) {
            if (p.getTotalProductSold() > mostPopular.getTotalProductSold()) {
                mostPopular = p;
            }
        }
        return mostPopular.name;
    }

    // Getter for product name
    public String getName() {
        return name;
    }
}

