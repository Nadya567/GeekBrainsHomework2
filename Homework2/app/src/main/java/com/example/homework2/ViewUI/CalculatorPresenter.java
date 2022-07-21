package com.example.homework2.ViewUI;

import com.example.homework2.Model.Calculator;
import com.example.homework2.Model.Operator;

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    private Double arg1 = 0.0;
    private Double arg2 = null;
    private Operator selectedOperator = Operator.ADD;

    public CalculatorPresenter(CalculatorView view, Calculator calculator)
    {
        this.view = view;
        this.calculator = calculator;
    }

    public void OnDigitPressed(int digit)
    {
        if(arg2 == null)
        {
            arg1 = arg1 * 10 + digit;
            view.ShowResult(String.valueOf(arg1));
        }

        else
        {
            arg2 = arg2 * 10 + digit;
            view.ShowResult(String.valueOf(arg2));
        }

    }

    public void OnOperatorPressed(Operator operator)
    {
        if(selectedOperator != null)
        {
            /*arg1 = calculator.perform(arg1, arg2, selectedOperator);
            view.ShowResult(String.valueOf(arg1));*/
        }

        selectedOperator = operator;
        view.ShowResult(String.valueOf(selectedOperator));
        arg2 = 0.0;

    }

    public void OnClearPressed()
    {
        arg1 = 0.0;
        arg2 = null;
        selectedOperator = null;
        view.ShowResult(" ");
    }

    public void OnEqualPressed()
    {
        arg1 = calculator.perform(arg1, arg2, selectedOperator);
        view.ShowResult(String.valueOf(arg1));
    }

}
