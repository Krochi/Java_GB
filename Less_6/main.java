import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Создаем множество ноутбуков
        Set<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop(16, 512, "Windows", "Black"));
        laptops.add(new Laptop(8, 256, "Linux", "Silver"));
        laptops.add(new Laptop(32, 1024, "MacOS", "Gray"));
        laptops.add(new Laptop(8, 512, "Windows", "White"));
        laptops.add(new Laptop(16, 1024, "Linux", "Black"));

        // Запрашиваем фильтры у пользователя
        Map<String, Object> filters = getUserFilters();

        // Отфильтровываем и выводим ноутбуки
        filterAndDisplayLaptops(laptops, filters);
    }

    private static Map<String, Object> getUserFilters() {
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        boolean continueFiltering = true;

        while (continueFiltering) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ\n2 - Объем ЖД\n3 - Операционная система\n4 - Цвет");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем оставшийся переход строки

            switch (choice) {
                case 1:
                    System.out.println("Введите минимальное значение ОЗУ (в GB):");
                    int minRam = scanner.nextInt();
                    filters.put("ram", minRam);
                    break;
                case 2:
                    System.out.println("Введите минимальное значение объема ЖД (в GB):");
                    int minHdd = scanner.nextInt();
                    filters.put("hdd", minHdd);
                    break;
                case 3:
                    System.out.println("Введите операционную систему:");
                    String os = scanner.nextLine();
                    filters.put("os", os);
                    break;
                case 4:
                    System.out.println("Введите цвет:");
                    String color = scanner.nextLine();
                    filters.put("color", color);
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }

            System.out.println("Хотите добавить еще один критерий? (да/нет):");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("да")) {
                continueFiltering = false;
            }
        }
        return filters;
    }

    private static void filterAndDisplayLaptops(Set<Laptop> laptops, Map<String, Object> filters) {
        for (Laptop laptop : laptops) {
            boolean matches = true;

            // Проверяем каждый фильтр
            if (filters.containsKey("ram") && laptop.getRam() < (int) filters.get("ram")) {
                matches = false;
            }
            if (filters.containsKey("hdd") && laptop.getHdd() < (int) filters.get("hdd")) {
                matches = false;
            }
            if (filters.containsKey("os") && !laptop.getOs().equalsIgnoreCase((String) filters.get("os"))) {
                matches = false;
            }
            if (filters.containsKey("color") && !laptop.getColor().equalsIgnoreCase((String) filters.get("color"))) {
                matches = false;
            }

            // Выводим ноутбуки, прошедшие фильтр
            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
