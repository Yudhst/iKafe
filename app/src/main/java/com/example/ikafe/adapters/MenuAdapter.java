package com.example.ikafe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ikafe.R;
import com.example.ikafe.models.Menu;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private ArrayList<Menu> listMenu;

    public MenuAdapter(ArrayList<Menu> listMenu) {
        this.listMenu = listMenu;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, int position) {
        holder.tvKode.setText(listMenu.get(position).getKode());
        holder.tvJenis.setText(listMenu.get(position).getJenis());
        holder.tvNama.setText(listMenu.get(position).getNama());
        holder.tvKeterangan.setText(listMenu.get(position).getKeterangan());
        holder.tvHarga.setText(listMenu.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return (listMenu != null) ? listMenu.size() : 0;
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        private TextView tvKode, tvJenis, tvNama, tvKeterangan, tvHarga;

        public MenuViewHolder(View itemView) {
            super(itemView);
            tvKode = itemView.findViewById(R.id.tvKode);
            tvJenis = itemView.findViewById(R.id.tvJenis);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvKeterangan = itemView.findViewById(R.id.tvKeterangan);
            tvHarga = itemView.findViewById(R.id.tvHarga);
        }
    }
}
