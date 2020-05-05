package com.uc.daiyeri;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class insert extends AppCompatActivity implements TextWatcher{

    Toolbar toolbar;
    TextInputLayout inputTitle, inputNote;
    Button button_save;
    myDbAdapter helper;
    String title,note;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        inputTitle = findViewById(R.id.input_title);
        inputNote = findViewById(R.id.input_note);
        button_save = findViewById(R.id.button_save);

        helper = new myDbAdapter(this);

        inputTitle.getEditText().addTextChangedListener((TextWatcher) this);
        inputNote.getEditText().addTextChangedListener(this);


        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button_save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        title = inputTitle.getEditText().getText().toString().trim();
                        note = inputNote.getEditText().getText().toString().trim();
                        long id = helper.insertData(title,note);
                        finish();
                    }
                    });
        }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void finish() {
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        super.finish();
    }
}
