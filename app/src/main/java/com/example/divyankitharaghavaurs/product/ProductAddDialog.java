package com.example.divyankitharaghavaurs.product;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by divyankithaRaghavaUrs on 3/31/17.
 */

public class ProductAddDialog extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product_added_dialog);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void finishDialogadd(View v)
    {
        finish();
    }


}

