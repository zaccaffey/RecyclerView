package com.example.recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.WordViewHolder> {
    private final ArrayList<User> userList;
    private LayoutInflater inflater;
    private ZOnItemClickListener clickListener;

    public Adapter(Context context, ArrayList<User> userList) {
        inflater = LayoutInflater.from(context);
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recycler_row, parent, false);
        return new WordViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        User current = userList.get(position);
        holder.firstText.setText(current.getUsername());
        String number = String.valueOf(current.getPhoneNum());
        holder.secondText.setText(number);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setClickListener(ZOnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener; //wiring
    }

    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener { //user is clicking z switches

        public final TextView firstText;
        public final TextView secondText;
        final Adapter mAdapter;

        public WordViewHolder(@NonNull View itemView, Adapter adapter) {
            super(itemView);
            firstText = itemView.findViewById(R.id.textView1);
            secondText = itemView.findViewById(R.id.textView2);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                //clickListener.zonClick(view, getAdapterPosition());
                User user = userList.get(getAdapterPosition());
                //Toast.makeText(itemView.getContext(), "adapter"+user.getEmail(), Toast.LENGTH_SHORT).show();
                showDialog(user);
            }
        }

        private void showDialog(User user) {
            AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
            builder.setMessage("username: " + user.getUsername() + "\n" + "email: " + user.getEmail() + "\n" + "phone number: " + user.getPhoneNum() + "\n" + "address: " + user.getPostAddress());
            builder.setTitle("Information for " + user.getUsername());
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
