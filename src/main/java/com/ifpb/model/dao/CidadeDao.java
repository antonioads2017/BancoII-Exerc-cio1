package com.ifpb.model.dao;

import com.ifpb.model.domain.Cidade;

import java.util.List;

public interface CidadeDao {

    List<String> buscarNomesDosEstados() throws DataException;
    List<String> buscarNomeDasCidades(String estado) throws DataException;
    Cidade buscarCidade(String cidade, String estado) throws DataException;
    String getViewBox(Cidade city1, Cidade city2) throws DataException;

}
