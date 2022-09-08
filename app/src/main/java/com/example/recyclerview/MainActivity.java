package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ZOnItemClickListener {
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    //RecyclerView recyclerView = findViewById(R.id.recyclerView);

    User user1 = new User("zcaffey","zac@gmail.com", "1334 FM", 325220112);
    User user2 = new User("jlove","jlove@gmail.com", "1335 FM", 325221116);
    User user3 = new User("hbrown","hbrown@gmail.com", "1336 FM", 325222117);
    User user4 = new User("cpotter","cpotter@gmail.com", "1337 FM", 325223118);

    private ArrayList userList = new ArrayList<User>(Arrays.asList(user1, user2, user3, user4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mAdapter = new Adapter(this, userList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setClickListener(this);

        //int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
       // mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    @Override
    public void zonClick(View view, int position) {
       /* if (position == 0) {
            Toast.makeText(this, "zcaffey\nzac@gmail.com\n1334 FM\n325220112", Toast.LENGTH_SHORT).show();
        } else if (position == 1) {
            Toast.makeText(this, "jlove\njlove@gmail.com\n1335 FM\n325220116", Toast.LENGTH_SHORT).show();
        } else if (position == 2) {
            Toast.makeText(this, "hbrown\nhbrown@gmail.com\n1336 FM\n325220117", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "cpotter\ncpotter@gmail.com\n1337 FM\n325220118", Toast.LENGTH_SHORT).show();
        }*/

    }


    public void phoneCall(View view) {
        Intent phoneCall = new Intent(Intent.ACTION_VIEW);
        phoneCall.setData(Uri.parse("tel:"));
        startActivity(phoneCall);
    }

    public void textMessage(View view) {
        Intent textMsg = new Intent(Intent.ACTION_VIEW);
        textMsg.setData(Uri.parse("sms:"));
        startActivity(textMsg);
    }
}