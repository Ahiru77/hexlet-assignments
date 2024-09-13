package exercise;
import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Field;
// BEGIN
class Validator {
    public static List<String> validate(Address add) {
        ArrayList<String> list = new ArrayList<String>();
        Field[] fields = add.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object obj = field.get(add);
                if (field.isAnnotationPresent(NotNull.class) && obj == null) {
                    list.add(field.getName());
                }
            } catch(Exception e){
            e.printStackTrace();
        }
    }
        return list;
    }
}
// END
