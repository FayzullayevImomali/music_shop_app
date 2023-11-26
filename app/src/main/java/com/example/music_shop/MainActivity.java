package com.example.music_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private Button minusBtn , plusBtn, cardBtn;

    private ImageView goodsImageView;
    private Spinner spinner;
    private HashMap goodsMap;

    private String goodsName;

    private Double price;

    TextView priceTextView;

    ArrayList spinnerArrayList = new ArrayList<>();

    private ArrayAdapter spinnerAdapter;

    private TextView quantityText ;
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();

        loadAction();

    }

    private void spinnerFunc() {

    }

    private void loadAction() {
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 0) {
                    counter--;
                    quantityText.setText(counter.toString());
                    priceTextView.setText(String.valueOf((counter * price)));
                }

            }
        });

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                quantityText.setText(counter.toString());
                priceTextView.setText(String.valueOf((counter * price)));

            }
        });

        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        /*Spinner and Order price functionality*/
        spinner.setOnItemSelectedListener(this);

        spinnerArrayList.add("guitar");
        spinnerArrayList.add("drums");
        spinnerArrayList.add("keyboard");

        spinnerAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);


        goodsMap = new HashMap<>();
        goodsMap.put("guitar", 500.0);
        goodsMap.put("drums", 1500.0);
        goodsMap.put("keyboard", 1000.0);

    }


//    public void increasNumber(){
//        counter++;
//        quantityText.setText(counter.toString());
//    }

//    public void decreasNumber(){
//        if (counter > 0) {
//            counter--;
//            quantityText.setText(counter.toString());
//        }
//    }

    private void loadView() {
        plusBtn = findViewById(R.id.btn_plus);
        minusBtn = findViewById(R.id.btn_minus);
        quantityText = findViewById(R.id.quantity_count);
        cardBtn = findViewById(R.id.card_btn);
        spinner = findViewById(R.id.spinner);
        goodsImageView = findViewById(R.id.goodsImageView);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        goodsName = spinner.getSelectedItem().toString();
        price = (double)goodsMap.get(goodsName);
        priceTextView = findViewById(R.id.order_number);
        priceTextView.setText(String.valueOf((counter * price)));

        if(goodsName.equals("guitar")) {
            goodsImageView.setImageResource(R.drawable.guitar);
        } else if (goodsName.equals("drums")) {
            goodsImageView.setImageResource(R.drawable.drums);
        } else if(goodsName.equals("keyboard")) {
            goodsImageView.setImageResource(R.drawable.keyboard);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}