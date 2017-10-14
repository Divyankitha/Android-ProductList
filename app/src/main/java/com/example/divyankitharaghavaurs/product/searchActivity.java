package com.example.divyankitharaghavaurs.product;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by divyankithaRaghavaUrs on 3/29/17.
 */

public class searchActivity extends Activity
{
    database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        mydb = new database(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void search(View v)
    {
        EditText k = (EditText)findViewById(R.id.key);
        String key = k.getText().toString();
        TextView display = (TextView) findViewById(R.id.display);

        /*int rows = mydb.numberOfRows();
        display.append("\n");
        Log.d("Debug -->", "back from number of rows");
        display.append(String.valueOf(rows));*/

       /* ArrayList array_list = mydb.getAllCotacts();
        Log.d("Debug -->", "back from all");
        int j=0;
        while(array_list.size()>j)
        {
            display.append(String.valueOf(array_list.get(j)));
            display.append("\n");
            j++;
        }*/

        display.setMovementMethod(new ScrollingMovementMethod());
        display.setText(" Search results will appear below:");

        Cursor rs = mydb.getData(key);
        if(rs.getCount() > 0)
        {

            rs.moveToFirst();
            do {
                String nam = rs.getString(rs.getColumnIndex("Name"));
                String rev = rs.getString(rs.getColumnIndex("Review"));
                String des = rs.getString(rs.getColumnIndex("Description"));
                int pri = rs.getInt(rs.getColumnIndex("Price"));
                display.append("\n");
                display.append("-------------------------------------");
                display.append("\n");
                display.append(" Name: " + nam);
                display.append("\n");
                display.append(" Description: " + des);
                display.append("\n");
                display.append(" Price: $" + String.valueOf(pri));
                display.append("\n");
                display.append(" Review: " + rev);
            } while (rs.moveToNext());
        }
        else
        {
            Log.d("Debug -->", "error out of bound");
            display.setText(" Search results will appear below:");
            Intent intent = new Intent(searchActivity.this, productNotFoundDialog.class);
            startActivity(intent);
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    void finishSearchActivity(View V)
    {
        searchActivity.this.finish();

    }
}
