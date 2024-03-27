package ru.virgusman.springcourse.ClietsWithContacts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Сущность клиента")
public class ClientDTO {

    @NotEmpty(message = "Имя клиента не должно быть пустым!")
    @Size(min = 3, max = 30, message = "Имя клиента должно содержать от 3 до 30 символов")
    @Schema(description = "Имя клиента")
    private String name;
}
