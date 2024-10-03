// Задание 1. Нахождение факториала числа
// Напишите метод factorial, который принимает число n и возвращает его
// факториал. Если число n < 0, метод должен вернуть -1.

// class Answer {
//     public int factorial(int n) {
//         if (n < 0) {
//             return -1;
//         }
//         // Факториал 0 всегда равен 1
//         // if (n == 0) {
//         //     return 1;
//         // }
        
//         int result = 1;
//         for (int i = 2; i <= n; i++) {
//             result *= i;
//         }
//         return result;
//     }
// }

// public class Printer {
//     public static void main(String[] args) {
//         int n = 5;
//         if (args.length > 0) {
//             n = Integer.parseInt(args[0]);
//         }
//         Answer ans = new Answer();
//         int itresume_res = ans.factorial(n);
//         System.out.println(itresume_res);
//     }
// }


// Задача 2. Вывод всех четных чисел от 1 до 100
// Напишите метод printEvenNums, который выведет на экран все четные числа
// в промежутке от 1 до 100, каждое на новой строке.

// class Answer {
//     public static void printEvenNums() {
//         for (int i = 1; i <= 100; i++) {
//             if (i % 2 == 0) {
//                 System.out.println(i);
//             }
//         }
//     }
// }
// public class Printer {
//     public static void main(String[] args) {
//         Answer ans = new Answer();
//         ans.printEvenNums();
//     }
// }



// Задача 3. Подсчет суммы цифр числа
// Напишите метод sumDigits, который принимает целое число n и возвращает
// сумму его цифр.

// class Answer {
//     public int sumDigits(int n) {
//         int sum = 0;
//         n = Math.abs(n);
//         while (n > 0) {
//             sum += n % 10;
//             n = n / 10;
//         }
//         return sum;
//     }
// }

// public class Printer {
//     public static void main(String[] args) {
//         int n = 12345; 
//         if (args.length > 0) {
//             n = Integer.parseInt(args[0]);
//         }
//         Answer ans = new Answer();
//         int itresume_res = ans.sumDigits(n);
//         System.out.println(itresume_res);
//     }
// }



// Задача 4*. Нахождение максимального из трех чисел
// Реализуйте две функции:
// 1. Функция findMaxOfTwo должна принимать два числа и возвращать
// максимальное из них, используя только знак сравнения.
// 2. Функция findMaxOfThree должна принимать три числа и находить
// максимальное из них, используя первую функцию.

class Answer {
    public int findMaxOfTwo(int a, int b) {
        return (a > b) ? a : b;
    }

    public int findMaxOfThree(int a, int b, int c) {
        int maxOfTwo = findMaxOfTwo(a, b);
        return findMaxOfTwo(maxOfTwo, c);
    }
}

public class Printer {
    public static void main(String[] args) {
        int a = 5, b = 10, c = 3; 
        if (args.length == 3) {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[1]);
            c = Integer.parseInt(args[2]);
        }
        Answer ans = new Answer();
        int itresume_res = ans.findMaxOfThree(a, b, c);
        System.out.println(itresume_res);
    }
}


