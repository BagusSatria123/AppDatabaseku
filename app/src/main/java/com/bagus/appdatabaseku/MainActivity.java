package com.bagus.appdatabaseku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bagus.appdatabaseku.adapter.AdapterKu;
import com.bagus.appdatabaseku.databaseku.MyDatabaseKu;
import com.bagus.appdatabaseku.modal.ModalKu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyDatabaseKu dbku;
    AdapterKu adapterKu;
    GridLayoutManager gm;

    List<ModalKu> modalList;
    List<ModalKu> modalListAll;

    EditText name,alamat,pekerjaan;
    Button tambah;
    RecyclerView recycler_view;

    String namaString,alamatString,pekerjaanString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbku = new MyDatabaseKu(this);

        name = findViewById(R.id.name);
        alamat = findViewById(R.id.alamat);
        pekerjaan = findViewById(R.id.pekerjaan);

        tambah = findViewById(R.id.tambah);
        recycler_view = findViewById(R.id.recycler_view);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                namaString = name.getText().toString();
                alamatString = alamat.getText().toString();
                pekerjaanString = pekerjaan.getText().toString();

                dbku.tambahData(new ModalKu(namaString,alamatString,pekerjaanString));
                Toast.makeText(getApplicationContext(),"DATA BERHASIL DI TAMBAH",Toast.LENGTH_LONG).show();

            }
        });

        gm = new GridLayoutManager(this,1);
        recycler_view .setLayoutManager(gm);

        modalListAll = new ArrayList<>();
        modalList = dbku.tampilkanSemuaUser();

        for (ModalKu m : modalList){
            ModalKu listKu = new ModalKu();

            listKu.setName(m.getName());
            listKu.setAlamat(m.getAlamat());
            listKu.setPekerjaan(m.getPekerjaan());

            modalListAll.add(listKu);
        }

        adapterKu = new AdapterKu(this,modalListAll);
        recycler_view.setAdapter(adapterKu);
        adapterKu.notifyDataSetChanged();
    }
}
