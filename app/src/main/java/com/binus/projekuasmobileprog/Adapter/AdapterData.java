package com.binus.projekuasmobileprog.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.binus.projekuasmobileprog.Model.DataFilm;
import com.binus.projekuasmobileprog.Model.Search;
import com.binus.projekuasmobileprog.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderData> {

    private List<Search> listSearch;
    LayoutInflater inflater;
    private Context context;

    public AdapterData(Context context, List<Search> listSearch) {
        this.listSearch = listSearch;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterData.HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_data_film, parent, false);

        AdapterData.HolderData holderData = new AdapterData.HolderData(view);
        return holderData;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderData holder, int position) {

        holder.titleFilm.setText(listSearch.get(position).getTitle());

        // Glide
        Glide.with(context)
                .load(listSearch.get(position).getPoster())
                .into(holder.imageFilm);
    }

    @Override
    public int getItemCount() {

        return listSearch.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {

        TextView titleFilm;
        ImageView imageFilm;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            titleFilm = itemView.findViewById(R.id.titleFilm);
            imageFilm = itemView.findViewById(R.id.imgFilm);
        }
    }
}
