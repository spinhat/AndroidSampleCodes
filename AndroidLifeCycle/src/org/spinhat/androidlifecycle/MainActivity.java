package org.spinhat.androidlifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onStart");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onResume");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onPause");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onStop");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onDestroy");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("LifeCycle", this.getClass().getSimpleName() + "onCreate");
		TextView tv = (TextView)findViewById(R.id.title_text);
		tv.setText(R.string.main_activity);
		
		Button btn = (Button)findViewById(R.id.sw_next);
		btn.setText(R.string.next);
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent();
				it.setClass(MainActivity.this, SecondActivity.class);
				startActivity(it);
			}
			
		});
	}
}
