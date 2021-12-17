package com.add.a200483task4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Feedback extends AppCompatActivity {

    ImageView back;
    EditText topic, text;
    Button send;
    SharedPreferences name, surname, patronymic;
    String user_name, user_surname, user_patronymic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name = getSharedPreferences("name", Context.MODE_PRIVATE);
        surname = getSharedPreferences("surname", Context.MODE_PRIVATE);
        patronymic = getSharedPreferences("patronymic", Context.MODE_PRIVATE);

        user_name = name.getString("name", "Дарья");
        user_surname = surname.getString("surname", "Усачева");
        user_patronymic = patronymic.getString("patronymic", "Игоревна");

        back = findViewById(R.id.back);
        topic = findViewById(R.id.topic);
        text = findViewById(R.id.text);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("email"));
                String [] to = {"KO.T.E@yandex.ru"};
                i.putExtra(Intent.EXTRA_EMAIL, to);
                i.putExtra(Intent.EXTRA_TEXT, formatter.format(calendar.getTime()) + "  Поступило письмо от пользователя " + user_surname + " " + user_name + " " + user_patronymic + "\n" + "На тему \"" + topic.getText().toString() + "\"\n" + "Письмо: " + text.getText().toString());
                i.putExtra(Intent.EXTRA_SUBJECT, "Письмо от пользователя " + user_surname + " " + user_name + " " + user_patronymic);
                i.setType("message/rfc822");
                Intent chooser = Intent.createChooser(i, "Launch Email");
                startActivity(chooser);
                topic.setText("");
                text.setText("");
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Feedback.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}