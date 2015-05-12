package org.spinhat.intent01;
import org.spinhat.intent01.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	final int REQUEST_CODE = 100;
	 private Spinner spinner;

	  
	 /** Called when the activity is first created. */

	   @Override
	   public void onCreate(Bundle savedInstanceState) {
		   super.onCreate(savedInstanceState);
		   setContentView(R.layout.main);
		   spinner = (Spinner) findViewById(R.id.spinner);
		   ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.intents, android.R.layout.simple_spinner_item); 
		   adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner.setAdapter(adapter);
	   }

	   public void onClick(View view) {
		   int position = spinner.getSelectedItemPosition();
		   Intent intent = null;
		   switch (position) {
		   case 0:
			   intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
			   break;
	       case 1:
	    	   intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:(+49)12345789"));
	    	   break;
	       case 2:
	    	   intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+49)12345789"));
	    	   startActivity(intent);
	    	   break;
	       case 3:
	    	   intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
	    	   break;
	       case 4:
	    	   intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=query"));
	    	   break;
	       case 5:
	    	   intent = new Intent("android.media.action.IMAGE_CAPTURE");
	    	   break;
	       case 6:
	    	   intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
	    	   break;
	       case 7:
	    	   intent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
	    	   break;
	       case 8:
	    	   intent = new Intent(MainActivity.this, AnotherActivity.class);
	    	   break;
	     }
	     if (intent != null && position != 8) 
	     {
	    	 startActivity(intent);
	     }
	     else
	     {
	    	 startActivityForResult(intent, 0);
	     }
	   }

	   @Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	     if (resultCode == Activity.RESULT_OK && requestCode == 0) {
	    	 String result = data.toURI();
	    	 Toast.makeText(this, result, Toast.LENGTH_LONG);
	       
	    	 if (data.hasExtra("returnKey1")) {
	    		 Toast.makeText(this, data.getExtras().getString("returnKey1"), Toast.LENGTH_SHORT).show();
	    	 }
	    	 
	    	 if (data.hasExtra("returnKey2")) {
		    	Toast.makeText(this, data.getExtras().getString("returnKey2"),
		        Toast.LENGTH_SHORT).show();
	    	 }
	     }
	 }


}
