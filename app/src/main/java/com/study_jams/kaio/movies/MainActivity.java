package com.study_jams.kaio.movies;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Contato");
        alertDialog.setMessage("Kaio Oliveira\nkaio.kassiano.oliveira@gmail.com\n\nMe dê os parabéns!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "PARABÉNS!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        return menuItem.getItemId() == R.id.sobre;
    }

    public void iniciaTelaInformacoesFilme(View view) {

        movieTag = (String) view.getTag();
        Intent intent = null;

        if (movieTag.equals("warcraft")) {
            intent = new Intent(this, MovieWarcraftActivity.class);

        } else if(movieTag.equals("batman_vs_superman")) {
            intent = new Intent(this, MovieBatmanVsSupermanActivity.class);

        } else if(movieTag.equals("deadpool")) {
            intent = new Intent(this, MovieDeadpoolActivity.class);

        } else if(movieTag.equals("ex_machina")) {
            intent = new Intent(this, MovieExMachinaActivity.class);

        }

        startActivity(intent);
    }

}
