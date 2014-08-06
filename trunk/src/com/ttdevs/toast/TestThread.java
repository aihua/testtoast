package com.ttdevs.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

class TestThread extends Thread {
	Handler mHandler;
	Context mContext;

	public TestThread(Context context) {
		mContext = context;
		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);

				Toast.makeText(mContext, "text", Toast.LENGTH_LONG).show();
			}
		};
		System.err.println(mHandler.getLooper() == Looper.getMainLooper());
	}

	@Override
	public void run() {
		mHandler.sendEmptyMessage(0);
	}
}