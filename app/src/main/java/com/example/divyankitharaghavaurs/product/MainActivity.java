package com.example.divyankitharaghavaurs.product;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void gotoInsertActivity(View V)
    {
        Intent intent = new Intent(MainActivity.this,insertActivity.class);
        startActivity(intent);
    }

    public void gotoSearchActivity(View V)
    {
        Intent intent = new Intent(MainActivity.this,searchActivity.class);
        startActivity(intent);
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

    void finishActivity(View V)
    {
        MainActivity.this.finish();

    }


}
