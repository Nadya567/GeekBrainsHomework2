package com.example.homework2.ViewUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.homework2.Model.CalculatorImpl;
import com.example.homework2.Model.Operator;
import com.example.homework2.R;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements CalculatorView{

    private TextView textResult;
    private CalculatorPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textResult = findViewById(R.id.text_view);

        presenter = new CalculatorPresenter(this, new CalculatorImpl());


        HashMap<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button_1, 1);
        digits.put(R.id.button_2, 2);
        digits.put(R.id.button_3, 3);
        digits.put(R.id.button_4, 4);
        digits.put(R.id.button_5, 5);
        digits.put(R.id.button_6, 6);
        digits.put(R.id.button_7, 7);
        digits.put(R.id.button_8, 8);
        digits.put(R.id.button_9, 9);
        digits.put(R.id.button_0, 0);

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnDigitPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.button_1).setOnClickListener(digitClickListener);
        findViewById(R.id.button_2).setOnClickListener(digitClickListener);
        findViewById(R.id.button_3).setOnClickListener(digitClickListener);
        findViewById(R.id.button_4).setOnClickListener(digitClickListener);
        findViewById(R.id.button_5).setOnClickListener(digitClickListener);
        findViewById(R.id.button_6).setOnClickListener(digitClickListener);
        findViewById(R.id.button_7).setOnClickListener(digitClickListener);
        findViewById(R.id.button_8).setOnClickListener(digitClickListener);
        findViewById(R.id.button_9).setOnClickListener(digitClickListener);
        findViewById(R.id.button_0).setOnClickListener(digitClickListener);



        HashMap<Integer, Operator> operators = new HashMap<>();
        operators.put(R.id.button_plus, Operator.ADD);
        operators.put(R.id.button_minus, Operator.SUB);
        operators.put(R.id.button_multi, Operator.MULTI);
        operators.put(R.id.button_divide, Operator.DIV);

        View.OnClickListener operatorClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnOperatorPressed(operators.get(view.getId()));
            }
        };

        findViewById(R.id.button_plus).setOnClickListener(operatorClickListener);
        findViewById(R.id.button_minus).setOnClickListener(operatorClickListener);
        findViewById(R.id.button_multi).setOnClickListener(operatorClickListener);
        findViewById(R.id.button_divide).setOnClickListener(operatorClickListener);

        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnClearPressed();
            }
        });


        findViewById(R.id.button_equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.OnEqualPressed();
            }
        });
    }

    @Override
    public void ShowResult(String result) {
        textResult.setText(result);
    }
}