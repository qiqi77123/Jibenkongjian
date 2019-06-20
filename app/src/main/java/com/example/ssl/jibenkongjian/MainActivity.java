package com.example.ssl.jibenkongjian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,RadioGroup.OnCheckedChangeListener,
        CompoundButton.OnCheckedChangeListener {
    private CheckBox read,swim,dance,sing;
    private RadioGroup rg;
    private Button sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        read = (CheckBox)findViewById(R.id.Read);
        swim = (CheckBox)findViewById(R.id.Swim);
        dance = (CheckBox)findViewById(R.id.Dance);
        sing = (CheckBox)findViewById(R.id.Sing);
        rg = (RadioGroup) findViewById(R.id.RG);
        sub = (Button) findViewById(R.id.Sub);

        read.setOnCheckedChangeListener(this);
        swim.setOnCheckedChangeListener(this);
        dance.setOnCheckedChangeListener(this);
        sing.setOnCheckedChangeListener(this);

        rg.setOnCheckedChangeListener(this);

        sub.setOnClickListener(this);


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this,buttonView.getText().toString()+":"+isChecked,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton radioButton = (RadioButton)findViewById(checkedId);
        String str = radioButton.getText().toString();
        boolean isChecked=radioButton.isChecked();
        Toast.makeText(this,str+":"+isChecked,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        String str = "";
        str+=read.getText().toString()+":"+read.isChecked()+"\n";
        str+=swim.getText().toString()+":"+swim.isChecked()+"\n";
        str+=dance.getText().toString()+":"+dance.isChecked()+"\n";
        str+=sing.getText().toString()+":"+sing.isChecked()+"\n";

        int checked = rg.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)findViewById(checked);

        str+=radioButton.getText().toString()+":"+radioButton.isChecked();

        Toast.makeText(this,str,Toast.LENGTH_LONG).show();


    }
}
