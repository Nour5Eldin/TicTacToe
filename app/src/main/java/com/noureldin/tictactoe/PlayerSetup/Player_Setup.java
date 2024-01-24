package com.noureldin.tictactoe.PlayerSetup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.noureldin.tictactoe.GameDisplay.GameDisplay;
import com.noureldin.tictactoe.R;


public class Player_Setup extends AppCompatActivity {

     EditText player1;
     EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_setup);

        player1 = findViewById(R.id.editText_Player1Name);
        player2 = findViewById(R.id.editText_Player2Name);





    }
    @SuppressLint("ResourceAsColor")
    public void submitButtonClick(View view){
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();


        if (player1Name.isEmpty()||player2Name.isEmpty()){
            Toast.makeText(this, "Please, Enter your Names ", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent = new Intent(this, GameDisplay.class);
            intent.putExtra("PLAYER_NAMES",new String[] {player1Name,player2Name});
            startActivity(intent);
        }



    }

}