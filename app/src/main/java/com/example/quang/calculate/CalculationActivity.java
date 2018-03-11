package com.example.quang.calculate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation_layout);

        final EditText edtNhapA = (EditText) findViewById(R.id.edtNhapA);
        final EditText edtNhapB = (EditText) findViewById(R.id.edtNhapB);
        EditText edtResult = (EditText) findViewById(R.id.edtResult);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnMud = (Button) findViewById(R.id.btnMud);

        //Process
        final Intent intent = getIntent();
        final Bundle bundle = intent.getBundleExtra("Data");
        edtNhapA.setText(bundle.getString("A".toString()));
        edtNhapB.setText(bundle.getString("B".toString()));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(edtNhapA.getText().toString()) + Integer.parseInt(edtNhapB.getText().toString());
                bundle.putString("Cal", "+");
                bundle.putString("Result",result + "");
                intent.setClass(CalculationActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btnMud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = Integer.parseInt(edtNhapA.getText().toString()) - Integer.parseInt(edtNhapB.getText().toString());
                bundle.putString("Cal", "-");
                bundle.putString("Result",result + "");
                intent.setClass(CalculationActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }
}
