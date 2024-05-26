package it.nextdevs.gestioneDispositivi.dto;

import it.nextdevs.gestioneDispositivi.enums.StatoDispositivo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DispositivoDto {
    @NotNull
    @Size(max = 30)
    private String modello;
    @NotNull
    @Size(max = 30)
    private String tipoDispositivo;
    @NotNull
    private StatoDispositivo statoDispositivo;

    private Integer dipendenteId;
}
