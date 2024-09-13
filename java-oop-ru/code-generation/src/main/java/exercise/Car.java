package exercise;

import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;

// BEGIN
import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
import lombok.Getter;
// import lombok.Setter;

@Getter
// @Setter
// @NoArgsConstructor
@AllArgsConstructor
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;
    
    // BEGIN
    public String serialize() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public static Car deserialize(String str) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Car obj = mapper.readValue(str, Car.class);
        return obj;
    }
    // END
}
