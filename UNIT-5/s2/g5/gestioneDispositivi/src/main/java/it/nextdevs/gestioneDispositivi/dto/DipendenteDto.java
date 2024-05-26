package it.nextdevs.gestioneDispositivi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DipendenteDto {
    @NotNull
    @Size(max = 30)
    private String username;
    @NotNull
    @Size(max = 30)
    private String nome;
    @NotNull
    @Size(max = 30)
    private String cognome;
    @NotNull
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
    private String email;

}
