package com.bignerdranch.android.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
private EditText name;
private EditText price;
private Button addBtn;
    private static final String TAG = "AddItemActivity";
     TextWatcher textWatcher=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);
        addBtn=findViewById(R.id.add_btn);
        textWatcher= new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (price.getText().hashCode() == s.hashCode()){
                price.removeTextChangedListener(textWatcher);
                if (price.getText().toString().indexOf("Р")==-1 && !TextUtils.isEmpty(price.getText().toString()) ){
                price.setText(price.getText().toString() +"Р");}

                price.addTextChangedListener(textWatcher);}
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (name.getText().hashCode() == s.hashCode()) {
                    addBtn.setEnabled(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(price.getText().toString()));

                }
                else if (price.getText().hashCode() == s.hashCode()) {
                    addBtn.setEnabled(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(name.getText().toString()));


                }
            }
        };
        name.addTextChangedListener(textWatcher);
        price.addTextChangedListener(textWatcher);
    }
}
