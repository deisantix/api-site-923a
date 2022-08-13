package br.com.site923a.webserver.atividades;

import java.lang.reflect.MalformedParametersException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "atividades")
public class Atividade {
    
    @Id
    private String id;
    private String materia;
    private String titulo;
    private String descricao;
    private LocalDateTime dataEntrega;
    private URL linkClassroom;
    private String cor;

    public Atividade(String materia, String titulo, String descricao, LocalDateTime dataEntrega, URL linkClassroom, String cor) {
        if (materia.isEmpty() || titulo.isEmpty() || descricao.isEmpty()) {
            throw new MalformedParametersException("Parâmetros não podem ser vazios!");
        }
        
        this.materia = materia.toUpperCase();
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;

        if (linkClassroom != null) {
            this.linkClassroom = linkClassroom;
        }
        this.cor = cor;
    }

    public String getId() {
        return id;
    }

    public String getMateria() {
        return materia;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public URL getLinkClassroom() {
        return linkClassroom;
    }

    public String getCor() {
        return cor;
    }
}
