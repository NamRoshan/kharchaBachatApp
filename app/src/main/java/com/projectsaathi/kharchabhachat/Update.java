package com.projectsaathi.kharchabhachat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText et_item,et_value,et_id;
    Button btn_update;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        myDb=new DatabaseHelper(this);
        et_item=findViewById(R.id.et_item);
        et_id=findViewById(R.id.et_id);
        et_value=findViewById(R.id.et_value);
        btn_update=findViewById(R.id.btn_update);
        UpdateData();
    }
    public void UpdateData(){
        btn_update.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate=myDb.updateData(et_id.getText().toString(),et_item.getText().toString(),et_value.getText().toString());
                        if (isUpdate==true){
                            Toast.makeText(Update.this,"Data Updated",Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(Update.this,"Data not update",Toast.LENGTH_LONG).show();
                        }
                        et_value.setText("");
                        et_item.setText("");
                        et_id.setText("");
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
                startActivity(new Intent(this, com.projectsaathi.kharchabhachat.View.class));
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
