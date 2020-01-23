package com.example.toastpersonalizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnDefault, btnPosicion, btnPersonalizada;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnDefault = findViewById(R.id.btnDefault);
        btnPosicion = findViewById(R.id.btnPosicion);
        btnPersonalizada = findViewById(R.id.btnPersonalizada);

        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toast defectiva", Toast.LENGTH_SHORT).show();
            }
        });

        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(getApplicationContext(), "Toast en otra posición", Toast.LENGTH_SHORT);
                t.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.TOP, 0, 20);
                t.show();
            }
        });

        btnPersonalizada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout llToast = findViewById(R.id.llToast);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.toast_layout, llToast);
                TextView txtToast = view.findViewById(R.id.txtToast);
                txtToast.setText("Toast personalizada");
                Toast t = new Toast(MainActivity.this);
                t.setDuration(Toast.LENGTH_SHORT);
                t.setView(view);
                t.show();
            }
        });
    }
}
