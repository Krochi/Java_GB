class CSVGenerator {
    public static String generateCSV(String[] headers, String[][] data) {
        StringBuilder csv = new StringBuilder();

        // Добавляем заголовки
        csv.append(String.join(",", headers)).append("\n");

        // Добавляем строки данных
        for (String[] row : data) {
            csv.append(String.join(",", row)).append("\n");
        }

        // Убираем последний перевод строки
        return csv.toString().trim();
    }
}

// Класс для проверки результата
public class Printer {
    public static void main(String[] args) {
        String[] headers;
        String[][] data;

        if (args.length == 0) {
            // Параметры по умолчанию
            headers = new String[]{"Name", "Age", "City"};
            data = new String[][] {
                {"John", "30", "New York"},
                {"Alice", "25", "Los Angeles"},
                {"Bob", "35", "Chicago"}
            };
        } else {
            // Преобразование строковых параметров в массивы (можно доработать для args)
            headers = new String[]{}; // пример обработки данных можно дополнить
            data = new String[][]{};
        }

        CSVGenerator ans = new CSVGenerator();
        System.out.println(ans.generateCSV(headers, data));
    }
}
