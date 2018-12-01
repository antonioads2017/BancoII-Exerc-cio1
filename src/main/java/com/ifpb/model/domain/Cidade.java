package com.ifpb.model.domain;

import com.vividsolutions.jts.geom.Geometry;

public class Cidade {

    private String nome;
    private Integer idEstado;
    private Integer população;
    private float area;
    private Geometry geom;

    public Cidade(){

    }

    public Cidade(String nome, Integer idEstado, Integer população, float area, Geometry geom) {
        this.nome = nome;
        this.idEstado = idEstado;
        this.população = população;
        this.area = area;
        this.geom = geom;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getPopulação() {
        return população;
    }

    public void setPopulação(Integer população) {
        this.população = população;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Geometry getGeom() {
        return geom;
    }

    public void setGeom(Geometry geom) {
        this.geom = geom;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", idEstado=" + idEstado +
                ", população=" + população +
                ", area=" + area +
                ", geom=" + geom +
                '}';
    }
}
