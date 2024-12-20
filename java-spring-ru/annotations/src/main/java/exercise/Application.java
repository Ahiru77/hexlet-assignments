package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        // Итерируем все методы класса
        for (Method method : Address.class.getDeclaredMethods()) {

        // Проверяем, есть ли у метода аннотация @LogExecutionTime
            if (method.isAnnotationPresent(Inspect.class)) {
                var name = method.getName();
				var type = getFileExtension(method.getReturnType().toString());
                System.out.println("Method " +  name + " returns a value of type " + type +".");
				}
			}
        // END
    }
	
	public static String getFileExtension(String type) {
		if (type == null) {
			return null;
		}
		int dotIndex = type.lastIndexOf(".");
		if (dotIndex >= 0) {
			return type.substring(dotIndex + 1);
		}
		return type;
	}
}
