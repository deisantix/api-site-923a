package br.com.site923a.webserver.atividades;

import java.net.MalformedURLException;
import java.net.URL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ConversorJsonParaAtividade {
    
    private Map<String, String> json;

    public ConversorJsonParaAtividade(Map<String, String> json) {
        this.json = json;
    }

    public Atividade converter() throws Exception {
        checarPorParametrosObrigatorios();
        
        LocalDateTime dataEntrega = formatarData();
        
        URL linkClassroom = null;
        if (json.containsKey("linkClassroom")) {
            linkClassroom = validarLinkClassroom();
        }

        Atividade atividade = new Atividade(
            json.get("materia"), 
            json.get("titulo"), 
            json.get("descricao"),
            dataEntrega, 
            linkClassroom,
            json.get("cor")
        );
        return atividade;
    }

    private void checarPorParametrosObrigatorios() throws Exception {
        List<String> parametrosObrigatorio = 
            Arrays.asList("materia", "titulo", "descricao", "dataEntrega", "cor");
        for (String p : parametrosObrigatorio) {
            if (!json.containsKey(p)) {
                throw new Exception("Falta parâmetro: " + p);
            }
        }
    }

    private LocalDateTime formatarData() throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            return LocalDateTime.parse(
                json.get("dataEntrega"),
                formatter
            );

        } catch (DateTimeParseException p) {
            throw new Exception("Se assegure de passar a data no formato dia-mês-ano hora:minuto");
        }
    }

    private URL validarLinkClassroom() throws Exception {
        try {
            return new URL(json.get("linkClassroom"));
        } catch (MalformedURLException m) {
            throw new Exception("URL inválida");
        }
    }

}
