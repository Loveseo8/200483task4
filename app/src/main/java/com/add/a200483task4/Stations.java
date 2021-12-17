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

public class Stations extends AppCompatActivity {

    HashMap<String, List<String>> my_header;
    List<String> my_child;
    ExpandableListView expandableListView;
    ExpandableAdapter expandableAdapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations);

        expandableListView = findViewById(R.id.expandable_list_view);
        my_header = DataProviderStations.getInfo();
        my_child = new ArrayList<>(my_header.keySet());
        expandableAdapter = new ExpandableAdapter(getApplicationContext(), my_child, my_header);
        expandableListView.setAdapter(expandableAdapter);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Stations.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

    }
}

class DataProviderStations {

    public static HashMap<String, List<String>> getInfo() {

        HashMap<String, List<String>> header_details = new HashMap<>();
        List<String> question1 = new ArrayList<>();
        question1.add("Наименование: \"Зайчик №221\" \nАртикул: ба1221 \nТариф: 1");
        question1.add("Наименование: \"Повербанк КОТЭ №70\" \nАртикул: а10007 \nТариф: 8");
        question1.add("Наименование: \"Повербанк КОТЭ №60\" \nАртикул: а10006 \nТариф: 8");
        question1.add("Наименование: \"Повербанк Альфа №300\" \nАртикул: ак2003 \nТариф: 5");
        question1.add("Наименование: \"Повербанк Кот №101\" \nАртикул: ак5001 \nТариф: 6");
        question1.add("Наименование: \"Повербанк Кот №401\" \nАртикул: ак5004 \nТариф: 6");
        question1.add("Наименование: \"Повербанк КОТЭ №20\" \nАртикул: а10002 \nТариф: 8");
        question1.add("Наименование: \"Повербанк КОТЭ №30\" \nАртикул: а10003 \nТариф: 8");
        header_details.put("Адрес: Москва, Авиамоторная улица, д. 5 \nИндекс: 111020 \nКоордината широта: 55.762520 \nКоордината долгота: 37.709784", question1);
        List<String> question2 = new ArrayList<>();
        question2.add("Наименование: \"Повербанк Альфа №100\" \nАртикул: ак2001 \nТариф: 5");
        question2.add("Наименование: \"Повербанк Альфа №400\" \nАртикул: ак2004 \nТариф: 5");
        question2.add("Наименование: \"Повербанк Кот №201\" \nАртикул: ак5002 \nТариф: 6");
        question2.add("Наименование: \"Повербанк Кот №301\" \nАртикул: ак5003 \nТариф: 6");
        header_details.put("Адрес: Москва, 2-й Автозаводский проезд, 1/9 \nИндекс: 115280 \nКоордината широта: 55.706959 \nКоордината долгота: 37.658536", question2);
        List<String> question3 = new ArrayList<>();
        question1.add("Наименование: \"Повербанк КОТЭ №80\" \nАртикул: а10008 \nТариф: 8");
        question3.add("Наименование: \"Повербанк Кот №501\" \nАртикул: ак5005 \nТариф: 6");
        question3.add("Наименование: \"Повербанк Альфа №200\" \nАртикул: ак2002 \nТариф: 5");
        header_details.put("Адрес: Москва, улица Народного Ополчения, 45 \nИндекс: 123060 \nКоордината широта: 55.792842 \nКоордината долгота: 37.491521", question3);
        List<String> question4 = new ArrayList<>();
        question4.add("Наименование: \"Повербанк КОТЭ №50\" \nАртикул: а10005 \nТариф: 8");
        question4.add("Наименование: \"Повербанк КОТЭ №40\" \nАртикул: а10004 \nТариф: 8");
        question4.add("Наименование: \"Повербанк КОТЭ №10\" \nАртикул: а10001 \nТариф: 8");
        header_details.put("Адрес: Москва, Дмитровское шоссе, 13к1 \nИндекс: 127434 \nКоордината широта: 55.818129 \nКоордината долгота: 37.573214", question4);


        return header_details;

    }


}