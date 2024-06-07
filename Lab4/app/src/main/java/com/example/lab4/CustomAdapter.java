package com.example.lab4;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Item> itemList;

    public CustomAdapter(Context context, int layout, List<Item> itemList){
        this.context = context;
        this.layout = layout;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.name =view.findViewById(R.id.nameFruit);
            holder.description = view.findViewById(R.id.desFruit);
            holder.image = view.findViewById(R.id.imageFruit);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
            Item currentItem = itemList.get(i);

            holder.name.setText(currentItem.getName());
            holder.description.setText(currentItem.getDescription());
            holder.image.setImageResource(currentItem.getImage());

        return view;
    }

    private static class ViewHolder {
        TextView name;
        TextView description;
        ImageView image;
    }
}