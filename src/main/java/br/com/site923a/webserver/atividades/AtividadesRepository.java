package br.com.site923a.webserver.atividades;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AtividadesRepository extends MongoRepository<Atividade, String> {}
