package br.com.sistemarj.rjsistema.persistencia;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true) // Aplica automaticamente em todos os campos LocalDate do projeto
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public String convertToDatabaseColumn(LocalDate locDate) {
        // Quando for salvar o LocalDate no banco, transforma em String "dd/MM/yyyy"
        return (locDate == null ? null : locDate.format(formatter));
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        // Quando puxar a String antiga "dd/MM/yyyy" do banco, converte de volta em LocalDate limpo
        if (dbData == null || dbData.trim().isEmpty()) {
            return null;
        }
        try {
            // Suporta o formato brasileiro salvo no seu banco de dados
            return LocalDate.parse(dbData.trim(), formatter);
        } catch (Exception e) {
            // Fallback caso existam datas gravadas no formato ISO (AAAA-MM-DD)
            return LocalDate.parse(dbData.trim());
        }
    }
}

