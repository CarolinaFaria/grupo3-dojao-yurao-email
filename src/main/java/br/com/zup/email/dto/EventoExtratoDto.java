package br.com.zup.email.dto;

import br.com.zup.email.compartilhada.EnumOperacao;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class EventoExtratoDto {
    @NotNull
    private EnumOperacao operacao;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    private LocalDate dataOperacao;
    @NotNull
    private Long clienteId;
    @NotBlank
    private String contaParticipante;

    @Override
    public String toString() {
        String operacao = this.operacao == EnumOperacao.DEPOSITO?
                "credita":"debita";
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        return "Sua operação de valor " + df.format(valor.toString()) + " foi concluída com sucesso.";
    }
}
