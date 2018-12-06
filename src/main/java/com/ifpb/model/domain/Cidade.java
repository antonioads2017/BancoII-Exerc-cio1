package com.ifpb.model.domain;

import com.vividsolutions.jts.geom.Geometry;

public class Cidade {

    private String nome;
    private Integer idEstado;
    private Integer populacao;
    private float area;
    private Geometry geom;
    private String svg;

    public Cidade() {

    }

    public Cidade(String nome, Integer idEstado, Integer populacao, float area, Geometry geom, String svg) {
        this.nome = nome;
        this.idEstado = idEstado;
        this.populacao = populacao;
        this.area = area;
        this.geom = geom;
        this.svg = svg;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
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

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public float getArea() {
        return (area*40075/360)*100;
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

    public float getPerimetro(){
        return (float) geom.getLength()*100;
    }

    public int getDencidade(){
        return populacao/(int)getArea();
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", idEstado=" + idEstado +
                ", populacao=" + populacao +
                ", area=" + area +
                ", geom=" + geom +
                '}';
    }
}
