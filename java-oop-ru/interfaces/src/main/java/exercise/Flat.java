package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public String toString() {
        var areaTotal = area + balconyArea;
        return "Квартира площадью " + areaTotal + " метров на " + floor + " этаже";
    }
    @Override
    public double getArea() {
        return area + balconyArea;
    }
    @Override
    public int compareTo(Home another) {
        if (area > another.getArea()) {
            return 1;
        } else if (area == another.getArea()) {
            return 0;
        }
        return -1;
    }

}
// END
