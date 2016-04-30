package com.study_jams.kaio.movies;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class MovieBatmanVsSupermanActivity extends AppCompatActivity {

    private String buttonTag;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setTitle("MovieDetail: Batman vs Superman");
        setContentView(R.layout.activity_batman_vs_superman);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean ehFavorito = prefs.getBoolean("favoritoBatmanVsSuperman", false);

        CheckBox chkbox = (CheckBox) findViewById(R.id.favorito__batman_vs_superman_box);
        chkbox.setChecked(ehFavorito);
    }

    public void exibeTrailer(View view) {

        buttonTag = (String) view.getTag();
        Intent videoIntent = null;

        if (buttonTag.equals("trailer_1")) {
            videoIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/watch?v=0WWzgGyAH6Y"));
        } else if (buttonTag.equals("trailer_2")){
            videoIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.youtube.com/watch?v=yViIi3gie2c"));
        }

        startActivity(videoIntent);
    }

    public void setFavorito (View view) {

        Boolean ehFavorito = prefs.getBoolean("favoritoBatmanVsSuperman", false);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.edit().putBoolean("favoritoBatmanVsSuperman", !ehFavorito).commit();
    }

}
