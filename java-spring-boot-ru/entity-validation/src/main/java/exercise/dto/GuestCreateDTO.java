package exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Future;

import lombok.Getter;
import lombok.Setter;

// BEGIN
import java.time.LocalDate;
@Setter
@Getter
public class GuestCreateDTO {
	
	@NotBlank
    private String name;

	@Email
    private String email;

    @Pattern(regexp = "^\\+[0-9]{11,13}$",
            message = "Не соответствует формату номера телефона")
    private String phoneNumber;

    @Pattern(regexp = "^[0-9]{4}$",
            message = "Не соответствует формату номера карты")
    private String clubCard;
	
	@Future
    private LocalDate cardValidUntil;
}
// END
