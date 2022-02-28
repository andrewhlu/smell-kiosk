package com.example.smellarduino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout peachButton;
    private ConstraintLayout mangoButton;
    private ConstraintLayout strawberryButton;
    private boolean peachSmellEnabled = false;
    private boolean mangoSmellEnabled = false;
    private boolean strawberrySmellEnabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Connect to arduino via Bluetooth
//        Intent dispenseIntent = new Intent(this, BluetoothService.class);
//        startService(dispenseIntent);

        peachButton = findViewById(R.id.drink1);
        mangoButton = findViewById(R.id.drink2);
        strawberryButton = findViewById(R.id.drink3);

        peachButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (peachSmellEnabled)  {
                    smellIntent.putExtra("fanSpeed", 0);
                    smellIntent.putExtra("fanLabel", "A");
                    peachSmellEnabled = false;
                } else {
                    smellIntent.putExtra("fanSpeed",  1);
                    smellIntent.putExtra("fanLabel", "A");
                    peachSmellEnabled = true;
                }
                startService(smellIntent);
            }
        });

        mangoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (mangoSmellEnabled) {
                    smellIntent.putExtra("fanSpeed", 0);
                    smellIntent.putExtra("fanLabel", "B");
                    mangoSmellEnabled = false;
                } else {
                    smellIntent.putExtra("fanSpeed", 1);
                    smellIntent.putExtra("fanLabel", "B");
                    mangoSmellEnabled = true;
                }
                startService(smellIntent);
            }
        });

        strawberryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent smellIntent = new Intent(getApplicationContext(), BluetoothService.class);
                if (strawberrySmellEnabled) {
                    smellIntent.putExtra("fanSpeed", 0);
                    smellIntent.putExtra("fanLabel", "C");
                    strawberrySmellEnabled = false;
                } else {
                    smellIntent.putExtra("fanSpeed", 1);
                    smellIntent.putExtra("fanLabel", "C");
                    strawberrySmellEnabled = true;
                }
                startService(smellIntent);
            }
        });
    }
}