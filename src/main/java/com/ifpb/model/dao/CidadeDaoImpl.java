package com.ifpb.model.dao;

import com.ifpb.model.databese.ConnectionException;
import com.ifpb.model.databese.ConnectionFactory;
import com.ifpb.model.domain.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDaoImpl implements CidadeDao {

    private Connection connection;

    public CidadeDaoImpl() throws ConnectionException {
        connection = ConnectionFactory.getIsntance().getConnection();
    }

    public List<String> buscarNomesDosEstados() throws DataException {
        List<String> resultado = new ArrayList<String>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT nome FROM estados");
            ResultSet resultSet = statement.executeQuery();
            if(resultSet !=null){
                while(resultSet.next()){
                    resultado.add(resultSet.getString("nome"));
                }
            }
            return resultado;
        } catch (SQLException e) {
            throw new DataException("Fala ao realizar a consulta SQL");
        }
    }

    public List<String> buscarNomeDasCidades(String estado) throws DataException {
        List<String> resultado = new ArrayList<String>();
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT nomecidade FROM estado_cidade WHERE nomeestado ilike ?");
            statement.setString(1, estado);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    resultado.add(resultSet.getString("nomecidade"));
                }
            }
            return resultado;
        } catch (SQLException e) {
            throw new DataException("Fala ao realizar a consulta SQL");
        }

    }

    public Cidade buscarCidade(String cidade, String estado) throws DataException {
        return null;
    }

    public String getViewBox(Cidade city1, Cidade city2) throws DataException {
        return null;
    }
}
