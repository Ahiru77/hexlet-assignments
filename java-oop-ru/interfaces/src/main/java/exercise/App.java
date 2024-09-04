package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.ArrayList;

// BEGIN
public class App{
    public static List<String> buildApartmentsList(List<Home> apart, int n) {
        if (apart.size() == 0) {
            return new ArrayList<String>();
        }

        ArrayList<Home> copy = new ArrayList<>(apart);
        Collections.sort(copy, (o1, o2) -> Double.compare(o1.getArea(), o2.getArea()));
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0 ; i < n; i++) {
            result.add(copy.get(i).toString());
        }

        return  result;
    }
}

// END
