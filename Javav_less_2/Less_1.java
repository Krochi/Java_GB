class URLBuilder {
    public static String buildURL(String baseURL, String params) {
        // Проверка, если параметров нет
        if (params == null || params.isEmpty()) {
            return baseURL;
        }

        // Разделяем строку параметров на отдельные пары "ключ=значение"
        String[] paramPairs = params.split("&");
        StringBuilder fullURL = new StringBuilder(baseURL);

        boolean firstParam = !baseURL.contains("?");
        
        for (String pair : paramPairs) {
            // Разделяем пару на ключ и значение
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2 && !"null".equals(keyValue[1])) {
                if (firstParam) {
                    fullURL.append("?");
                    firstParam = false;
                } else {
                    fullURL.append("&");
                }
                fullURL.append(keyValue[0]).append("=").append(keyValue[1]);
            }
        }

        return fullURL.toString();
    }
}

// Класс для проверки результата
public class Printer {
    public static void main(String[] args) {
        String baseURL;
        String params;

        if (args.length == 0) {
            // Параметры по умолчанию
            baseURL = "https://example.com/search?";
            params = "query=java&sort=desc&filter=null";
        } else {
            baseURL = args[0];
            params = args[1];
        }

        URLBuilder ans = new URLBuilder();
        System.out.println(ans.buildURL(baseURL, params));
    }
}
