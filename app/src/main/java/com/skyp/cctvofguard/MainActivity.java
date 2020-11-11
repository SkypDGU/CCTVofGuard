package com.skyp.cctvofguard;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*Tool bar 관련 컴포넌트*/
    private Toolbar toolbar;
    private ActionBar actionBar;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MainAdapter mainAdapter;
    private ArrayList<String> temporaryArr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Tool bar 연결*/
        toolbar = findViewById(R.id.main_Toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        temporaryArr = new ArrayList<>();
        setList();

        recyclerView = findViewById(R.id.main_RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        mainAdapter = new MainAdapter(temporaryArr);
        recyclerView.setAdapter(mainAdapter);

    }

    public void setList(){
        temporaryArr.add("CCTV1");
        temporaryArr.add("CCTV2");
        temporaryArr.add("CCTV3");
    }
}
