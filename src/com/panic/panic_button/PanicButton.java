package com.panic.panic_button;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PanicButton extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panic_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_panic_button, menu);
        return true;
    }
}
