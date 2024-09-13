package exercise;

import lombok.Value;

// BEGIN
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
// @Setter
// @NoArgsConstructor
@AllArgsConstructor
@Value
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
