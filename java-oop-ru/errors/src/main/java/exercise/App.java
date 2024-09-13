package exercise;

// BEGIN
class App {
    public static void printSquare(Circle circ) throws NegativeRadiusException {
        try {
            circ.getSquare();
            System.out.println(String.format("%.0f", circ.getSquare()));
            System.out.println("Вычисление окончено");
        } catch (Exception e) {
            System.out.println("Не удалось посчитать площадь");
            System.out.println("Вычисление окончено");
        }
    }
}
// END
