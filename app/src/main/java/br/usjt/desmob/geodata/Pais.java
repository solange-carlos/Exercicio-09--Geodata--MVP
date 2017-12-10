package br.usjt.desmob.geodata;

import java.io.Serializable;
import java.util.ArrayList;
import java.text.Collator;

/*
 *  Criado por Solange Carlos em 10/12/2017.
 *
 */

public class Pais implements Serializable, Comparable {
    private String nome;
    private String codigo3;
    private String capital;
    private String regiao;
    private String subRegiao;
    private String demonimo;
    private int populacao;
    private int area;
    private String bandeira;
    private double gini;
    private ArrayList<String> idiomas;
    private ArrayList<String> moedas;
    private ArrayList<String> dominios;
    private ArrayList<String> fusos;
    private ArrayList<String> fronteiras;
    private double latitude;
    private double longitude;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(String moedas) {
        this.moedas = moedas;
    }

    public ArrayList<String> getDominios() {
        return dominios;
    }

    public void setDominios(String dominios) {
        this.dominios = dominios;
    }

    public ArrayList<String> getFusos() {
        return fusos;
    }

    public void setFusos(String fusos) {
        this.fusos = fusos;
    }

    public ArrayList<String> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(String fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "\nnome='" + nome + '\'' +
                "\ncodigo3='" + codigo3 + '\'' +
                "\ncapital='" + capital + '\'' +
                "\nregiao='" + regiao + '\'' +
                "\nsubRegiao='" + subRegiao + '\'' +
                "\ndemonimo='" + demonimo + '\'' +
                "\npopulacao=" + populacao +
                "\narea=" + area +
                "\nbandeira='" + bandeira + '\'' +
                "\ngini=" + gini +
                "\nidiomas=" + idiomas +
                "\nmoedas=" + moedas +
                "\ndominios=" + dominios +
                "\nfusos=" + fusos +
                "\nfronteiras=" + fronteiras +
                "\nlatitude=" + latitude +
                "\nlongitude=" + longitude +
                "\n}";
    }

    @Override
    public int compareTo(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return 0;
        } else {

            Pais pais = (Pais) o;
            Collator c = Collator.getInstance();
            c.setStrength(Collator.PRIMARY);
            return c.compare(this.nome, pais.getNome());

        }
    }
}