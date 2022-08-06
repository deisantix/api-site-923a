package br.com.site923a.webserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class RetornoErro {
    
    private HttpStatus erro;
    private Map<String, String> mensagem;

    public RetornoErro(HttpStatus erro, String mensagem) {
        this.erro = erro;
        this.mensagem = new HashMap<>();
        this.mensagem.put("mensagem", mensagem);
    }

    public HttpStatus getErro() {
        return erro;
    }

    public Map<String, String> getMensagem() {
        return mensagem;
    }

}
