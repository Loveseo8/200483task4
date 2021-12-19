package com.add.a200483task4;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Rent extends AppCompatActivity {

    Button enterarticle, confirm;
    ArrayList<String> powers = new ArrayList<>();
    String a = "";
    SharedPreferences art;
    ImageView back;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_start);

        loadData();

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Rent.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        enterarticle = findViewById(R.id.enterarticule);

        art = getSharedPreferences("art", Context.MODE_PRIVATE);


        enterarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showEditDialog();
                setContentView(R.layout.activity_confirm_start);
                info = findViewById(R.id.info);
                info.setText("");
                ImageView b = findViewById(R.id.b);
                confirm = findViewById(R.id.accept);
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(Rent.this, MainActivity.class);
                        startActivity(i);
                        art.edit().clear().apply();
                        info.setText("");
                        finish();

                    }
                });
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent i = new Intent(Rent.this, MainActivity.class);
                        startActivity(i);
                        info.setText("");
                        finish();

                    }
                });
                a = art.getString("art", "");
                info.setText(findarticule(a));

            }
        });

    }

    private String findarticule(String a) {

        for (int i = 0; i < powers.size(); i++) {

            if (powers.get(i).contains(a)) {

                return powers.get(i);

            }

        }
        return "";
    }

    private void loadData(){

        powers.add("Наименование: \"Зайчик №221\" \nАртикул: ба1221 \nТариф: 1");
        powers.add("Наименование: \"Повербанк КОТЭ №70\" \nАртикул: а10007 \nТариф: 8");
        powers.add("Наименование: \"Повербанк КОТЭ №60\" \nАртикул: а10006 \nТариф: 8");
        powers.add("Наименование: \"Повербанк Альфа №300\" \nАртикул: ак2003 \nТариф: 5");
        powers.add("Наименование: \"Повербанк Кот №101\" \nАртикул: ак5001 \nТариф: 6");
        powers.add("Наименование: \"Повербанк Кот №401\" \nАртикул: ак5004 \nТариф: 6");
        powers.add("Наименование: \"Повербанк КОТЭ №20\" \nАртикул: а10002 \nТариф: 8");
        powers.add("Наименование: \"Повербанк КОТЭ №30\" \nАртикул: а10003 \nТариф: 8");
        powers.add("Наименование: \"Повербанк Альфа №100\" \nАртикул: ак2001 \nТариф: 5");
        powers.add("Наименование: \"Повербанк Альфа №400\" \nАртикул: ак2004 \nТариф: 5");
        powers.add("Наименование: \"Повербанк Кот №201\" \nАртикул: ак5002 \nТариф: 6");
        powers.add("Наименование: \"Повербанк Кот №301\" \nАртикул: ак5003 \nТариф: 6");
        powers.add("Наименование: \"Повербанк КОТЭ №80\" \nАртикул: а10008 \nТариф: 8");
        powers.add("Наименование: \"Повербанк Кот №501\" \nАртикул: ак5005 \nТариф: 6");
        powers.add("Наименование: \"Повербанк Альфа №200\" \nАртикул: ак2002 \nТариф: 5");
        powers.add("Наименование: \"Повербанк КОТЭ №50\" \nАртикул: а10005 \nТариф: 8");
        powers.add("Наименование: \"Повербанк КОТЭ №40\" \nАртикул: а10004 \nТариф: 8");
        powers.add("Наименование: \"Повербанк КОТЭ №10\" \nАртикул: а10001 \nТариф: 8");

    }

    private void showEditDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();
        final View dialogView = layoutInflater.inflate(R.layout.enter_article_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText edit_article = dialogView.findViewById(R.id.articule);
        final Button send_articule = dialogView.findViewById(R.id.send);

        dialogBuilder.setTitle("Ввести артикул");

        final AlertDialog b = dialogBuilder.create();
        b.show();

        send_articule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String articule = edit_article.getText().toString().trim();

                if (!TextUtils.isEmpty(articule)){

                    art.edit().putString("art", articule).commit();
                    info.setText(findarticule(articule));

                    b.dismiss();

                }

            }
        });

    }

}