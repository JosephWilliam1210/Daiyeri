package com.uc.daiyeri;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class update extends AppCompatActivity {

    public static final String EXTRA_NOTE = "extra";
    private User not;
    private User s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
//        User s;
        if (getIntent().getParcelableExtra(EXTRA_NOTE)!= null){
            s = getIntent().getParcelableExtra(EXTRA_NOTE);
        }
        Toast.makeText(this, s.getNote(), Toast.LENGTH_SHORT).show();
    }
}