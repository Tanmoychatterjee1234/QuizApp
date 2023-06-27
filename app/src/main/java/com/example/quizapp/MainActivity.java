package com.example.quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView questionTv,questionNumberTv;
    private Button option1,option2,option3,option4,nextbutton;
    private ArrayList<QuizModal>quizModalArrayList;
    int currentScore=0,questionAttempted=0,currentPos;
    CharSequence text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionNumberTv=findViewById(R.id.no_of_questions);
        questionTv=findViewById(R.id.question_tv);
        option1=findViewById(R.id.option_1);
        option2=findViewById(R.id.option_2);
        option3=findViewById(R.id.option_3);
        option4=findViewById(R.id.option_4);
        nextbutton=findViewById(R.id.nextbtn);
        quizModalArrayList=new ArrayList<>();
        getQuizQuestion(quizModalArrayList);
        currentPos=0;
        setDataToViews(currentPos);
        option1.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option1.getText().toString().trim()))
            {
                currentScore++;
                text = "Your answer is correct!!";
            }
            else
            {
                text = "Your answer is wrong!!";
            }
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP,0,250);
            toast.setDuration(Toast.LENGTH_SHORT);
            TextView tv=new TextView(MainActivity.this);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(20);
            tv.setText(text);
            toast.setView(tv);
            toast.show();
            questionAttempted++;
            currentPos++;
            final Handler handler = new Handler();
            handler.postDelayed(() -> setDataToViews(currentPos), 2100);
        });
        option2.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option2.getText().toString().trim()))
            {
                currentScore++;
                text = "Your answer is correct!!";
            }
            else
            {
                text = "Your answer is wrong!!";
            }
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP,0,250);
            toast.setDuration(Toast.LENGTH_SHORT);
            TextView tv=new TextView(MainActivity.this);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(20);
            tv.setText(text);
            toast.setView(tv);
            toast.show();
            questionAttempted++;
            currentPos++;
            final Handler handler = new Handler();
            handler.postDelayed(() -> setDataToViews(currentPos), 2100);
        });
        option3.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option3.getText().toString().trim()))
            {
                currentScore++;
                text = "Your answer is correct!!";
            }
            else
            {
                text = "Your answer is wrong!!";
            }
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP,0,250);
            toast.setDuration(Toast.LENGTH_SHORT);
            TextView tv=new TextView(MainActivity.this);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(20);
            tv.setText(text);
            toast.setView(tv);
            toast.show();
            questionAttempted++;
            currentPos++;
            final Handler handler = new Handler();
            handler.postDelayed(() -> setDataToViews(currentPos), 2100);
        });
        option4.setOnClickListener(v -> {
            if(quizModalArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option4.getText().toString().trim()))
            {
                currentScore++;
                text = "Your answer is correct!!";
            }
            else
            {
                text = "Your answer is wrong!!";
            }
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP,0,250);
            toast.setDuration(Toast.LENGTH_SHORT);
            TextView tv=new TextView(MainActivity.this);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(20);
            tv.setText(text);
            toast.setView(tv);
            toast.show();
            questionAttempted++;
            currentPos++;
            final Handler handler = new Handler();
            handler.postDelayed(() -> setDataToViews(currentPos), 2100);
        });
        nextbutton.setOnClickListener(v -> {
            text = "You skipped the question!!";
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.TOP,0,250);
            toast.setDuration(Toast.LENGTH_SHORT);
            TextView tv=new TextView(MainActivity.this);
            tv.setTextColor(Color.WHITE);
            tv.setTextSize(20);
            tv.setText(text);
            toast.setView(tv);
            toast.show();
            questionAttempted++;
            currentPos++;
            final Handler handler = new Handler();
            handler.postDelayed(() -> setDataToViews(currentPos), 2100);
        });
    }


    @SuppressLint("SetTextI18n")
    private void showBottomSheet()
    {
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.scorecard));
        TextView scoreTv=bottomSheetView.findViewById(R.id.score);
        Button restartQuiz=bottomSheetView.findViewById(R.id.restartButton);
        scoreTv.setText("Your final score is \n "+currentScore+"/16");
        restartQuiz.setOnClickListener(v -> {
            currentPos=0;
            setDataToViews(currentPos);
            questionAttempted=0;
            currentScore=0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    @SuppressLint("SetTextI18n")
    private void setDataToViews(int currentPos) {
        questionNumberTv.setText("Your current score is : "+currentScore+"/"+questionAttempted);
        if(questionAttempted==16)
        {
            showBottomSheet();
        }
        else
        {
            questionTv.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1.setText(quizModalArrayList.get(currentPos).getOption1());
            option2.setText(quizModalArrayList.get(currentPos).getOption2());
            option3.setText(quizModalArrayList.get(currentPos).getOption3());
            option4.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal>quizModalArrayList) {
        quizModalArrayList.add(new QuizModal(" Which one of the following river flows between Vindhyan and Satpura ranges?",
                "Narmada"," Mahanadi","Son"," Netravati","Narmada"));
        quizModalArrayList.add(new QuizModal("The Central Rice Research Station is situated in?",
                " Chennai","Cuttack","Bangalore","Quilon","Cuttack"));
        quizModalArrayList.add(new QuizModal("Who among the following wrote Sanskrit grammar?",
                "Kalidasa"," Charak"," Aryabhatt","Panini","Panini"));
        quizModalArrayList.add(new QuizModal("Which among the following headstreams meets the Ganges in last?",
                "Alaknanda"," Pindar","Mandakini","Bhagirathi","Bhagirathi"));
        quizModalArrayList.add(new QuizModal(" The metal whose salts are sensitive to light is?",
                "Zinc","Silver","Copper","Aluminum","Silver"));
        quizModalArrayList.add(new QuizModal( "Patanjali is well known for the compilation of –",
                "Yoga Sutra","Panchatantra","Brahma Sutra"," Ayurveda","Yoga Sutra"));
        quizModalArrayList.add(new QuizModal("River Luni originates near Pushkar and drains into which one of the following?",
                "Rann of Kachchh"," Arabian Sea","Gulf of Cambay","Lake Sambhar","Rann of Kachchh"));
        quizModalArrayList.add(new QuizModal("Which one of the following rivers originates in Brahmagiri range of Western Ghats?",
                "Pennar"," Cauvery","Krishna","Tapti","Cauvery"));
        quizModalArrayList.add(new QuizModal("The country that has the highest in Barley Production?",
                "China","India","Russia","France"," Russia"));
        quizModalArrayList.add(new QuizModal("Tsunamis are not caused by",
                "Hurricanes","Earthquakes","Undersea landslides"," Volcanic eruptions","Hurricanes"));
        quizModalArrayList.add(new QuizModal("Chambal river is a part of –",
                "Sabarmati basin","Ganga basin","Narmada basin","Godavari basin"," Narmada basin"));
        quizModalArrayList.add(new QuizModal("D.D.T. was invented by?",
                " Mosley","Rudolf","Karl Benz"," Dalton","Mosley"));
        quizModalArrayList.add(new QuizModal("Volcanic eruption do not occur in the",
                "Baltic sea"," Black sea"," Caribbean sea","Caspian sea","Baltic sea"));
        quizModalArrayList.add(new QuizModal("Indus river originates in –",
                "Kinnaur"," Ladakh"," Nepal","Tibet","Tibet"));
        quizModalArrayList.add(new QuizModal("The hottest planet in the solar system?",
                "Mercury"," Venus","Mars","  Jupiter"," Venus"));
        quizModalArrayList.add(new QuizModal("With which of the following rivers does Chambal river merge?",
                "Banas","Ganga","Narmada","Yamuna","Yamuna"));
    }
}