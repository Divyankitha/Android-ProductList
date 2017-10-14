package com.example.divyankitharaghavaurs.product;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by divyankithaRaghavaUrs on 3/31/17.
 */

public class productNotFoundDialog extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.product_not_found_dialog);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void finishDialogNotFound(View v)
    {
        finish();
    }
}
