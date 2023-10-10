package org.example;

public interface Command {
    void execute(String operation, double firstNum, double secondNum);
    void sum( double firstNum, double secondNum);
    void divide(double firstNum, double secondNum);
    void multiply(double firstNum, double secondNum);
    void subtract(double firstNum, double secondNum);
}
