package com.bagus.appdatabaseku.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bagus.appdatabaseku.R;
import com.bagus.appdatabaseku.modal.ModalKu;

import java.util.List;

public class AdapterKu extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ModalKu> modalKus;

    public AdapterKu(Context context, List<ModalKu> modalKus) {
        this.context = context;
        this.modalKus = modalKus;
    }

    class MyAdapterKu extends RecyclerView.ViewHolder{

        TextView name,alamat,perkerjaan;

        public MyAdapterKu(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            alamat = itemView.findViewById(R.id.alamat);
            perkerjaan = itemView.findViewById(R.id.pekerjaan);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_adapter,viewGroup,false);

        return new MyAdapterKu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((MyAdapterKu)viewHolder).name.setText(modalKus.get(i).getName());
        ((MyAdapterKu)viewHolder).alamat.setText(modalKus.get(i).getAlamat());
        ((MyAdapterKu)viewHolder).perkerjaan.setText(modalKus.get(i).getPekerjaan());
    }

    @Override
    public int getItemCount() {
        return modalKus.size();
    }
}
