package com.example.nabintaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtsal;
    private Button btncalc;
    private TextView tvTotalSalary, tvTotalTax;
    private Float salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtsal=findViewById(R.id.edtsal);
        btncalc=findViewById(R.id.btncalc);
        tvTotalSalary=findViewById(R.id.tvTotalSalary);
        tvTotalTax=findViewById(R.id.tvTotalTax);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation() == true) {
                    salary = Float.parseFloat(edtsal.getText().toString());
                    NabinTaxCalculate tax = new NabinTaxCalculate(salary);
                    tvTotalSalary.setText(Float.toString(tax.getTotalSalary()));
                    tvTotalTax.setText(Float.toString(tax.calculate()));
                }
            }
        });


    }
    public Boolean Validation(){
        if (TextUtils.isEmpty(edtsal.getText())){
            edtsal.requestFocus();
            edtsal.setError("Please enter your salary");
            return false;
        }
        return  true;
    }
}
