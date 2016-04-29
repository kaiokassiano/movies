package com.study_jams.kaio.movies;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MovieWarcraftActivity extends AppCompatActivity {

    private String buttonTag;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("Filme: Warcraft Movie");
        setContentView(R.layout.activity_movie_warcraft);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean ehFavorito = prefs.getBoolean("favoritoWarcraft", false);

        CheckBox chkbox = (CheckBox) findViewById(R.id.favorito_warcraft_box);
        chkbox.setChecked(ehFavorito);
    }

    public void exibeTrailer(View view) {

        buttonTag = (String) view.getTag();
        Intent videoIntent = null;

        if (buttonTag.equals("trailer_1")) {
            videoIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/watch?v=RhFMIRuHAL4"));
        } else if (buttonTag.equals("trailer_2")){
            videoIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/watch?v=-vwPitt1XMQ"));
        }

        startActivity(videoIntent);
    }

    public void setFavorito (View view) {

        Boolean ehFavorito = prefs.getBoolean("favoritoWarcraft", false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("favoritoWarcraft", !ehFavorito).commit();
    }

}
