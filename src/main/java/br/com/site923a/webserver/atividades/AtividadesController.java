package br.com.site923a.webserver.atividades;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.rmi.activation.UnknownObjectException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.site923a.webserver.ConversorStringParaJson;

@CrossOrigin(origins = {"http://localhost:8080", "https://desenv-sistemas-923a.vercel.app/"}, maxAge = 3600)
@RestController
public class AtividadesController {
    
    @Autowired
    private AtividadesRepository repos;

    @GetMapping("/atividades")
    public List<Atividade> obterAtividades() {
        return repos.findAll();
    }

    @PostMapping("/atividades")
    public ResponseEntity<Atividade> salvarAtividade(@RequestBody String requestBody) throws Exception {
        Map<String, String> json = ConversorStringParaJson.toJson(requestBody);

        ConversorJsonParaAtividade conversorAtividade = new ConversorJsonParaAtividade(json);
        Atividade atividade = conversorAtividade.converter();
        
        Atividade created = repos.save(atividade);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(created);
    } 

    @DeleteMapping("/removerAtividade")
    public ResponseEntity<Atividade> removerAtividade(@RequestBody String id) throws Exception {
        Map<String, String> json = ConversorStringParaJson.toJson(id);

        Optional<Atividade> atividadeParaRemover = repos.findById(json.get("id"));
        if (!atividadeParaRemover.isPresent()) {
            throw new UnknownObjectException("Atividade com id " + json.get("id") + " não existe");
        }
        repos.delete(atividadeParaRemover.get());
        return ResponseEntity.ok(atividadeParaRemover.get());
    }
    

}
