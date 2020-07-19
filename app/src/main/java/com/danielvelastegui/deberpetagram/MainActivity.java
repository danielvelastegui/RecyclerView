package com.danielvelastegui.deberpetagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> misMascotas = new ArrayList<>();
    ArrayList<Mascota> mascotasGustadas = new ArrayList<>();
    MascotasAdapter adaptador;

    private Toolbar materialToolBar;
    private RecyclerView rvMascotas;
    private ImageButton imgFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgFavoritos = findViewById(R.id.imgFavoritos);

        materialToolBar = findViewById(R.id.mainToolBar);
        setSupportActionBar(materialToolBar);

        rvMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        crearMascotas();
        inicializarRV();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void crearMascotas(){
        misMascotas.add(new Mascota(R.drawable.ic_mascota01, "Bruno"));
        misMascotas.add(new Mascota(R.drawable.ic_mascota02, "Jack"));
        misMascotas.add(new Mascota(R.drawable.ic_mascota3, "Paco"));
        misMascotas.add((new Mascota(R.drawable.ic_mascota4, "Hercules")));
    }

    private void inicializarRV(){
        adaptador = new MascotasAdapter(misMascotas, this, mascotasGustadas);
        rvMascotas.setAdapter(adaptador);
    }

    public void abrirFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(intent);
    }
}