package me.minkyu.aspectjsampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import me.minkyu.aspectjsampleapplication.annotations.LogMethodCall;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToastHelloWorld;

    Toast toastInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToastHelloWorld = (Button) findViewById(R.id.main_btn_toast_hello_world);
        btnToastHelloWorld.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        toastHelloWorld();
    }

    @LogMethodCall
    private void toastHelloWorld() {
        if (toastInstance == null) {
            toastInstance = Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_SHORT);
        }

        toastInstance.show();
    }
}
