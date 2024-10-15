Задание 1. Студенческий справочник


import java.util.ArrayList;
import java.util.HashMap;

class StudentDirectory {
    // HashMap для хранения студентов и их оценок
    private HashMap<String, ArrayList<Integer>> studentMap = new HashMap<>();

    // Добавляет или обновляет запись о студенте
    public void addStudent(String name, Integer grade) {
        // Если студент отсутствует, создаем для него новый список оценок
        studentMap.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);
    }

    // Находит оценки студента по имени
    public ArrayList<Integer> findStudent(String name) {
        // Возвращает оценки студента или пустой список, если студент не найден
        return studentMap.getOrDefault(name, new ArrayList<>());
    }

    // Возвращает весь справочник студентов
    public HashMap<String, ArrayList<Integer>> getAllStudents() {
        // Возвращаем весь словарь с данными студентов
        return studentMap;
    }

    // Удаляет запись о студенте по имени
    public void removeStudent(String name) {
        // Удаляем студента из справочника, если он существует
        studentMap.remove(name);
    }
}

// Класс для тестирования программы
public class Printer {
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        // Добавляем студентов
        directory.addStudent("Alice", 90);
        directory.addStudent("Bob", 85);
        directory.addStudent("Alice", 95);

        // До удаления
        System.out.println("Before removal:");
        System.out.println(directory.findStudent("Alice"));  // [90, 95]
        System.out.println(directory.getAllStudents());      // {Bob=[85], Alice=[90, 95]}

        // Удаляем студента
        directory.removeStudent("Alice");

        // После удаления
        System.out.println("After removal:");
        System.out.println(directory.findStudent("Alice"));  // []
        System.out.println(directory.getAllStudents());      // {Bob=[85]}
    }
}




Задача 2. История посещения веб-сайтов

import java.util.Deque;
import java.util.LinkedList;

class BrowserHistory {
    // Двухсторонняя очередь для хранения истории посещений
    private Deque<String> history = new LinkedList<>();

    // Добавляет сайт в историю посещений
    public void visitSite(String site) {
        // Добавляем сайт в начало истории
        history.addFirst(site);
    }

    // Возвращает название сайта, который был посещен steps назад
    public String back(int steps) {
        // Если шагов больше, чем доступно в истории, возвращаем null
        return history.stream()
                      .skip(steps)
                      .findFirst()
                      .orElse(null);
    }

    // Возвращает список сайтов в истории посещений
    public Deque<String> getHistory() {
        // Возвращаем саму очередь, так как она уже отсортирована от последнего к первому
        return history;
    }
}

// Класс для тестирования программы
public class Printer {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();

        // Посещаем сайты
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");

        // Возвращаемся на 1 шаг назад
        System.out.println(browserHistory.back(1));  // stackoverflow.com

        // Получаем всю историю посещений
        System.out.println(browserHistory.getHistory());  // [github.com, stackoverflow.com, google.com]
    }
}




Задача 3. Подсчет продуктов в корзине

import java.util.HashMap;

class ShoppingBasket {
    // HashMap для хранения продуктов и их количества
    private HashMap<String, Integer> basket = new HashMap<>();

    // Добавляет продукт с указанным количеством в корзину
    public void addProduct(String product, Integer quantity) {
        // Если продукт уже есть, увеличиваем количество
        basket.put(product, basket.getOrDefault(product, 0) + quantity);
    }

    // Удаляет продукт из корзины
    public void removeProduct(String product) {
        // Удаляем продукт, если он есть в корзине
        basket.remove(product);
    }

    // Обновляет количество продукта в корзине
    public void updateQuantity(String product, Integer quantity) {
        // Обновляем количество только если продукт есть в корзине
        if (basket.containsKey(product)) {
            basket.put(product, quantity);
        }
    }

    // Проверяет, есть ли продукт в корзине и возвращает его количество
    public int checkProduct(String product) {
        // Возвращаем количество продукта или 0, если его нет
        return basket.getOrDefault(product, 0);
    }

    // Выводит все продукты и их количество в корзине
    public void showBasket() {
        // Проходим по всем записям и выводим их
        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

// Класс для тестирования программы
public class Printer {
    public static void main(String[] args) {
        String product1, product2, product3;
        Integer quantity1, quantity2, quantity3;
        
        if (args.length == 0) {
            product1 = "apple";
            quantity1 = 3;
            product2 = "banana";
            quantity2 = 2;
            product3 = "apple";
            quantity3 = 5;
        } else {
            product1 = args[0];
            quantity1 = Integer.parseInt(args[1]);
            product2 = args[2];
            quantity2 = Integer.parseInt(args[3]);
            product3 = args[4];
            quantity3 = Integer.parseInt(args[5]);
        }

        ShoppingBasket basket = new ShoppingBasket();
        
        // Добавляем продукты в корзину
        basket.addProduct(product1, quantity1);
        basket.addProduct(product2, quantity2);
        basket.addProduct(product3, quantity3);

        System.out.println("Basket after adding products:");
        basket.showBasket();  // Выводим содержимое корзины
        
        // Удаляем продукт "banana"
        basket.removeProduct("banana");
        System.out.println("Basket after removing 'banana':");
        basket.showBasket();  // Выводим содержимое корзины после удаления

        // Обновляем количество продукта "apple"
        basket.updateQuantity("apple", 10);
        System.out.println("Basket after updating quantity of 'apple':");
        basket.showBasket();  // Выводим корзину после обновления

        // Проверяем количество продуктов
        System.out.println("Quantity of 'apple': " + basket.checkProduct("apple"));  // 10
        System.out.println("Quantity of 'banana': " + basket.checkProduct("banana"));  // 0
    }
}




Задача 4. Сортировка слиянием

import java.util.Arrays;

class MergeSort {
    // Метод для объединения двух отсортированных массивов
    public static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        // Объединяем два массива, сравнивая их элементы
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Копируем оставшиеся элементы из левого массива, если есть
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Копируем оставшиеся элементы из правого массива, если есть
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Метод сортировки слиянием
    public static void mergeSort(int[] array) {
        // Базовый случай рекурсии: если массив состоит из одного элемента, он уже отсортирован
        if (array.length < 2) {
            return;
        }

        // Разделяем массив на две части
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Рекурсивно сортируем каждую половину
        mergeSort(left);
        mergeSort(right);

        // Объединяем отсортированные половины
        merge(left, right, array);
    }
}

// Класс для тестирования программы
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{38, 27, 43, 3, 9, 82, 10};
        } else {
            initArray = Arrays.stream(args[0].split(" "))
                              .mapToInt(Integer::parseInt)
                              .toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));

        // Сортировка массива
        MergeSort.mergeSort(initArray);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
