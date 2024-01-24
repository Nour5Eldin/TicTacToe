package com.noureldin.tictactoe.GameDisplay;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.noureldin.tictactoe.MainActivity;
import com.noureldin.tictactoe.R;

public class GameDisplay extends AppCompatActivity {
    private TicTacToeBoard ticTacToeBoard;
    private Button playAgainButton;
    private Button homeButton;
    private TextView playerTurn;
    private String[] playerNames;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_display);

        playAgainButton = findViewById(R.id.play_AgainButton);
        homeButton = findViewById(R.id.HomeButton);
        playerTurn = findViewById(R.id.player_display);


        homeButton.setVisibility(View.GONE);
        playAgainButton.setVisibility(View.GONE);

        ticTacToeBoard = findViewById(R.id.TicTacToeBoard);

         playerNames = getIntent().getStringArrayExtra("PLAYER_NAMES");



        if (playerNames != null) {
            playerTurn.setText((playerNames[0] + " 's Turn"));


        }



        ticTacToeBoard.setUpGame(playAgainButton, homeButton, playerTurn, playerNames);
    }


    public void PlayAgainButtonClick (View view){
        ticTacToeBoard.resetGame();
        ticTacToeBoard.invalidate();

    }
    public void HomeButtonClick (View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}