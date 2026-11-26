package br.com.alura.consulta_fipe.service;

import java.util.List;

public interface Converter {
    <T> T  obterDados(String json, Class<T> classe);

    <T> List<T> obterLista(String json, Class<T> classe);
}
