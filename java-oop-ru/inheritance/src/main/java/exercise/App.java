package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App{
    public static List<String> buildApartmentsList(List<Home> prop, int n) {
        List<String> sortedList = prop.stream().sorted(Home::compareTo).limit(n).map(Home::toString).toList();
        return sortedList;
    }
}
// END
