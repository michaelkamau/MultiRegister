package mikekamau.com.multiregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mikekamau on 3/20/18.
 */

class NamesActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private Button btnContinue;
    private TextView fNameError;
    private TextView lNameError;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        firstName = findViewById(R.id.et_first_name);
        lastName = findViewById(R.id.et_last_name);
        fNameError = findViewById(R.id.tv_first_name_empty_error);
        lNameError = findViewById(R.id.tv_last_name_empty_error);
        btnContinue = findViewById(R.id.btn_next_from_names);

        fetchNames();

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchPasswordActivity();
            }
        });
    }

    public void launchPasswordActivity() {
        Intent intent = new Intent(this, PasswordActivity.class);
        startActivity(intent);
    }

    public void fetchNames() {
        String fName = fetchFirstName();
        String lName = fetchLastName();
        UserInfo.user.setLastName(lName);
        UserInfo.user.setFirstName(fName);
        btnContinue.setEnabled(true);
    }

    private String fetchLastName() {
        String lName;
        while (true) {
            lName = lastName.getText().toString();
            if ("".equals(lName)) {
                lNameError.setVisibility(View.VISIBLE);
                lastName.requestFocus();
            } else {
                lNameError.setVisibility(View.INVISIBLE);
                return lName;
            }
        }
    }

    private String fetchFirstName() {
        String fName;
        while (true) {
            fName = firstName.getText().toString();
            if ("".equals(fName)) {
                fNameError.setVisibility(View.VISIBLE);
                firstName.requestFocus();
            } else {
                fNameError.setVisibility(View.INVISIBLE);
                return fName;
            }
        }
    }


}
