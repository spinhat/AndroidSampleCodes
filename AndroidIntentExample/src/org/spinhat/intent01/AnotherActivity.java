package org.spinhat.intent01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.another);
		TextView tv = (TextView)findViewById(R.id.title_text);
		tv.setText(R.string.sec_title_txt);
		
		Button btn = (Button)findViewById(R.id.btn);
		btn.setText("Back");
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	public void finish() {
		  // Prepare data intent 
		  Intent data = new Intent();
		  data.putExtra("returnKey1", "Swinging on a star. ");
		  data.putExtra("returnKey2", "You could be better then you are. ");
		  // Activity finished ok, return the data
		  setResult(RESULT_OK, data);
		  super.finish();
	} 
}
