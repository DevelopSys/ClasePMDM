package com.system.develop.t4_coordinator.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.system.develop.t4_coordinator.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHoler> {

    Context c;

    public RecyclerAdapter(Context c) {
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(c).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler viewHoler, int i) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHoler extends RecyclerView.ViewHolder{

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
