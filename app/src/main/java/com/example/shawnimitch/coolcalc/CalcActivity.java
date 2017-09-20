package com.example.shawnimitch.coolcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    TextView resultView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String runNum = "";
    String leftVal = "";
    String rightVal = "";

    Operation currOp;
    int result = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        ImageButton eqlBtn = (ImageButton)findViewById(R.id.eqlBtn);
        ImageButton divBtn = (ImageButton)findViewById(R.id.divBtn);
        ImageButton multBtn = (ImageButton)findViewById(R.id.multBtn);
        ImageButton subBtn = (ImageButton)findViewById(R.id.subBtn);
        ImageButton addBtn = (ImageButton)findViewById(R.id.addBtn);

        Button clrBtn = (Button) findViewById(R.id.clrBtn);
        resultView = (TextView) findViewById(R.id.ResultText);

        resultView.setText("0");

        oneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(1);

            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(2);

            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(3);

            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(4);

            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(5);

            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(6);

            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(7);

            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(8);

            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(9);

            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numPressed(0);

            }
        });

        eqlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.EQUAL);

            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.DIVIDE);

            }
        });

        multBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.MULTIPLY);

            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.SUBTRACT);


            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processOperation(Operation.ADD);

            }
        });

        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftVal = "";
                rightVal = "";
                result = 0;
                runNum = "";
                currOp = null;
                resultView.setText("0");
            }
        });

    }

    void processOperation(Operation operation) {

        if(currOp != null ) {
            if(runNum != ""){
                rightVal = runNum;
                runNum = "";

                switch (currOp) {
                    case ADD:
                        result = Integer.parseInt(leftVal) + Integer.parseInt(rightVal);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftVal) - Integer.parseInt(rightVal);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftVal) * Integer.parseInt(rightVal);
                        break;
                    case  DIVIDE:
                        result = Integer.parseInt(leftVal) / Integer.parseInt(rightVal);
                        break;
                }

                leftVal = String.valueOf(result);
                resultView.setText(leftVal); //current value that we just calculated

            }
            currOp = operation; //store the current operation with operation that was just selected
        } else {
            leftVal = runNum;
            runNum = "";
        }
        currOp = operation;
    }

    void numPressed(int num) {
        runNum += String.valueOf(num);
        resultView.setText(runNum);

    }
}
