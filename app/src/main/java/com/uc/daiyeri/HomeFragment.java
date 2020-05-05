package com.uc.daiyeri;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private myDbAdapter db;
    private List<User> not = new ArrayList<>();
    private RecycleAdapter adapter;
    FloatingActionButton button_add;
    RecyclerView recyclerView;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);

        db = new myDbAdapter(getActivity());
        recyclerView= view.findViewById(R.id.rv);

        not = db.allPlayers();
        if (not.isEmpty()){
            Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
        }
        else{
            Log.e("main-list", not.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new RecycleAdapter(getActivity(), not);
            recyclerView.setAdapter(adapter);
        }


        button_add = (FloatingActionButton) view.findViewById(R.id.button);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), insert.class), 1);
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        db = new myDbAdapter(getActivity());
        recyclerView= view.findViewById(R.id.rv);

        not = db.allPlayers();
        if (not.isEmpty()){
            Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
        }
        else{
            Log.e("main-list", not.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);

            adapter = new RecycleAdapter(getActivity(), not);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            db = new myDbAdapter(getActivity());
            recyclerView= view.findViewById(R.id.rv);

            not = db.allPlayers();
            if (not.isEmpty()){
                Toast.makeText(getActivity(),"No Data",Toast.LENGTH_SHORT).show();
            }
            else{
                Log.e("main-list", not.toString());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);

                adapter = new RecycleAdapter(getActivity(), not);
                recyclerView.setAdapter(adapter);
            }


        }
    }
}
