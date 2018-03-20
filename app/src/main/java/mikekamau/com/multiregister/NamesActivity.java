package mikekamau.com.multiregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mikekamau on 3/20/18.
 */

public class NamesActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private Button btnContinue;
    private TextView fNameError;
    private TextView lNameError;
    private TextView firstNameLabel;
    private TextView lastNameLabel;
    private boolean properNamesFound = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        firstName = findViewById(R.id.et_first_name);
        lastName = findViewById(R.id.et_last_name);
        fNameError = findViewById(R.id.tv_first_name_empty_error);
        lNameError = findViewById(R.id.tv_last_name_empty_error);
        btnContinue = findViewById(R.id.btn_next_from_names);
        firstNameLabel = findViewById(R.id.tv_first_name_label);
        lastNameLabel = findViewById(R.id.tv_last_name_label);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchPasswordActivity();
            }
        });

        firstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (input.trim().length() == 0) {
                    fNameError.setVisibility(View.VISIBLE);
                    properNamesFound = false;
                    btnContinue.setEnabled(false);
                } else {
                    fNameError.setVisibility(View.INVISIBLE);
                    properNamesFound = true;
                    btnContinue.setEnabled(true);
                }
            }
        });

        lastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (input.trim().length() == 0) {
                    lNameError.setVisibility(View.VISIBLE);
                    properNamesFound = false;
                    btnContinue.setEnabled(false);
                } else {
                    lNameError.setVisibility(View.INVISIBLE);
                    properNamesFound = true;
                    btnContinue.setEnabled(true);
                }
            }
        });
    }

    public void launchPasswordActivity() {
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
    }

    public void fetchNames() {
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        UserInfo.user.setLastName(lName);
        UserInfo.user.setFirstName(fName);
    }

}
