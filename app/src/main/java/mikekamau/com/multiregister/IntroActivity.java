package mikekamau.com.multiregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    }


}

