package com.example.lcardenas.recycleview_cardview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lcardenas on 17/03/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<String> nombres;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapter(List<String> nombres, int layout, OnItemClickListener listener){
        this.nombres =  nombres;
        this.layout = layout;
        this.itemClickListener = listener;
        
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(nombres.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return nombres.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textviewnombre;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textviewnombre = (TextView) itemView.findViewById(R.id.textViewLista);
        }

        public void bind (final String nombre, final OnItemClickListener listener){
            this.textviewnombre.setText(nombre);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(nombre, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String nombre, int position);
    }
}
