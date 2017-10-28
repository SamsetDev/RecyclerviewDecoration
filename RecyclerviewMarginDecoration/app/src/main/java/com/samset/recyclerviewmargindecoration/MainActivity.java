package com.samset.recyclerviewmargindecoration;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.samset.recyclerviewmargindecoration.decoration.ColorFullDecoration;
import com.samset.recyclerviewmargindecoration.decoration.MarginDecoration;
import com.samset.recyclerviewmargindecoration.decoration.VerticalDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                RadioButton r = (RadioButton) radioGroup.getChildAt(index);
                if (r.getText().toString().equalsIgnoreCase("Simple")) {
                    recyclerView.addItemDecoration(new MarginDecoration(MainActivity.this));
                } else if (r.getText().toString().equalsIgnoreCase("Vertical")) {
                    recyclerView.addItemDecoration(new VerticalDecoration(MainActivity.this));
                } else if (r.getText().toString().equalsIgnoreCase("With Border")) {
                    recyclerView.addItemDecoration(new ColorFullDecoration());
                }

            }
        });


        setRecyclerView();

    }

    private void setRecyclerView() {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DecorateAdapter(getList()));
    }

    private List<String> getList() {
        List<String> lists = new ArrayList<String>();
        for (int i = 0; i < 50; ++i) {
            lists.add("Item " + String.valueOf(i));
        }
        return lists;
    }

    private void initView() {
        radioGroup = findViewById(R.id.rg);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
    }
}
