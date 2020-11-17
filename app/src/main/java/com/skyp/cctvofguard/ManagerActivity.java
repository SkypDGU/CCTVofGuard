package com.skyp.cctvofguard;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {

    /*Tool bar 관련 컴포넌트*/
    private Toolbar toolbar;
    private ActionBar actionBar;

    /*RecyclerView 관련 컴포넌트*/
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ManagerAdapter managerAdapter;
    private ArrayList<cctvData> temporaryArr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        /*Tool bar 연결*/
        toolbar = findViewById(R.id.manager_Toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        /*RecyclerView 연결*/
        temporaryArr = new ArrayList<>();
        setList();

        recyclerView = findViewById(R.id.manager_RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        managerAdapter = new ManagerAdapter(temporaryArr);
        recyclerView.setAdapter(managerAdapter);
    }

    public void setList(){
        cctvData cctv1 = new cctvData("CCTV1", "this is CCTV1");
        cctvData cctv2 = new cctvData("CCTV2", "this is CCTV2");
        cctvData cctv3 = new cctvData("CCTV3", "this is CCTV3");
        temporaryArr.add(cctv1);
        temporaryArr.add(cctv2);
        temporaryArr.add(cctv3);
    }
}
