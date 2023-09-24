import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String str = in.nextLine();

        try {
            System.out.println(calc(str));
        }catch(InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
    public static String calc(String input) throws InvalidInputException {
        String expression = input;
        expression = expression.trim(); // обрезка лишних пробелов перед и после выражения

        int a = 0; // первое число
        int b = 0; // второе число
        int j = 0; // счетчик обработанных позиций expression
        int z = 0; // переменная для оператора
        int res = 0; // результат вычисления
        boolean bool = true; // для работы цикла while

        if (expression.codePointAt(j) >= 49 && expression.codePointAt(j) <= 57 && expression.length() >= 3) {
                a = Character.digit(expression.charAt(j), 10);
                if (a == 1 && Character.digit(expression.charAt(j+1), 10) == 0) {
                    a = 10;
                    j += 1;
                }
            }else{
            throw new InvalidInputException("т.к. строка не является математической операцией");
            }

        j += 1;

        while (bool == true){
            if (expression.codePointAt(j) == 32) {
                j += 1;
            }else{
                bool = false;
            }
        }

        switch (expression.codePointAt(j)) {
            case 42 :
                z = expression.codePointAt(j);
            case 43 :
                z = expression.codePointAt(j);
            case 45 :
                z = expression.codePointAt(j);
            case 47 :
                z = expression.codePointAt(j);
                break;
            default:
                throw new InvalidInputException("т.к. строка не является математической операцией");
        }

        j += 1;

        bool = true;
        while (bool == true){
            if (expression.codePointAt(j) == 32) {
                j += 1;
            }else{
                bool = false;
            }
        }

        if (expression.codePointAt(j) >= 49 && expression.codePointAt(j) <= 57) {
            b = Character.digit(expression.charAt(j), 10);
            if (b == 1 && Character.digit(expression.charAt(j+1), 10) == 0) {
                b = 10;
                j += 1;
            }
        }

        if (expression.length()-1 > j){
            throw new InvalidInputException("т.к. формат математической операции не удовлетворяет заданию");
        }

        switch (z) {
            case 42 :
                res = a * b;
                break;
            case 43 :
                res = a + b;
                break;
            case 45 :
                res = a - b;
                break;
            case 47 :
                res = a / b;
                break;
        }

        return "" + res; //Метод должен возвращать СТРОКУ с результатом их выполнения.
    }

}

