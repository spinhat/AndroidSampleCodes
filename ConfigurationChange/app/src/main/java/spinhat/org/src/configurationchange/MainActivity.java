package spinhat.org.src.configurationchange;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView title = null;
    EditText inputbox = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i("Config-Change : ", "onCreate");
        title = (TextView)findViewById(R.id.title);
        inputbox = (EditText)findViewById(R.id.inputbox);
        if (savedInstanceState != null)
        {
            Log.i("Config-Change : ", "onCreate: Restore State in onCreate");
            CharSequence str = savedInstanceState.getCharSequence("title");
            title.setText(str);
        }

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText(inputbox.getText());
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        CharSequence str = savedInstanceState.getCharSequence("title");
        Log.i("Config-Change : ", "onRestoreInstanceState: " + str);
        title.setText(str);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Config-Change : ", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Config-Change : ", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Config-Change : ", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Config-Change : ", "onResume");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence str = title.getText();
        Log.i("Config-Change : ", "onSaveInstanceState: " + str);
        outState.putCharSequence("title", str);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Config-Change : ", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Config-Change : ", "onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
