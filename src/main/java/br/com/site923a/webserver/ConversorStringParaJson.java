package br.com.site923a.webserver;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorStringParaJson {
    public static Map<String, String> toJson(String string) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> json = mapper.readValue(
            string,
            new TypeReference<Map<String, String>>() {}
        );
        return json;
    }
}
