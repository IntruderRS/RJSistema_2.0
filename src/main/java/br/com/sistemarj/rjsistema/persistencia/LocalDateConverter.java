package br.com.sistemarj.rjsistema.persistencia;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, String> {

    private final DateTimeFormatter formatadorBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter formatadorIso = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public String convertToDatabaseColumn(LocalDate locDate) {
        return (locDate == null ? null : locDate.format(formatadorBr));
    }

    @Override
    public LocalDate convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty() || dbData.contains("0000-00-00")) {
            return null;
        }
        
        String dadoLimpo = dbData.trim();
        
        // 1. Tenta ler o formato brasileiro antigo com barras (Ex: 28/06/1977)
        if (dadoLimpo.contains("/")) {
            try {
                return LocalDate.parse(dadoLimpo, formatadorBr);
            } catch (Exception e) {
                System.err.println("Aviso: Falha ao converter data BR: " + dadoLimpo);
            }
        }
        
        // 2. Tenta ler o formato padrão ISO com traços (Ex: 1977-06-28)
        if (dadoLimpo.contains("-")) {
            try {
                return LocalDate.parse(dadoLimpo, formatadorIso);
            } catch (Exception e) {
                try {
                    // Fallback para variações de strings de data ISO
                    return LocalDate.parse(dadoLimpo);
                } catch (Exception ex) {
                    System.err.println("Aviso: Falha ao converter data ISO: " + dadoLimpo);
                }
            }
        }
        
        // Se o dado for inválido ou bizarro, retorna null para não travar o BUILD do PI
        return null; 
    }
}
