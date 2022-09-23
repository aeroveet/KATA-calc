import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calc();
    }

    public static void calc() {
        String[] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabicNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] operator = {"+", "-", "*", "/"};

        int firstNum;
        int secondNum;
        int result = 0;
        String typeOfFirstNumber;
        String typeOfSecondNumber;
        String typeOfOperation;

        Scanner input = new Scanner(System.in);
        System.out.println(
                "Калькулятор принимает на вход числа от 1 до 10.\n" +
                        "Калькулятор умеет работать как с арабскими, так и с римскими цифрами.\n" +
                        "Введите математическое выражение, разделенное пробелами,\n" +
                        "в формате А + В: ");
        String expression = input.nextLine().trim();
        String[] array = expression.split(" ");

        if (array.length != 3) {
            throw new RuntimeException("строка не является математической операцией");
        }
        if (!Arrays.asList(operator).contains(array[1])) {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
        }

        if (Arrays.asList(arabicNumbers).contains(array[0])) {
            firstNum = Arrays.asList(arabicNumbers).indexOf(array[0]) + 1;
            typeOfFirstNumber = "arabic";
        } else if (Arrays.asList(romanNumbers).contains(array[0])) {
            firstNum = Arrays.asList(romanNumbers).indexOf(array[0]) + 1;
            typeOfFirstNumber = "roman";
        } else {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
        }

        if (Arrays.asList(arabicNumbers).contains(array[2])) {
            secondNum = Arrays.asList(arabicNumbers).indexOf(array[2]) + 1;
            typeOfSecondNumber = "arabic";
        } else if (Arrays.asList(romanNumbers).contains(array[2])) {
            secondNum = Arrays.asList(romanNumbers).indexOf(array[2]) + 1;
            typeOfSecondNumber = "roman";
        } else {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
        }

        if (typeOfFirstNumber.equals(typeOfSecondNumber)) {
            typeOfOperation = typeOfFirstNumber;
        } else {
            throw new RuntimeException("используются одновременно разные системы счисления");
        }
        switch (array[1]) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                result = firstNum / secondNum;
                break;
        }

        if (typeOfOperation == "arabic") {
            System.out.println(result);
        } else if (typeOfOperation == "roman" && result > 0) {
            String romanResult = new String();
            while (result == 100) {
                romanResult += "C";
                result -= 100;
            }
            while (result >= 90) {
                romanResult += "XC";
                result -= 90;
            }
            while (result >= 50) {
                romanResult += "L";
                result -= 50;
            }
            while (result >= 40) {
                romanResult += "XL";
                result -= 40;
            }
            while (result >= 10) {
                romanResult += "X";
                result -= 10;
            }
            while (result >= 9) {
                romanResult += "IX";
                result -= 9;
            }
            while (result >= 5) {
                romanResult += "V";
                result -= 5;
            }
            while (result >= 4) {
                romanResult += "IV";
                result -= 4;
            }
            while (result >= 1) {
                romanResult += "I";
                result -= 1;
            }
            System.out.println(romanResult);
        } else if (typeOfOperation == "roman" && result == 0) {
            throw new RuntimeException("в римской системе счисления нет цифры 0");
        } else {
            throw new RuntimeException("в римской системе нет отрицательных чисел");
        }
    }
}


    

