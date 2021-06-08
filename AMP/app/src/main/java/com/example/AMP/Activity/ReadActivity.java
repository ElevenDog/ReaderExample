package com.example.AMP.Activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;

import com.example.AMP.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadActivity extends AppCompatActivity {

    boolean flag=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_txt);
        FloatingActionButton fab=findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_night) );
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    flag=false;
                }else {
                    fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_action_name));
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    flag=true;
                }
            }
        });

        TextView txt=(TextView) findViewById(R.id.textView);

        try {
            // Return an AssetManager instance for your application's package
            InputStream is = getAssets().open("flight.csv");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer, "GB2312");
            txt.setText(text.toCharArray(),0,10000);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }finally {

            txt.setMovementMethod(ScrollingMovementMethod.getInstance());
        }

    }

    public static String ReadTxtFile(String strFilePath)
    {
        String path = strFilePath;
        String content = ""; //文件内容字符串
        //打开文件
        File file = new File(path);
        //如果path是传递过来的参数，可以做一个非目录的判断
        if (file.isDirectory())
        {
            //Log.d("TestFile", "The File doesn't not exist.");
        }
        else
        {
            try {
                InputStream stream = new FileInputStream(file);
                if (stream != null)
                {
                    InputStreamReader inputted = new InputStreamReader(stream);
                    BufferedReader buffered = new BufferedReader(inputted);
                    String line;
                    //分行读取
                    while (( line = buffered.readLine()) != null) {
                        content += line + "\n";
                    }
                    stream.close();
                }
            }
            catch (java.io.FileNotFoundException e)
            {

            }
            catch (IOException e)
            {

            }
        }
        return content;
    }
}
