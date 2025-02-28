package model;

public class Calculator {
    public static String calculate(float num1, float num2, String operation) {
        float result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    return "Error: division by zero!";
                }
                result = num1 / num2;
                break;
            default:
                return "Error: invalid operation!";
        }
        return String.valueOf(result);
    }
}
