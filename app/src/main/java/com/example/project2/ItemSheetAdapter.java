package com.example.project2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemSheetAdapter extends RecyclerView.Adapter<ItemSheetAdapter.ViewHolder> implements OnSheetItemClickListener{

    ArrayList<ItemSheetList> items = new ArrayList<ItemSheetList>();
    OnSheetItemClickListener listener;

    @NonNull
    @Override
    public ItemSheetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSheetAdapter.ViewHolder holder, int position) {
        ItemSheetList item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(ItemSheetList item) {
        items.add(item);
    }

    public void setItems(ArrayList<ItemSheetList> items) {
        this.items = items;
    }

    public ItemSheetList getItem(int position) {
        return items.get(position);
    }

    @Override
    public void onItemClick(ViewHolder viewHolder, View view, int position) {
        Context context = view.getContext();
        Intent intent = new Intent(context, SheetViewerActivity.class);

        // 선택한 아이템의 데이터를 인텐트에 추가
        ItemSheetList item = items.get(position);
        intent.putExtra("song_name", item.song_name);
        intent.putExtra("singer", item.singer);

        // 새로운 액티비티 시작
        context.startActivity(intent);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView song_name;
        TextView singer;

        public ViewHolder(@NonNull View itemView, final OnSheetItemClickListener listener) {
            super(itemView);

            song_name = itemView.findViewById(R.id.txv_song_name);
            singer    = itemView.findViewById(R.id.txv_singer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, v, position);
                    }
                }
            });
        }

        public void setItem(ItemSheetList item) {
            song_name.setText(item.song_name);
            singer.setText(item.singer);
        }
    }
}