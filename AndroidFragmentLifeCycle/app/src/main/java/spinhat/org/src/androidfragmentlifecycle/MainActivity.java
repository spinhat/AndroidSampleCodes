package spinhat.org.src.androidfragmentlifecycle;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


// Ref : http://examples.javacodegeeks.com/android/core/app/fragment/android-fragments-example

public class MainActivity extends ActionBarActivity {
    private static final int MATCH_PARENT = LinearLayout.LayoutParams.WRAP_CONTENT;
    private Fragment fr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_go_fragment_one = (Button)findViewById(R.id.btn_fragment_one);
        Button btn_go_fragment_two = (Button)findViewById(R.id.btn_fragment_two);
        Button btn_next_activity = (Button)findViewById(R.id.btn_next_activity);
        Button btn_remove = (Button)findViewById(R.id.btn_remove);


        btn_go_fragment_one.setOnClickListener(new myOnClickListener());
        btn_go_fragment_two.setOnClickListener(new myOnClickListener());
        btn_next_activity.setOnClickListener(new myOnClickListener());
        btn_remove.setOnClickListener(new myOnClickListener());
    }

    private class myOnClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btn_fragment_one:
                    fr = new FragmentOne();
                    break;
                case R.id.btn_fragment_two:
                    fr = new FragmentTwo();
                    break;
                case R.id.btn_remove:
                    if (fr != null) {
                        FragmentManager fm = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.remove(fr);
                        fragmentTransaction.commit();
                    }
                    break;
                case R.id.btn_next_activity:
                    Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                    startActivity(intent);
                    break;
            }
            if (fr != null)
            {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_position, fr);
//                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        }
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
