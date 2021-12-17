package com.add.a200483task4;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView faq, feedback, stations;
    SharedPreferences name, surname, patronymic, phone, email, birth_date;
    String user_name, user_surname, user_patronymic, user_phone, user_email, user_birth_date;
    TextView txt_name, txt_surname, txt_patronymic, txt_phone, txt_email, txt_birth_date, edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getSharedPreferences("name", Context.MODE_PRIVATE);
        surname = getSharedPreferences("surname", Context.MODE_PRIVATE);
        patronymic = getSharedPreferences("patronymic", Context.MODE_PRIVATE);
        phone = getSharedPreferences("phone", Context.MODE_PRIVATE);
        email = getSharedPreferences("email", Context.MODE_PRIVATE);
        birth_date = getSharedPreferences("birth_date", Context.MODE_PRIVATE);

        //name.edit().putString("name", "Наталья").commit();

        user_name = name.getString("name", "Дарья");
        user_surname = surname.getString("surname", "Усачева");
        user_patronymic = patronymic.getString("patronymic", "Игоревна");
        user_phone = phone.getString("phone", "+7(999) 999-99-99");
        user_email = email.getString("email", "usad@1c.ru");
        user_birth_date = birth_date.getString("birth_date", "16 августа 1995г");

        txt_name = findViewById(R.id.name);
        txt_name.setText(user_name);
        txt_surname = findViewById(R.id.surname);
        txt_surname.setText(user_surname);
        txt_patronymic = findViewById(R.id.patronymic);
        txt_patronymic.setText(user_patronymic);
        txt_phone = findViewById(R.id.phone_number);
        txt_phone.setText(user_phone);
        txt_email = findViewById(R.id.email);
        txt_email.setText(user_email);
        txt_birth_date = findViewById(R.id.birth_date);
        txt_birth_date.setText(user_birth_date);

        faq = findViewById(R.id.faq);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, FQA.class);
                startActivity(i);

            }
        });

        feedback = findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Feedback.class);
                startActivity(i);

            }
        });

        stations = findViewById(R.id.stations);
        stations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, Stations.class);
                startActivity(i);

            }
        });

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showEditDialog();

            }
        });

    }


    private void showEditDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        final View dialogView = layoutInflater.inflate(R.layout.edit_data_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edit_name = dialogView.findViewById(R.id.edit_name);
        final EditText edit_surname = dialogView.findViewById(R.id.edit_surname);
        final EditText edit_patronymic = dialogView.findViewById(R.id.edit_patronymic);
        final EditText edit_email = dialogView.findViewById(R.id.edit_email);
        final EditText edit_phone = dialogView.findViewById(R.id.edit_phone);
        final TextView edit_birth_date = dialogView.findViewById(R.id.date);
        final TextView ebirth_date = dialogView.findViewById(R.id.birth_date);
        final Button button_save = dialogView.findViewById(R.id.save);

        dialogBuilder.setTitle("Изменить информацию о пользователе");
        final AlertDialog b = dialogBuilder.create();
        b.show();


        edit_birth_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dataPickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                        i1++;

                        String dialog_birth = "";

                        if (i1 == 1) dialog_birth = i2 + " " + " января " + i + "г";
                        else if (i1 == 2) dialog_birth = i2 + " " + " февраля " + i + "г";
                        else if (i1 == 3) dialog_birth = i2 + " " + " марта " + i + "г";
                        else if (i1 == 4) dialog_birth = i2 + " " + " апреля " + i + "г";
                        else if (i1 == 5) dialog_birth = i2 + " " + " мая " + i + "г";
                        else if (i1 == 6) dialog_birth = i2 + " " + " июня " + i + "г";
                        else if (i1 == 7) dialog_birth = i2 + " " + " июля " + i + "г";
                        else if (i1 == 8) dialog_birth = i2 + " " + " августа " + i + "г";
                        else if (i1 == 9) dialog_birth = i2 + " " + " сентября " + i + "г";
                        else if (i1 == 10) dialog_birth = i2 + " " + " октября " + i + "г";
                        else if (i1 == 11) dialog_birth = i2 + " " + " ноября " + i + "г";
                        else if (i1 == 12) dialog_birth = i2 + " " + " декабря " + i + "г";

                        ebirth_date.setText(dialog_birth);
                    }
                },mYear, mMonth, mDay);

                dataPickerDialog.show();

            }
        });



        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dialog_name = edit_name.getText().toString().trim();

                if (!TextUtils.isEmpty(dialog_name)) {

                    name.edit().putString("name", dialog_name).commit();
                    txt_name.setText(name.getString("name", "Дарья"));

                }

                String dialog_birth = ebirth_date.getText().toString().trim();

                if (!TextUtils.isEmpty(dialog_birth)) {

                    birth_date.edit().putString("birth_date", dialog_birth).commit();
                    txt_birth_date.setText(birth_date.getString("birth_date", "16 августа 1995г"));

                }

                String dialog_surname = edit_surname.getText().toString().trim();

                if (!TextUtils.isEmpty(dialog_surname)) {

                    surname.edit().putString("surname", dialog_surname).commit();
                    txt_surname.setText(surname.getString("surname", "Усачева"));

                }

                String dialog_patronymic = edit_patronymic.getText().toString().trim();

                if (!TextUtils.isEmpty(dialog_patronymic)) {

                    patronymic.edit().putString("patronymic", dialog_patronymic).commit();
                    txt_patronymic.setText(patronymic.getString("patronymic", "Игоревна"));

                }

                String dialog_email = edit_email.getText().toString().trim();

                if (!TextUtils.isEmpty(dialog_email)) {

                    email.edit().putString("email", dialog_email).commit();
                    txt_email.setText(email.getString("email", "usad@1c.ru"));

                }

                String dialog_phone = edit_phone.getText().toString().trim();

                if (!TextUtils.isEmpty(dialog_phone)) {

                    if (dialog_phone.startsWith("8")) {

                        ArrayList<Character> number = new ArrayList<>();

                        for (int i = 0; i < dialog_phone.length(); i++)
                            number.add(dialog_phone.charAt(i));

                        number.remove(0);
                        number.add(0, '(');
                        number.add(0, '7');
                        number.add(0, '+');
                        number.add(6, ')');
                        number.add(7, ' ');
                        number.add(11, '-');
                        number.add(14, '-');

                        dialog_phone = "";
                        for (int i = 0; i < number.size(); i++) dialog_phone += number.get(i);


                    } else if (dialog_phone.startsWith("+7")) {

                        ArrayList<Character> number = new ArrayList<>();

                        for (int i = 0; i < dialog_phone.length(); i++)
                            number.add(dialog_phone.charAt(i));

                        number.add(2, '(');
                        number.add(6, ')');
                        number.add(7, ' ');
                        number.add(11, '-');
                        number.add(14, '-');

                        dialog_phone = "";
                        for (int i = 0; i < number.size(); i++) dialog_phone += number.get(i);

                    }


                    phone.edit().putString("phone", dialog_phone).commit();
                    txt_phone.setText(phone.getString("phone", "+7(999) 999-99-99"));

                }

                b.dismiss();

            }
        });



    }
}