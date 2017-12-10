package br.usjt.desmob.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/*
 *  Criado por Solange Carlos em 10/12/2017.
 *
 */

public class ListaPaisesActivity extends Activity {
    public static final String PAIS = "br.usjt.desmob.geodata.pais";
    Activity atividade;
    Pais[] paises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();

        paises = (Pais[]) intent.getSerializableExtra(MainActivity.PAISES);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        PaisAdapter adapter = new PaisAdapter(paises, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                Intent intent = new Intent(atividade, DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises[position]);

                startActivity(intent);

            }

        });
    }
}