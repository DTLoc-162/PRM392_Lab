package com.example.lab9_sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Todo> todoList;

    public TodoAdapter(Context context, int layout, List<Todo> todoList) {
        this.context = context;
        this.layout = layout;
        this.todoList = todoList;
    }


    private static class ViewHolder {
        TextView todoName;
        ImageView editImg, deleteImg;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return todoList.get(position).getTodoId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.todoName = view.findViewById(R.id.todoName);
            holder.editImg = view.findViewById(R.id.editImg);
            holder.deleteImg = view.findViewById(R.id.deleteImg);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Todo todo = todoList.get(position);
        holder.todoName.setText(todo.getTodoName());

        holder.deleteImg.setOnClickListener(v -> {
            if (context instanceof MainActivity) {
                ((MainActivity) context).dialogRemoveTodo(todo);
            }
        });

        holder.editImg.setOnClickListener(v -> {
            if (context instanceof MainActivity) {
                ((MainActivity) context).dialogUpdateTodo(todo);
            }
        });

        return view;
    }
}