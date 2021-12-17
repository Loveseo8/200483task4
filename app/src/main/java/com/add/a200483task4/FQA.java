package com.add.a200483task4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FQA extends AppCompatActivity {

    HashMap<String, List<String>> my_header;
    List<String> my_child;
    ExpandableListView expandableListView;
    ExpandableAdapter expandableAdapter;
    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fqa);

        expandableListView = findViewById(R.id.expandable_list_view);
        my_header = DataProvider.getInfo();
        my_child = new ArrayList<>(my_header.keySet());
        expandableAdapter = new ExpandableAdapter(getApplicationContext(), my_child, my_header);
        expandableListView.setAdapter(expandableAdapter);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(FQA.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}

class DataProvider {

    public static HashMap<String, List<String>> getInfo() {

        HashMap<String, List<String>> header_details = new HashMap<>();
        List<String> question1 = new ArrayList<>();
        List<String> question2 = new ArrayList<>();
        question1.add("В коде шифруется информация о товаре. Когда Вы сканируете код, мы узнаём какой именно товар Вы выбрали для аренды.");
        question2.add("На главном экране приложения есть кнопка \"История\", нажав на её Вы сможете посмотреть историю.");
        header_details.put("Как взять в аренду товар?", question1);
        header_details.put("Как изменить данные о пользователе?", question1);
        header_details.put("Как посмотреть доступные в аренду товары рядом со мной?", question1);
        header_details.put("Где посмотреть историю?", question2);
        header_details.put("Что значит \"Ввести артикул\"?", question1);
        header_details.put("Что значит \"Отсканировать QR-код\"?", question1);
        header_details.put("Зачем мне делать фото?", question1);
        header_details.put("Как написать жалобу?", question1);
        header_details.put("Как с вами всязаться?", question1);

        return header_details;

    }


}