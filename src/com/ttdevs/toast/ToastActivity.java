package com.ttdevs.toast;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_toast);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btOne:
			customToast();
			break;
		case R.id.btTwo:
			showOneToast();
			break;
		case R.id.btThree:
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Looper.prepare();
					Toast.makeText(getApplicationContext(), "sss", Toast.LENGTH_LONG).show();
					try {
						while(true){
							Thread.sleep(1000);
						}
					} catch (Exception e) {
					}
					Looper.loop();
				}
			}).start();
			break;

		default:
			break;
		}

	}

	
	private void customToast() {
		String msg = String.valueOf(Math.random());

		Toast toast = new Toast(this);
		toast.setGravity(Gravity.CENTER, 20, 50);
		toast.setDuration(5000);
		toast.setMargin(0, 0);

		TextView textView = new TextView(this);
		textView.setTextColor(Color.WHITE);
		textView.setTextSize(18);
		textView.setBackgroundColor(Color.parseColor("#FF000000"));
		textView.setText(msg);

		// R.layout.transient_notification
		// http://cache.baiducontent.com/c?m=9f65cb4a8c8507ed4fece763105392230e54f73e7d868a4e23878448e4380c075a37beed703f474e919b212756b21a00bcb06b29611420c19ddf883ddfac925f2c957669304b9b01459204ef9c07389f73db07aee904a1faa36ed2f5858f994354be0f583cdba4d00b53529132ac033194ecc616011a4dfabb3f25e858073e9f5457b737a7b3256f77caab9a1a5bc25ac7616680ae45f67e41e952ff48476253a13ca60f25313190137ab91f695fc3b81bbc77255723c702ece7&p=9974c54ad5c544e51dabe62d02148f&newp=8a6fc54ad5c544ed09b5872d02148d231610db2151d1da163d85cb5b&user=baidu&fm=sc&query=R%2Elayout%2Etransient_notification+xml&qid=&p1=1
		toast.getView();
		
		toast.setView(textView);
		toast.show();
	}
	
	private Toast mToast;
	private void showOneToast(){
		if(null == mToast){
//			mToast = new Toast(this);
//			mToast.setGravity(Gravity.CENTER, 20, 50);
//			mToast.setDuration(5000);
//			mToast.setMargin(0, 0);
//			mToast.setText("welcome");
			mToast = Toast.makeText(this, "welcome", Toast.LENGTH_SHORT);
			
//			TextView textView = new TextView(this);
//			textView.setTextColor(Color.WHITE);
//			textView.setTextSize(18);
//			textView.setBackgroundColor(Color.parseColor("#FF000000"));
//			textView.setText("welcome");
//			
//			mToast.setView(textView);
		}
		mToast.setText(String.valueOf(Math.random()));
		mToast.show();
	}

}
