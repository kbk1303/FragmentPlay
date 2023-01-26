package zbc.dk.krik.fragmentplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ValueNotifier {

    EditText multiLine;
    Button callFragmentBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        multiLine = (EditText) findViewById(R.id.editTextTextMultiLine);
        callFragmentBtn = (Button) findViewById(R.id.call_fragment_button);


        callFragmentBtn.setOnClickListener(v -> {

            NotifierFragment notifierFragment = NotifierFragment.newInstance("Hello from Main Activity");

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, notifierFragment);
            transaction.addToBackStack(null);
            transaction.commit();

        });
    }


    @Override
    public void setValue(String value) {
        multiLine.append("Fragment said: " + value +'\n');
    }
}