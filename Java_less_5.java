������� 1. ������������ ����������


import java.util.ArrayList;
import java.util.HashMap;

class StudentDirectory {
    // HashMap ��� �������� ��������� � �� ������
    private HashMap<String, ArrayList<Integer>> studentMap = new HashMap<>();

    // ��������� ��� ��������� ������ � ��������
    public void addStudent(String name, Integer grade) {
        // ���� ������� �����������, ������� ��� ���� ����� ������ ������
        studentMap.computeIfAbsent(name, k -> new ArrayList<>()).add(grade);
    }

    // ������� ������ �������� �� �����
    public ArrayList<Integer> findStudent(String name) {
        // ���������� ������ �������� ��� ������ ������, ���� ������� �� ������
        return studentMap.getOrDefault(name, new ArrayList<>());
    }

    // ���������� ���� ���������� ���������
    public HashMap<String, ArrayList<Integer>> getAllStudents() {
        // ���������� ���� ������� � ������� ���������
        return studentMap;
    }

    // ������� ������ � �������� �� �����
    public void removeStudent(String name) {
        // ������� �������� �� �����������, ���� �� ����������
        studentMap.remove(name);
    }
}

// ����� ��� ������������ ���������
public class Printer {
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        // ��������� ���������
        directory.addStudent("Alice", 90);
        directory.addStudent("Bob", 85);
        directory.addStudent("Alice", 95);

        // �� ��������
        System.out.println("Before removal:");
        System.out.println(directory.findStudent("Alice"));  // [90, 95]
        System.out.println(directory.getAllStudents());      // {Bob=[85], Alice=[90, 95]}

        // ������� ��������
        directory.removeStudent("Alice");

        // ����� ��������
        System.out.println("After removal:");
        System.out.println(directory.findStudent("Alice"));  // []
        System.out.println(directory.getAllStudents());      // {Bob=[85]}
    }
}




������ 2. ������� ��������� ���-������

import java.util.Deque;
import java.util.LinkedList;

class BrowserHistory {
    // ������������� ������� ��� �������� ������� ���������
    private Deque<String> history = new LinkedList<>();

    // ��������� ���� � ������� ���������
    public void visitSite(String site) {
        // ��������� ���� � ������ �������
        history.addFirst(site);
    }

    // ���������� �������� �����, ������� ��� ������� steps �����
    public String back(int steps) {
        // ���� ����� ������, ��� �������� � �������, ���������� null
        return history.stream()
                      .skip(steps)
                      .findFirst()
                      .orElse(null);
    }

    // ���������� ������ ������ � ������� ���������
    public Deque<String> getHistory() {
        // ���������� ���� �������, ��� ��� ��� ��� ������������� �� ���������� � �������
        return history;
    }
}

// ����� ��� ������������ ���������
public class Printer {
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();

        // �������� �����
        browserHistory.visitSite("google.com");
        browserHistory.visitSite("stackoverflow.com");
        browserHistory.visitSite("github.com");

        // ������������ �� 1 ��� �����
        System.out.println(browserHistory.back(1));  // stackoverflow.com

        // �������� ��� ������� ���������
        System.out.println(browserHistory.getHistory());  // [github.com, stackoverflow.com, google.com]
    }
}




������ 3. ������� ��������� � �������

import java.util.HashMap;

class ShoppingBasket {
    // HashMap ��� �������� ��������� � �� ����������
    private HashMap<String, Integer> basket = new HashMap<>();

    // ��������� ������� � ��������� ����������� � �������
    public void addProduct(String product, Integer quantity) {
        // ���� ������� ��� ����, ����������� ����������
        basket.put(product, basket.getOrDefault(product, 0) + quantity);
    }

    // ������� ������� �� �������
    public void removeProduct(String product) {
        // ������� �������, ���� �� ���� � �������
        basket.remove(product);
    }

    // ��������� ���������� �������� � �������
    public void updateQuantity(String product, Integer quantity) {
        // ��������� ���������� ������ ���� ������� ���� � �������
        if (basket.containsKey(product)) {
            basket.put(product, quantity);
        }
    }

    // ���������, ���� �� ������� � ������� � ���������� ��� ����������
    public int checkProduct(String product) {
        // ���������� ���������� �������� ��� 0, ���� ��� ���
        return basket.getOrDefault(product, 0);
    }

    // ������� ��� �������� � �� ���������� � �������
    public void showBasket() {
        // �������� �� ���� ������� � ������� ��
        for (HashMap.Entry<String, Integer> entry : basket.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

// ����� ��� ������������ ���������
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
        
        // ��������� �������� � �������
        basket.addProduct(product1, quantity1);
        basket.addProduct(product2, quantity2);
        basket.addProduct(product3, quantity3);

        System.out.println("Basket after adding products:");
        basket.showBasket();  // ������� ���������� �������
        
        // ������� ������� "banana"
        basket.removeProduct("banana");
        System.out.println("Basket after removing 'banana':");
        basket.showBasket();  // ������� ���������� ������� ����� ��������

        // ��������� ���������� �������� "apple"
        basket.updateQuantity("apple", 10);
        System.out.println("Basket after updating quantity of 'apple':");
        basket.showBasket();  // ������� ������� ����� ����������

        // ��������� ���������� ���������
        System.out.println("Quantity of 'apple': " + basket.checkProduct("apple"));  // 10
        System.out.println("Quantity of 'banana': " + basket.checkProduct("banana"));  // 0
    }
}




������ 4. ���������� ��������

import java.util.Arrays;

class MergeSort {
    // ����� ��� ����������� ���� ��������������� ��������
    public static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        // ���������� ��� �������, ��������� �� ��������
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // �������� ���������� �������� �� ������ �������, ���� ����
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // �������� ���������� �������� �� ������� �������, ���� ����
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // ����� ���������� ��������
    public static void mergeSort(int[] array) {
        // ������� ������ ��������: ���� ������ ������� �� ������ ��������, �� ��� ������������
        if (array.length < 2) {
            return;
        }

        // ��������� ������ �� ��� �����
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // ���������� ��������� ������ ��������
        mergeSort(left);
        mergeSort(right);

        // ���������� ��������������� ��������
        merge(left, right, array);
    }
}

// ����� ��� ������������ ���������
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

        // ���������� �������
        MergeSort.mergeSort(initArray);

        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
