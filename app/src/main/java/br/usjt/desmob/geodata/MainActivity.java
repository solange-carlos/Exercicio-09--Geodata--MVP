package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

/*
 *  Criado por Solange Carlos em 10/12/2017.
 *
 */

public class MainActivity extends Activity {
    Spinner spinnerContinente;
    String continente = "all";
    public static final String URL = "https://restcountries.eu/rest/v2/";
    public static final String PAISES = "br.usjt.desmob.geodata.paises";
    Pais[] paises;
    Intent intent;
    ProgressBar timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerContinente = (Spinner) findViewById(R.id.spinnerContinente);
        spinnerContinente.setOnItemSelectedListener(new RegiaoSelecionada());
        timer = (ProgressBar)findViewById(R.id.timer);
        timer.setVisibility(View.INVISIBLE);
    }

    public void listarPaises(View view) {
        intent = new Intent(this, ListaPaisesActivity.class);
        if(GeoDataNetwork.isConnected(this)) {
            timer.setVisibility(View.VISIBLE);
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                paises = GeoDataNetwork.buscarPaises(URL, continente);
                                runOnUiThread(new Runnable() {
                                                  @Override
                                                  public void run() {
                                                      intent.putExtra(PAISES, paises);
                                                      startActivity(intent);
                                                      timer.setVisibility(View.INVISIBLE);
                                                  }
                                              }
                                );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
        } else {
            Toast.makeText(this, "Rede inativa.", Toast.LENGTH_SHORT).show();
        }
    }

    private class RegiaoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
            if (continente.equals("Todos")) {
                continente = "all";
            } else {
                continente = "region/"+continente.toLowerCase();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}