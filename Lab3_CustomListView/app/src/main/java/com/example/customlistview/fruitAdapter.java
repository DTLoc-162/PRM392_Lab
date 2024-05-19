package com.example.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class fruitAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<fruit> fruitList;

    public fruitAdapter(Context context, int layout, List<fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }



    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(layout, null);

        TextView nameFruit = convertView.findViewById(R.id.nameFruit);
        TextView description = convertView.findViewById(R.id.desFruit);
        ImageView image = convertView.findViewById(R.id.imageFruit);

        fruit fruit = fruitList.get(position);

        nameFruit.setText(fruit.getFruitName());
        description.setText(fruit.getDescription());
        image.setImageResource(fruit.getImage());

        return convertView;
    }
}
