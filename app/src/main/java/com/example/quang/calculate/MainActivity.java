package com.example.quang.calculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    Bundle bundle;
    EditText edtNhapA;
    EditText edtNhapB;
    EditText edtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initiation
        edtNhapA = (EditText) findViewById(R.id.edtNhapA);
        edtNhapB = (EditText) findViewById(R.id.edtNhapB);
        edtResult = (EditText) findViewById(R.id.edtResult);

        Button btnOK = (Button) findViewById(R.id.btnOK);
        Button btnCancel = (Button) findViewById(R.id.btnCancel);




        //Process




        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, CalculationActivity.class);
                bundle = new Bundle();
                bundle.putString("A",edtNhapA.getText().toString());
                bundle.putString("B",edtNhapB.getText().toString());
                intent.putExtra("Data",bundle);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent() != null && getIntent().getBundleExtra("Data") != null ) {
            intent = getIntent();
            bundle = intent.getBundleExtra("Data");
            edtResult.setText(bundle.getString("A".toString()) + bundle.getString("Cal".toString()) + bundle.getString("B".toString()) + "=" + bundle.getString("Result".toString()));
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
