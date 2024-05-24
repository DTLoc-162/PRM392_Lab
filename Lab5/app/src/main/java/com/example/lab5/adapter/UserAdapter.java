package com.example.lab5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.R;
import com.example.lab5.User;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private ArrayList<User> userList;

    public UserAdapter(ArrayList<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.row_userlist, parent, false);
        return new ViewHolder(view); // Use the defined ViewHolder class
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        // Bind data to the views in the ViewHolder here
        User user = userList.get(position);
        // Set user data to holder views (e.g., holder.nameTextView.setText(user.getName()))
        holder.tvUsername.setText("Username:" + user.getUsername());
        holder.tvFullname.setText("Fullname:" + user.getFullname());
        holder.tvEmail.setText("Email:" + user.getEmail());
        holder.avt.setImageResource(user.getImg());
    }

    @Override
    public int getItemCount() {
        return userList.size(); // Set the item count based on the user list size
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Define your view member variables here (e.g., TextView nameTextView, ImageView profileImage)
        TextView tvUsername, tvFullname, tvEmail;

        ImageView avt;

        public ViewHolder(View itemView) {
            super(itemView);
            // Initialize your view member variables using findViewById (e.g., nameTextView = itemView.findViewById(R.id.nameTextView))
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvFullname = itemView.findViewById(R.id.tv_fullname);
            tvEmail = itemView.findViewById(R.id.tv_email);
            avt =itemView.findViewById(R.id.avt);
        }
    }
}

