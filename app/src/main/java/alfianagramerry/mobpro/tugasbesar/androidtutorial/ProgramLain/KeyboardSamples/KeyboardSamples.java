package alfianagramerry.mobpro.tugasbesar.androidtutorial.ProgramLain.KeyboardSamples;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import alfianagramerry.mobpro.tugasbesar.androidtutorial.R;

/**
 * Created by Alfian Hadi Pratama on 26/12/2017.
 */

public class KeyboardSamples extends AppCompatActivity {

    private Toolbar toolbar;

    public void showText(View view) {
        EditText editText = (EditText)findViewById(R.id.editText_main);
        if (editText != null) {
            String showString = editText.getText().toString();
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_samples);
        setTitle("Keyboard Sample");
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
