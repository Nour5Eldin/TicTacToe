package com.noureldin.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.noureldin.tictactoe.PlayerSetup.Player_Setup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void PlayButtonClick (View view){
        Intent intent = new Intent(this, Player_Setup.class);
        startActivity(intent);
    }
}