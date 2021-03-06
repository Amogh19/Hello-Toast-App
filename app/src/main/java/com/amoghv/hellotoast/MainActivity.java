package com.amoghv.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView mTextView;
Button t_button,c_button;
int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.tv);
        t_button = findViewById(R.id.toast_button);
        c_button = findViewById(R.id.count_button);
        if (savedInstanceState != null && savedInstanceState.containsKey("key_name")){
            c=savedInstanceState.getInt("key_name");
            mTextView.setText(String.valueOf(c));
        }
        t_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"The Count is : "+String.valueOf(c),Toast.LENGTH_SHORT).show();
            }
        });
        c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                mTextView.setText(String.valueOf(c));
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("key_name",c);
    }
}