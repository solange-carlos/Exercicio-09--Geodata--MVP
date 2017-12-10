package br.usjt.desmob.geodata;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.TreeSet;

/*
 *  Criado por Solange Carlos em 10/12/2017.
 *
 */

public class SectionIndexBuilder {

    public static Object[] buildSectionHeaders(Pais[] paises){
        ArrayList<String> resultado = new ArrayList<>();
        TreeSet<String> usados = new TreeSet<>();
        for(Pais pais:paises){
            String letra = pais.getNome().substring(0,1);
            if((!usados.contains(letra))){
                resultado.add(letra);
            }
            usados.add(letra);
        }
        return resultado.toArray(new Object[0]);
    }

    public static Hashtable<Integer, Integer> buildSectionForPositionMap(Pais[] paises){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();
        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < paises.length; i++){
            String letra = paises[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
            }
            resultados.put(i, secao);
        }
        return resultados;
    }


    public static Hashtable<Integer, Integer> buildPositionForSectionMap(Pais[] paises){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();
        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < paises.length; i++){
            String letra = paises[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
                resultados.put(secao, i);
            }
        }
        return resultados;
    }
}