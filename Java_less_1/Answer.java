class Answer {
    // Функция для нахождения максимума из двух чисел
    public int findMaxOfTwo(int a, int b) {
        return (a > b) ? a : b;
    }

    // Функция для нахождения максимума из трех чисел
    public int findMaxOfThree(int a, int b, int c) {
        int maxOfTwo = findMaxOfTwo(a, b);
        return findMaxOfTwo(maxOfTwo, c);
    }
}
