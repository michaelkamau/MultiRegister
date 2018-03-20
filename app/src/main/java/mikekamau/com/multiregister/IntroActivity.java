package mikekamau.com.multiregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Intro screen before user starts registration process
 */
public class IntroActivity extends AppCompatActivity{

    private Button btnStartRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        btnStartRegistration = findViewById(R.id.btn_register);

        btnStartRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchNamesActivity();
            }
        });
    }

    public void launchNamesActivity() {
        Intent intent = new Intent(this, NamesActivity.class);
        startActivity(intent);
    }


}

