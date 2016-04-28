package com.study_jams.kaio.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String movieTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return menuItem.getItemId() == R.id.sobre;
    }

    public void iniciaTelaInformacoesFilme(View view) {

        movieTag = (String) view.getTag();
        Intent intent = null;

        if (movieTag.equals("warcraft")) {
            intent = new Intent(this, MovieWarcraft.class);

        } else if(movieTag.equals("batman_vs_superman")) {
            intent = new Intent(this, MovieBatmanVsSuperman.class);

        } else if(movieTag.equals("deadpool")) {
            intent = new Intent(this, MovieDeadpool.class);

        } else if(movieTag.equals("ex_machina")) {
            intent = new Intent(this, MovieExMachina.class);

        }

        startActivity(intent);
    }

    public void iniciaTelaMenuSobre(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

}
