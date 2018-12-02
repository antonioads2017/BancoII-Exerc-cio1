package com.ifpb.model.dao;

import com.ifpb.model.databese.ConnectionException;
import com.ifpb.model.databese.ConnectionFactory;
import com.ifpb.model.domain.Cidade;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDaoImpl implements CidadeDao {

    private Connection connection;
    private WKTReader reader;

    public CidadeDaoImpl() throws ConnectionException {
        connection = ConnectionFactory.getIsntance().getConnection();
        reader = new WKTReader();
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
            throw new DataException("Falha ao realizar a consulta SQL");
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
            throw new DataException("Falha ao realizar a consulta SQL");
        }

    }

    public Cidade buscarCidade(String cidade, String estado) throws DataException {
        try {
            PreparedStatement statement = connection.prepareStatement
                    ("SELECT c.nome, c.populacao_2010 as populacao, ST_AsText(ST_AsEWKT(c.geom)), ST_AsSVG(c.geom) ,c.estado_id " +
                            " FROM estado_cidade ec, city c " +
                            " WHERE ec.codigo_ibge = c.codigo_ibge " +
                            " AND ec.nomeestado ilike ? " +
                            " AND ec.nomecidade ilike ? ");
            statement.setString(1,estado);
            statement.setString(2,cidade);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet != null && resultSet.next()){
                Cidade city = new Cidade();
                city.setNome(resultSet.getString(1));
                city.setPopulacao(resultSet.getInt(2));
                city.setGeom(reader.read(resultSet.getString(3)));
                city.setSvg(resultSet.getString(4));
                city.setIdEstado(resultSet.getInt(5));
                city.setArea((float) city.getGeom().getArea());
                return city;
            }
            return null;
        } catch (SQLException e) {
            throw new DataException("Falha ao realizar a consulta SQL");
        } catch (ParseException e) {
            throw new DataException("Falha ao converter o dado da geometria");
        }
    }

    public String getViewBox(Cidade city1, Cidade city2) throws DataException {
        return null;
    }
}
