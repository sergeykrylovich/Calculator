package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator implements Command {
    private double result = 0;
    private String firstInput;
    private String secondInput;
    private String operation;



    private final List<String> listOfOperations = new ArrayList<>(List.of("+", "-", "*", "/"));

    public void sum(double firstNum, double secondNum) {
        result = firstNum + secondNum;
    }

    public void subtract(double firstNum, double secondNum) {
        result = firstNum - secondNum;
    }

    public void multiply(double firstNum, double secondNum) {
        result = firstNum * secondNum;
    }

    public void divide(double firstNum, double secondNum) {
        if (firstNum != 0) {
            result = firstNum / secondNum;
        } else {
            System.out.println("Division by zero is not allowed.");
        }

    }

    public double getResult() {
        return result;
    }


    public void execute(String operation, double firstNum, double secondNum) {
        switch (operation) {
            case ("+"):
                sum(firstNum, secondNum);
                break;
            case "-":
                subtract(firstNum, secondNum);
                break;
            case "*":
                multiply(firstNum, secondNum);
                break;
            case "/":
                divide(firstNum, secondNum);
                break;
        }
    }

    public boolean checkOperation(String operation) {
        if (listOfOperations.contains(operation)) {
            return true;
        }
        return false;
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Its simple calculator.");
        while (true) {
            System.out.print("Enter a number or type 'q' for quit: ");
            firstInput = scanner.nextLine();
            if (firstInput.equals("q")){
                System.out.print("Bye!");
                break;
            }
            System.out.print("Enter a second number: ");
            secondInput = scanner.nextLine();
            System.out.print("Enter possible operation (+, -, *, /): ");
            operation = scanner.nextLine();
            if (checkOperation(operation)) {
                try{
                    execute(operation, Double.parseDouble(firstInput), Double.parseDouble(secondInput));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format. Please enter a valid number.");
                    continue;
                }
                System.out.println("The result = " + result);
            } else {
                System.out.println("Wrong operation, try again or type 'q' for quit:");
            }


        }
    }


}
