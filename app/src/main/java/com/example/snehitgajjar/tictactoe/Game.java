package com.example.snehitgajjar.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Game extends AppCompatActivity {

    private boolean isGameOver=true;
    private int player;
    private int playerOneWon=0, playerTwoWon=0;
    private Button buttons[][] =new Button[3][3];
    private TextView score=null;
    int buttonNames[][] ={{R.id.button_one,R.id.button_two,R.id.button_three},{R.id.button_four,R.id.button_five,
            R.id.button_six},{R.id.button_seven,R.id.button_eight,R.id.button_nine}};

    private boolean isVersusBot = true;

    int marked[][] =new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        isVersusBot= getIntent().getExtras().getBoolean("gameType");
        player = 1;
        registerButtons();
    }

    private void registerButtons() {

        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[0].length;j++) {
                buttons[i][j] = (Button) findViewById(buttonNames[i][j]);
                marked[i][j] = 10;
            }
        }

        score =(TextView) findViewById(R.id.score);

    }

    public void onBtnOneClicked(View v){


        buttons[0][0].setText(player==1?"X" : "O");
        buttons[0][0].setClickable(false);
        marked[0][0] = player;
        //checkWinner();

       // player = player==1?2:1;

        boolean check =checkWinner();
        if(isVersusBot && player ==1 &&  !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnTwoClicked(View v){

        buttons[0][1].setText(player == 1 ? "X" : "O");
        buttons[0][1].setClickable(false);
        marked[0][1] = player;

        //checkWinner();
        boolean check =checkWinner();
        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }
    public void onBtnThreeClicked(View v){


        buttons[0][2].setText(player == 1 ? "X" : "O");
        buttons[0][2].setClickable(false);
        marked[0][2] = player;
        //checkWinner();
        boolean check =checkWinner();
        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1&& !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnFourClicked(View v){


        buttons[1][0].setText(player == 1 ? "X" : "O");
        buttons[1][0].setClickable(false);
        marked[1][0] = player;
        //checkWinner();
        boolean check =checkWinner();
        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnFiveClicked(View v){


        buttons[1][1].setText(player == 1 ? "X" : "O");
        buttons[1][1].setClickable(false);
        marked[1][1] = player;
       boolean check =checkWinner();
        System.out.println("Chcking in fifth : "+check);
        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnSixClicked(View v){


        buttons[1][2].setText(player == 1 ? "X" : "O");
        buttons[1][2].setClickable(false);
        marked[1][2] = player;
        boolean check =checkWinner();

        if(isVersusBot && player ==1 &&  !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnSevenClicked(View v){


        buttons[2][0].setText(player == 1 ? "X" : "O");
        buttons[2][0].setClickable(false);
        marked[2][0] = player;
        boolean check =checkWinner();

        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnEightClicked(View v){


        buttons[2][1].setText(player == 1 ? "X" : "O");
        buttons[2][1].setClickable(false);
        marked[2][1] = player;
        //checkWinner();
        boolean check =checkWinner();
        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public void onBtnNineClicked(View v){


        buttons[2][2].setText(player == 1 ? "X" : "O");
        buttons[2][2].setClickable(false);
        marked[2][2] = player;
       // checkWinner();
        boolean check =checkWinner();

        if(isVersusBot && player ==1 && !check){
            player = 2;
            botMove();
        }
        else if(player==1 && !check ){
            player=2;
        }
        else{
            player =1;
        }
    }

    public boolean checkWinner(){
        boolean value = (checkRowWinner() || checkColumnWinner() || checkDiagonalWinner());
        System.out.println("In checkWinners : "+value);
        return value;
    }



    public boolean checkRowWinner(){

        for(int i=0;i<buttons.length;i++){
            int check = 0;
            for(int j=0;j<buttons[i].length;j++){
                check = marked[i][j] + check;
            }
            if(check==3) {
                Toast.makeText(getApplicationContext(),"Player "+1+" won",Toast.LENGTH_SHORT).show();
                playerOneWon++;
                score.setText(playerOneWon + " - " + playerTwoWon);
                resetGame();
                return true;
            }
            else if(check == 6) {
                Toast.makeText(getApplicationContext(),"Player "+2+" won",Toast.LENGTH_SHORT).show();
                playerTwoWon++;
                score.setText(playerOneWon + " - " + playerTwoWon);
                resetGame();
                return true;
            }
        }

        return false;
    }

    public boolean checkColumnWinner(){

        for(int i=0;i<buttons.length;i++){
            int check = 0;
            for(int j=0;j<buttons[i].length;j++){
                check = marked[j][i] + check;
            }
            if(check==3) {
                Toast.makeText(getApplicationContext(),"Player "+1+" won",Toast.LENGTH_SHORT).show();
                playerOneWon++;
                score.setText(playerOneWon + " - " + playerTwoWon);
                resetGame();
                return true;
            }
            else if(check == 6) {
                Toast.makeText(getApplicationContext(),"Player "+2+" won",Toast.LENGTH_SHORT).show();
                playerTwoWon++;
                score.setText(playerOneWon + " - " + playerTwoWon);
                resetGame();
                return true;
            }

        }

        return false;
    }

    public boolean checkDiagonalWinner(){

        int leftRight = marked[0][0] + marked[1][1]+marked[2][2];
        int rightLeft = marked[0][2] + marked[1][1]+marked[2][0];


        if(leftRight==3 || rightLeft==3) {
            Toast.makeText(getApplicationContext(),"Player "+1+" won",Toast.LENGTH_SHORT).show();
            playerOneWon++;
            score.setText(playerOneWon + " - " + playerTwoWon);
            resetGame();
            return true;
        }
        else if(leftRight == 6 || rightLeft==6) {
            Toast.makeText(getApplicationContext(),"Player "+2+" won",Toast.LENGTH_SHORT).show();
            playerTwoWon++;
            score.setText(playerOneWon + " - " + playerTwoWon);
            resetGame();
            return true;
        }

        return false;
    }


    public void clearBoard(){
        for(int i=0;i<buttons.length;i++){
            for(int j=0;j<buttons[0].length;j++) {
                buttons[i][j].setText("");
                marked[i][j] = 10;
                buttons[i][j].setClickable(true);
            }
        }
    }

    public void resetGame(){
        //isGameOver=true;
        player = 1;
        clearBoard();

    }

    public void resetGame(View view){


        score.setText(0+" - "+0);
        resetGame();
    }


    ArrayList<Position> list=null;

    public boolean findSponOnRow(){

        for(int i=0;i<buttons.length;i++){
            int check = 0;
            for(int j=0;j<buttons[i].length;j++){
                if(marked[i][j]==10){
                    list.add(new Position(i,j));
                }

                check = marked[i][j] + check;
            }

            if(check==12) {

                int x = list.get(list.size()-1).x;
                int y = list.get(list.size()-1).y;
                buttons[x][y].setText(player == 1 ? "X" : "O");
                buttons[x][y].setClickable(false);
                marked[x][y] = player;
                //checkWinner();
               // player = player==1?2:1;
                return true;
            }

        }
        return false;

    }

    public boolean findSponOnColumn(){

        for(int i=0;i<buttons.length;i++){
            int check = 0;
            for(int j=0;j<buttons[i].length;j++){
                if(marked[j][i]==10){
                    list.add(new Position(j,i));
                }

                check = marked[j][i] + check;
            }

            if(check==12) {

                int x = list.get(list.size()-1).x;
                int y = list.get(list.size() - 1).y;
                buttons[x][y].setText(player == 1 ? "X" : "O");
                buttons[x][y].setClickable(false);
                marked[x][y] = player;
                //checkWinner();
                //player = player==1?2:1;
                return true;
            }

        }
        return false;

    }



    public void botMove(){

        list= new ArrayList<Position>();
        System.out.println("in botMove");
        if(!findSponOnRow()){

            System.out.println("in botMove if1");
            if(!findSponOnColumn()){

                Random rand = new Random();
                if(list.size()==0)
                {
                    resetGame();
                    return;
                }
                int position =rand.nextInt(list.size());
                int x = list.get(position).x;
                int y = list.get(position).y;
                buttons[x][y].setText(player == 1 ? "X" : "O");
                buttons[x][y].setClickable(false);
                marked[x][y] = player;




            }
        }


        boolean check = checkWinner();

        System.out.println("bot played" + check);
        if(check){
            resetGame();
        }
        else{
            player =1;
        }

    }

}
