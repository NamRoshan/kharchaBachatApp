package com.projectsaathi.kharchabhachat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText et_item,et_value;
    Button btn_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb=new DatabaseHelper(this);
        et_item=findViewById(R.id.et_item);
        et_value=findViewById(R.id.et_value);
        btn_add=findViewById(R.id.btn_add);
        AddData();
    }
    public void AddData(){
        btn_add.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        boolean isInserted= myDb.insertData(et_item.getText().toString(),
                                et_value.getText().toString());
                        if(isInserted ==true){
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                        }
                        et_value.setText("");
                        et_item.setText("");
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.menuHome:
               startActivity(new Intent(this,MainActivity.class));
               break;
           case R.id.menuView:
               startActivity(new Intent(this,View.class));
               break;
           case  R.id.menuUpdate:
               startActivity(new Intent(this,Update.class));
               break;
           case  R.id.menuDelete:
               startActivity(new Intent(this,Delete.class));
               break;
       }
       return true;
    }
}
