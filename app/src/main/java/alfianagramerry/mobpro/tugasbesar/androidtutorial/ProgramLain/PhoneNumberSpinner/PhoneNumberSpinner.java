package alfianagramerry.mobpro.tugasbesar.androidtutorial.ProgramLain.PhoneNumberSpinner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import alfianagramerry.mobpro.tugasbesar.androidtutorial.R;

public class PhoneNumberSpinner extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private static final String TAG = PhoneNumberSpinner.class.getSimpleName();
    private String mSpinnerLabel = "";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_spinner);
        setTitle("Phone Number Spinner");
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //	Create	the	spinner.
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Log.d(TAG, "onNothingSelected:	");

    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.editText_main);
        if (editText != null) {
            String showString = (editText.getText().toString() + "	-	" + mSpinnerLabel);
            TextView phonenumberResult =
                    (TextView) findViewById(R.id.text_phonelabel);
            if (phonenumberResult != null)
                phonenumberResult.setText(showString);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.git_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.github:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/merrymarst/KeyboardSamples/"));
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
