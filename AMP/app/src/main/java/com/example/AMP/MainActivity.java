package com.example.AMP;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.AMP.Activity.ReadActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new FruitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ReadActivity.class);
                startActivity(intent);
                //Toast.makeText(view.getContext(),"you delete "+fruitList.get(position),Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnItemLongClickListener(new FruitAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                //fruitList.remove(position);
                //adapter.removeData(position);
            }
        });


//        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(this, recyclerView, new RecyclerViewClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                Toast.makeText(view.getContext(),"you clicked view "+fruitList.get(position),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//                fruitList.remove(position);
//            }
//        }));



//        try {
//            SwitchCompat aSwitch = (SwitchCompat) findViewById(R.id.switch1);
//            layout=(ConstraintLayout) findViewById(R.id.layout);
//
//            if (aSwitch !=null&&layout!=null)
////                aSwitch.setOnCheckedChangeListener((buttonView, isChecked) ->{
////                        layout.setBackgroundColor(isChecked ? Color.DKGRAY : Color.WHITE);
//                aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                    @Override
//                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                        if (isChecked){
//                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                        }else {
//                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                        }
//                    }
//                });
//        }
//        catch (Exception e){
//            Log.d(TAG, "someOtherMethod()", e);
//        }

    }

    private void initFruits() {
        for (int i = 1; i < 2; i++) {
            Fruit apple = new Fruit("   斗破苍穹", R.mipmap.re1, "   第一千一百章","   2010.10.03 10：00：00");
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.mipmap.re2,"haha","13");
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.mipmap.re3,"haha","13");
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.mipmap.re4,"haha","13");
            fruitList.add(watermelon);
//            Fruit pear = new Fruit("Pear", R.drawable.ic_launcher_background);
//            fruitList.add(pear);
//            Fruit grape = new Fruit("Grape", R.drawable.ic_launcher_background);
//            fruitList.add(grape);
//            Fruit pineapple = new Fruit("Pineapple", R.drawable.ic_launcher_background);
//            fruitList.add(pineapple);
//            Fruit strawberry = new Fruit("Strawberry", R.drawable.ic_launcher_background);
//            fruitList.add(strawberry);
//            Fruit cherry = new Fruit("Cherry", R.drawable.ic_launcher_background);
//            fruitList.add(cherry);
//            Fruit mango = new Fruit("Mango", R.drawable.ic_launcher_background);
//            fruitList.add(mango);

        }
    }
}