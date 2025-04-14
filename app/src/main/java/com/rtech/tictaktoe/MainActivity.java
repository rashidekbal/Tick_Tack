package com.rtech.tictaktoe;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    TextView user,bot,turn;
    String userChoice="x";
    String BotChocie="o";
    int moves=0;
    int flag=0;
    ArrayList <Integer>  used =new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();




    }
    public void UserClick(View v){
    Button current =(Button) v;
        String tag = (String) v.getTag();
        int tagValue = Integer.parseInt(tag); // Convert to int if needed
        used.add(tagValue);
    if(flag==0){
        if(current.getText().equals("")){
            current.setText(userChoice);
            if(userChoice.equals("o")){
                current.setTextColor(Color.parseColor("#C60187"));
            }else {
                current.setTextColor(Color.parseColor("#DCF3FE"));
            }
            moves++;

            flag=1;
            turn.setText("computer's turn");

              if(  verifyWin("you")==0){
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          if(moves<9&& moves>0){
                              BotClick();
                          }


                      }
                  },1500);

              }



        }
    }
    }
    @SuppressLint("SetTextI18n")
    private void BotClick(){

        if(flag==1){
            int Random=(int)Math.floor(Math.random()*10);
            while(used.contains(Random)||Random==0){
                Random=(int)Math.floor(Math.random()*10);
            }
            Log.d("Random", String.valueOf(Random));
            used.add(Random);
            switch (Random){
                case 1:
                    btn1.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn1.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn1.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 2:
                    btn2.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn2.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn2.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 3:
                    btn3.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn3.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn3.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;

                case 4:
                    btn4.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn4.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn4.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 5:
                    btn5.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn5.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn5.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 6:
                    btn6.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn6.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn6.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 7:
                    btn7.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn7.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn7.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 8:
                    btn8.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn8.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn8.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
                case 9:
                    btn9.setText(BotChocie);
                    if(BotChocie.equals("o")){
                        btn9.setTextColor(Color.parseColor("#C60187"));
                    }else {
                        btn9.setTextColor(Color.parseColor("#DCF3FE"));
                    }
                    break;
            }
            if(verifyWin("computer")==0){
               moves++;
               flag=0;
               turn.setText("your turn");
           }
        }

    }
    private int verifyWin(String player){
        String box1,box2,box3,box4,box5,box6,box7,box8,box9;
        box1=btn1.getText().toString();
        box2=btn2.getText().toString();
        box3=btn3.getText().toString();
        box4=btn4.getText().toString();
        box5=btn5.getText().toString();
        box6=btn6.getText().toString();
        box7=btn7.getText().toString();
        box8=btn8.getText().toString();
        box9=btn9.getText().toString();

        if(box1.equals(box2)&& box2.equals(box3)&& !box1.isEmpty()){
            //row 1
            Toast.makeText(this,player+"  win!", Toast.LENGTH_LONG).show();
            Reset();
            return 1;
        }else if (box4.equals(box5)&& box5.equals(box6)&& !box4.isEmpty()){
            //row 2
            Toast.makeText(this,player+" win!",Toast.LENGTH_LONG).show();
            Reset();
            return 1;
        }else if (box7.equals(box8)&& box8.equals(box9)&& !box7.isEmpty()){
            //row 3
            Toast.makeText(this,player+" win!", Toast.LENGTH_LONG).show();
            Reset();
            return 1;
        }else if(box1.equals(box4)&& box4.equals(box7)&& !box1.isEmpty()){
            //column1
            Toast.makeText(this,player+" win!", Toast.LENGTH_LONG).show();
            Reset();
            return 1;

        }else if(box2.equals(box5)&& box5.equals(box8)&& !box2.isEmpty()){
            //column2
            Toast.makeText(this,player+" win!",Toast.LENGTH_LONG).show();
            Reset();
            return 1;

        }else if(box3.equals(box6)&& box6.equals(box9)&& !box3.isEmpty()){
            //column3
            Toast.makeText(this,player+" win!",Toast.LENGTH_LONG).show();
            Reset();
            return 1;

        } else if (box1.equals(box5)&& box5.equals(box9)&& !box1.isEmpty()) {
            //diagonal forward
            Toast.makeText(this,player+" win!", Toast.LENGTH_LONG).show();
            Reset();
            return 1;

        } else if (box7.equals(box5)&& box5.equals(box3)&& !box7.isEmpty()) {
         // diagonal backword
            Toast.makeText(this,player+" win!",Toast.LENGTH_LONG).show();
            Reset();
            return 1;
        }else{
            if(moves==9){
                Reset();
            }
        }
        return 0;
    }
    private void  Reset(){
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                btn1.setText("");
                btn2.setText("");
                btn3.setText("");
                btn4.setText("");
                btn5.setText("");
                btn6.setText("");
                btn7.setText("");
                btn8.setText("");
                btn9.setText("");
                flag=0;
                moves=0;
                used.clear();
                String temp=userChoice;
                userChoice=BotChocie;
                BotChocie=temp;
                user.setText(userChoice);
                bot.setText(BotChocie);
                if(BotChocie.equals("o")){
                    bot.setTextColor(Color.parseColor("#C60187"));
                }else {
                    bot.setTextColor(Color.parseColor("#DCF3FE"));
                }
                if(userChoice.equals("o")){
                    user.setTextColor(Color.parseColor("#C60187"));
                }else {
                    user.setTextColor(Color.parseColor("#DCF3FE"));
                }
                turn.setText("your turn");

            }
        },2000);


    }
    private void init(){
        btn1=findViewById(R.id.box1);
        btn2=findViewById(R.id.box2);
        btn3=findViewById(R.id.box3);
        btn4=findViewById(R.id.box4);
        btn5=findViewById(R.id.box5);
        btn6=findViewById(R.id.box6);
        btn7=findViewById(R.id.box7);
        btn8=findViewById(R.id.box8);
        btn9=findViewById(R.id.box9);
        user=findViewById(R.id.User);
        bot=findViewById(R.id.bot);
        turn=findViewById(R.id.Turn_text);
    }

}