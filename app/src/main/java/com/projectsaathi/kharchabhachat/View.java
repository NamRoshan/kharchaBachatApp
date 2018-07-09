package com.projectsaathi.kharchabhachat;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class View extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText et_item, et_value;
    Button btn_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        myDb = new DatabaseHelper(this);
        et_item = findViewById(R.id.et_item);
        et_value = findViewById(R.id.et_value);
        btn_view = findViewById(R.id.btn_view);
        viewAll();
    }

    public void viewAll() {
        btn_view.setOnClickListener(
                new android.view.View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View view) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            //show message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id:" + res.getString(0) + "\n");
                            buffer.append("Item Name:" + res.getString(1) + "\n");
                            buffer.append("Valuea:" + res.getString(2) + "\n\n");
                        }
                        //show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuHome:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.menuView:
                startActivity(new Intent(this, View.class));
                break;
            case R.id.menuUpdate:
                startActivity(new Intent(this, Update.class));
                break;
            case R.id.menuDelete:
                startActivity(new Intent(this, Delete.class));
                break;
        }
        return true;
    }
}
