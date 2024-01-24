package com.noureldin.tictactoe.GameDisplay;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
public class GameLogic {
    private String[] playerNames = {"player 1", "player 2"};

    //1st element --->row, 2st element --->col, 3st element ---> lineType
    private int[] winType = {-1,-1,-1};
    private final int [] [] gameBoard;
    private Button playerAgainButton;
    private Button homeButton;
    private TextView playerTurn;
    private int player =1;



    public GameLogic(){
        gameBoard = new int[3][3];

        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
               gameBoard[r][c] = 0;
            }

        }

    }

public boolean updateGameBoard(int row, int col){
        if (gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1] = player;



             if (player ==1){
                playerTurn.setText((playerNames[1] + " 's Turn"));
                 playerTurn.setTextColor(Color.GREEN); // Set the text color for player 1



             }
            else {
                playerTurn.setText((playerNames[0] + "  's Turn"));
                 playerTurn.setTextColor(Color.RED); // Set the text color for player 2

             }

            return true;
        }
        else {
            return false;
        }
}

public boolean WinnerCheck(){
        boolean isWinner = false;
        //Horizontal check
        for (int r=0; r<3; r++){
          if (gameBoard[r][0]==gameBoard[r][1] && gameBoard[r][0]==gameBoard[r][2]&&
          gameBoard[r][0] !=0){
              winType = new int[] {r,0,1};
              isWinner = true;

          }
        }
        //Vertical check
    for (int c=0; c<3; c++){
        if (gameBoard[0][c]==gameBoard[1][c] && gameBoard[2][c]==gameBoard[0][c]&&
                gameBoard[0][c] !=0){
            winType = new int[] {0,c,2};
            isWinner = true;

        }
    }
    //negative diagonal check
    if (gameBoard[0][0]==gameBoard[1][1] && gameBoard[2][2]==gameBoard[0][0]&&
            gameBoard[0][0] !=0){
        winType = new int[] {0,2,3};
        isWinner = true;

    }
    //Positive diagonal check
    if (gameBoard[2][0]==gameBoard[1][1] && gameBoard[0][2]==gameBoard[2][0]&&
            gameBoard[2][0] !=0){
        winType =new int[] {2,2,4};
        isWinner = true;

    }
    int boardFilled =0;
    for (int r=0; r<3; r++){
        for (int c=0; c<3; c++){
            if (gameBoard[r][c] !=0){
                boardFilled +=1;
            }
        }

    }


    if (isWinner){
        playerAgainButton.setVisibility(View.VISIBLE);
        homeButton.setVisibility(View.VISIBLE);
        playerTurn.setText((playerNames[player-1] + " Won!!!"));
        playerTurn.setTextColor(Color.YELLOW);
        return true;
}
    else if (boardFilled ==9){
        playerAgainButton.setVisibility(View.VISIBLE);
        homeButton.setVisibility(View.VISIBLE);
        playerTurn.setText("Tie Game!!!");
        playerTurn.setTextColor(Color.GRAY);
        return true;
    }
    else {
        return false;
    }

}




    public void resetGame(){
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                gameBoard[r][c] = 0;
            }

        }
        winType[0] = -1;
        winType[1] = -1;
        winType[2] = -1;



        player = 1;
        playerAgainButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0]+" 's Turn"));
        playerTurn.setTextColor(Color.WHITE);




    }

    public void setPlayerAgainButton(Button playerAgainButton) {
        this.playerAgainButton = playerAgainButton;
    }

    public void setHomeButton(Button homeButton) {
        this.homeButton = homeButton;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }
    public void setPlayer(int player){
        this.player =player;
    }

    public int getPlayer() {
        return player;
    }


    public int[] getWinType(){
        return winType;
    }


}
