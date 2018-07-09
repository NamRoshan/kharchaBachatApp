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

public class Delete extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText et_id;
    Button btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        myDb=new DatabaseHelper(this);
        et_id=findViewById(R.id.et_id);
        btn_delete=findViewById(R.id.btn_delete);
        DeleteData();
    }

    public  void DeleteData(){
        btn_delete.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedRows=myDb.deleteData(et_id.getText().toString());
                        if(deletedRows>0){
                            Toast.makeText(Delete.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(Delete.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                        }
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
