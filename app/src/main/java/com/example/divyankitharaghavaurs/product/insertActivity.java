package com.example.divyankitharaghavaurs.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static java.lang.Integer.parseInt;

/**
 * Created by divyankithaRaghavaUrs on 3/29/17.
 */

public class insertActivity extends Activity
{
    database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
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

    public void insert(View V)
    {
        Log.d("Debug -->", "inside insert function of insert activity");

        EditText n =(EditText)findViewById(R.id.name);
        EditText d = (EditText)findViewById(R.id.description);
        EditText p = (EditText)findViewById(R.id.price);
        EditText r = (EditText)findViewById(R.id.review);

        String name= n.getText().toString();
        String description = d.getText().toString();
        String review = r.getText().toString();
        int price = parseInt(p.getText().toString());

        boolean result = mydb.insertProduct(name,description,price,review);
        if(result)
        {
            Log.d("Debug -->", "result =" + result);
            Intent intent = new Intent(insertActivity.this, ProductAddDialog.class);
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

    void finishInsertActivity(View V)
    {
        insertActivity.this.finish();

    }
}
