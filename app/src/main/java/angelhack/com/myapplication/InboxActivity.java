package angelhack.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 21/5/2016.
 */
public class InboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inbox);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }

    }

}
