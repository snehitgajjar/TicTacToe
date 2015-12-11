package com.example.snehitgajjar.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button playWithPlayer, playWithbot;
    private boolean isWithBot = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        playWithPlayer =(Button) findViewById(R.id.playerToPlayer);
        playWithbot =(Button) findViewById(R.id.botPlayer);


    }

    public void checkGameType(View view){

        if(view.getId() == R.id.botPlayer)
            isWithBot = true;


        Intent intent = new Intent(this, Game.class);
        intent.putExtra("gameType",isWithBot);
        startActivity(intent);

    }


    @Override
    public void onRestart() {
        super.onRestart();
       finish();
        startActivity(getIntent());
    }


}
