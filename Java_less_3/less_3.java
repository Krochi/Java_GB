import java.util.Arrays;

class AverageCalculator {
    public static int calculateAverage(int[] a) {
        // Проверка на пустой массив
        if (a.length == 0) {
            return 0;
        }
        
        // Подсчитываем сумму элементов массива
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        
        // Вычисляем среднее значение
        double average = (double) sum / a.length;
        
        // Округляем до ближайшего целого числа
        return (int) Math.round(average);
    }
}

// Класс Printer больше не public
class Printer {
    public static void main(String[] args) {
        int[] a;
        if (args.length == 0) {
            // При отправке кода на выполнение, можно варьировать эти параметры
            a = new int[]{4, 2, 7, 5, 1};
        } else {
            a = Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        AverageCalculator answer = new AverageCalculator();
        int result = answer.calculateAverage(a);
        System.out.println(result);
    }
}




//Задание 1. Удаление отрицательных значений из массива
//Реализуйте метод, который принимает на вход целочисленный массив и
//удаляет все отрицательные числа. Метод должен вернуть массив, содержащий
//только неотрицательные числа.


//Решение:

import java.util.ArrayList;
import java.util.Arrays;

class FilterNegative {
    public static int[] filterNegative(int[] a) {
        ArrayList<Integer> resultList = new ArrayList<>();
        
        for (int num : a) {
            if (num >= 0) {
                resultList.add(num);
            }
        }
        
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
        
        return resultArray;
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] a;
        if (args.length == 0) {
            a = new int[]{-1, 2, -3, 4, -5, 6};
        } else {
            a = Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        FilterNegative answer = new FilterNegative();
        String itresume_res = Arrays.toString(answer.filterNegative(a));
        System.out.println(itresume_res);
    }
}



//Задача 2. Уникальные числа
//Напишите метод, который принимает целочисленный массив и возвращает
//новый массив, содержащий только уникальные элементы из исходного
//массива.


//Решение:

import java.util.Arrays;
import java.util.LinkedHashSet;

class UniqueElements {
    public static int[] getUniqueElements(int[] a) {
        LinkedHashSet<Integer> uniqueSet = new LinkedHashSet<>();
        
        for (int num : a) {
            uniqueSet.add(num);
        }
        
        int[] resultArray = new int[uniqueSet.size()];
        int i = 0;
        for (int num : uniqueSet) {
            resultArray[i++] = num;
        }
        
        return resultArray;
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] a;
        if (args.length == 0) {
            a = new int[]{1, 2, 2, 3, 4, 4, 5};
        } else {
            a = Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        UniqueElements answer = new UniqueElements();
        String itresume_res = Arrays.toString(answer.getUniqueElements(a));
        System.out.println(itresume_res);
    }
}



//Задача 3. Длина слов
//Реализуйте метод, который принимает на вход массив строк и возвращает
//новый массив, содержащий только строки, длина которых больше 3 символов.

//Решение:

import java.util.ArrayList;
import java.util.Arrays;

class FilterStrings {
    public static String[] filterShortStrings(String[] arr) {
        ArrayList<String> resultList = new ArrayList<>();
        
        for (String str : arr) {
            if (str.length() > 3) {
                resultList.add(str);
            }
        }
        
        String[] resultArray = new String[resultList.size()];
        resultArray = resultList.toArray(resultArray);
        
        return resultArray;
    }
}

public class Printer {
    public static void main(String[] args) {
        String[] arr;
        if (args.length == 0) {
            arr = new String[]{"cat", "elephant", "dog", "giraffe"};
        } else {
            arr = args[0].split(", ");
        }
        FilterStrings answer = new FilterStrings();
        String itresume_res = Arrays.toString(answer.filterShortStrings(arr));
        System.out.println(itresume_res);
    }
}



//Задача 4*. Среднее значение массива
//Напишите метод, который принимает массив целых чисел и возвращает
//среднее значение элементов массива, округленное до ближайшего целого
//числа.

//Решение:

import java.util.Arrays;

class AverageCalculator {
    public static int calculateAverage(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int num : a) {
            sum += num;
        }
        
        double average = (double) sum / a.length;
        
        return (int) Math.round(average);
    }
}

public class Printer {
    public static void main(String[] args) {
        int[] a;
        if (args.length == 0) {
            a = new int[]{4, 2, 7, 5, 1};
        } else {
            a = Arrays.stream(args[0].split(",")).mapToInt(Integer::parseInt).toArray();
        }
        AverageCalculator answer = new AverageCalculator();
        int result = answer.calculateAverage(a);
        System.out.println(result);
    }
}
