package ru.virgusman.springcourse.ClietsWithContacts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.List;
@Getter
@Schema(description = "Список всех клиентов")
public class ClientResponse {

    private List<ClientDTO> clients;

    public ClientResponse(List<ClientDTO> clients) {
        this.clients = clients;
    }
}
