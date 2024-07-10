package com.example.myjavaroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myjavaroomdb.roomDB.Adapter;
import com.example.myjavaroomdb.roomDB.Student;
import com.example.myjavaroomdb.roomDB.StudentDB;
import com.example.myjavaroomdb.roomDB.StudentDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnSave;

    private StudentDB studentDB;
    private StudentDao studentDao;

    private Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etName = findViewById(R.id.etName);
        btnSave = findViewById(R.id.btnSave);
        recyclerView = findViewById(R.id.recyclerview);



        studentDB = StudentDB.getInstance(this);
        studentDao = studentDB.getDao();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                Student student = new Student(0,name,email);
                studentDao.insert(student);
                etName.setText("");
                etEmail.setText("");
                adapter.addStudent(student);

                Toast.makeText(MainActivity.this,"Data Insert",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void fetchData(){
        List<Student> student = studentDao.getAll();

        adapter = new Adapter(this,student);
        recyclerView.setAdapter(adapter);

    }

}