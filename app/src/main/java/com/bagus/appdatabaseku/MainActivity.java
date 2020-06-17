package com.bagus.appdatabaseku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.bagus.appdatabaseku.adapter.AdapterKu;
import com.bagus.appdatabaseku.databaseku.MyDatabaseKu;
import com.bagus.appdatabaseku.modal.ModalKu;

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
    }
}
