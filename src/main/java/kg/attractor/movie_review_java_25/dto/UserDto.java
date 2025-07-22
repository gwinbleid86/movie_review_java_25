package kg.attractor.movie_review_java_25.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank
    @Email
    private String username;

    @NotBlank
    @Size(min = 3, max = 24, message = "Length must be >= 4 and <= 24")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-z]).+$"
            , message = "Should contain at least one uppercase letter, one number")
    private String password;
}
