package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button bProceed;
    EditText etFirstName, etBirthDay, etAddress, etLastName, etEmail;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButton,radioButton2;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // register buttons with their proper IDs.
        bProceed = findViewById(R.id.proceedButton);

        // register all the EditText fields with their IDs.
        etFirstName = findViewById(R.id.firstName);
        etLastName = findViewById(R.id.lastName);
        etBirthDay = findViewById(R.id.birthDay);
        etAddress = findViewById(R.id.address);
        etEmail = findViewById(R.id.email);
        checkBox= findViewById(R.id.checkBox);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);


        bProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // store the returned value of the dedicated function which checks
                // whether the entered data is valid or if any fields are left blank.
                isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    setContentView(R.layout.success);
                }
            }
        });
    }
    @SuppressLint("ResourceType")
    private boolean CheckAllFields() {
        boolean validate = true;
        if (etFirstName.length() == 0) {
            etFirstName.setError("This field is required");
            validate = false;
        }

        if (etLastName.length() == 0) {
            etLastName.setError("This field is required");
            validate = false;
        }

        if (etBirthDay.length() == 0) {
            etBirthDay.setError("This field is required");
            validate = false;
        }

        if (etAddress.length() == 0) {
            etAddress.setError("This field is required");
            validate = false;
        }

        if (etEmail.length() == 0) {
            etEmail.setError("Email is required");
            validate = false;
        }
        if(!checkBox.isChecked()){
            checkBox.setError("This field is required");
            validate = false;
        }
        if(radioGroup.getCheckedRadioButtonId() <= 0){
            radioButton2.setError("This field is required");
            validate = false;
        }
        // after all validation return true.
        return validate;
    }
}