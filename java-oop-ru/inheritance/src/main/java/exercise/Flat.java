package exercise;

// BEGIN
class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return area + balconyArea;
    }
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        } else if (getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }
}
// END
