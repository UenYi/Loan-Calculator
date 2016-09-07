package com.uenyihung.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private EditText loanAmount, loanTerm, yearlyRate;
    private TextView monthlyPayment, totalPayment, totalInterest,errorMsg;
    private LoanCalculator loanCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanAmount = (EditText)findViewById(R.id.loan_input);
        loanTerm = (EditText)findViewById(R.id.loan_term_input);
        yearlyRate = (EditText) findViewById(R.id.yearly_rate_input);

        monthlyPayment = (TextView)findViewById(R.id.monthly_payment_output);
        totalPayment= (TextView)findViewById(R.id.total_payment_output);
        totalInterest= (TextView)findViewById(R.id.total_interest_output);

        errorMsg = (TextView)findViewById(R.id.ErrorMsg);
    }

  public void onCalculate (View view){
      errorMsg.setVisibility(TextView.INVISIBLE);
      try {
          double amount = Double.parseDouble(loanAmount.getText().toString());
          int year = Integer.parseInt(loanTerm.getText().toString());
          double rate = Double.parseDouble(yearlyRate.getText().toString());

          loanCalculator = new LoanCalculator(amount, year, rate);

          monthlyPayment.setText(loanCalculator.getMonthlyPayment() + "");
          totalPayment.setText(loanCalculator.getTotalCostOfLoan() + "");
          totalInterest.setText(loanCalculator.getTotalInterest() + "");
      }catch(Exception e) {
          errorMsg.setVisibility(TextView.VISIBLE);
          }

  }

    public void onClear(View view){
        loanAmount.setText("");
        loanTerm.setText("");
        yearlyRate.setText("");
        monthlyPayment.setText("");
        totalPayment.setText("");
        totalInterest.setText("");
    }
}
