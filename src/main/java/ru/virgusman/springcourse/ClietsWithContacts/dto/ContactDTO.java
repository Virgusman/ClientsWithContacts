package ru.virgusman.springcourse.ClietsWithContacts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import ru.virgusman.springcourse.ClietsWithContacts.models.ContactType;

@Getter
@Setter
@Schema(description = "Сущность контакта")
public class ContactDTO {

    @Enumerated(EnumType.STRING)
    private ContactType type;

    @NotBlank
    private String value;
}
