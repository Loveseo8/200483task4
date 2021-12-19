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
        List<String> answers1 = new ArrayList<>();
        List<String> answers2 = new ArrayList<>();
        List<String> answers3 = new ArrayList<>();
        List<String> answers4 = new ArrayList<>();
        List<String> answers5 = new ArrayList<>();
        List<String> answers6 = new ArrayList<>();
        List<String> answers7 = new ArrayList<>();
        List<String> answers8 = new ArrayList<>();
        answers8.add("Фотографию нужно делять для отчёта по состоянию товара после использования.");
        answers6.add("На товаре есть артикул - идентификационный номер, его и нужно ввести. (Например, ак5005).");
        answers7.add("На товаре есть QR-код (Изображение, состаящее из кучи увадратиков), при начале аренды нужно будет выбрать соотвествующую кнопку и навести на него камеру.");
        answers5.add("На главном экране приложения есть кнопка \"Станции\", нажав на неё, Вы перейдёте к списку всех станций и товаров, которые находятся на них.");
        answers3.add("На главном экране приложения есть кнопка \"Редактировать профиль\", после нажатия на кнопку Вы увидите диалоговое окно, в котором сможете изменить данные в зависимости от Ваших нужд. Поля, которые не требуют изменения, оставьте пустыми.");
        answers2.add("На главном экране приложения есть кнопка \"Обратная связь\", нажав на неё Вы увидете форму, через которую сможете отправить нам сообщение. Введите тему и своё сообщение, нажмите кнопку \"Обратная связь\" и выберите приложение почты удобное для Вас.");
        answers1.add("На главном экране приложения есть кнопка \"История\", нажав на неё Вы сможете посмотреть историю.");
        answers4.add("На главном экране приложения есть кнопка \"Начать аренду\", нажав на неё Вы перейдёте во вкладку, в которой нужно будет указать информацию о товаре, отсканировав QR-код или введя артикул товара. После подтверждения начнётся аренда.");
        header_details.put("Как взять в аренду товар?", answers4);
        header_details.put("Как изменить данные о пользователе?", answers3);
        header_details.put("Как посмотреть доступные в аренду товары рядом со мной?", answers5);
        header_details.put("Где посмотреть историю?", answers1);
        header_details.put("Что значит \"Ввести артикул\"?", answers6);
        header_details.put("Что значит \"Отсканировать QR-код\"?", answers7);
        header_details.put("Зачем мне делать фото?", answers8);
        header_details.put("Как написать жалобу?", answers2);
        header_details.put("Как с вами всязаться?", answers2);

        return header_details;

    }


}