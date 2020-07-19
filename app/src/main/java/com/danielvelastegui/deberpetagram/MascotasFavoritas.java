package com.danielvelastegui.deberpetagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.HashSet;

public class MascotasFavoritas extends AppCompatActivity {
    private Toolbar favoriteToolBar;
    private RecyclerView rvMascotasFavoritas;

    ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();
    MascotasFavoritasAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        favoriteToolBar = findViewById(R.id.favoriteToolBar);
        rvMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);
        setSupportActionBar(favoriteToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(MascotasFavoritas.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFavoritas.setLayoutManager(llm);
        mascotasFavoritas.add(new Mascota(R.drawable.ic_mascota01, "Bruno"));
        inicializarRVFavoritas();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public void inicializarRVFavoritas(){
        adaptador = new MascotasFavoritasAdapter(mascotasFavoritas);
        rvMascotasFavoritas.setAdapter(adaptador);
    }
}