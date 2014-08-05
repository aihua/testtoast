package com.ttdevs.toast;

import com.ttdevs.toast.custom.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public void onClick(View v) {
		// showSystemToast();
		switch (v.getId()) {
		case R.id.btShow:
			showCustomToast();
			break;
		case R.id.btHide:

			break;
		case R.id.btGo:
			startActivity(new Intent(this, ToastActivity.class));
			break;

		default:
			break;
		}
	}

	private void showSystemToast() {
		Toast.makeText(getApplicationContext(), String.valueOf(Math.random()), Toast.LENGTH_LONG).show();
	}

	private void showCustomToast() {
		ToastUtil.show(String.valueOf(Math.random()));
	}
}
