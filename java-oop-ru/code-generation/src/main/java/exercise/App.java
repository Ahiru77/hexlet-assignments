package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
class App {
    public static void save(Path path, Car car) throws Exception {
        var file = car.serialize();
        Files.writeString(path, file);
    }
    public static Car extract(Path path) throws Exception {
        String content = Files.readString(path);
        Car car = Car.deserialize(content);
        return car;
    }
}
// END
