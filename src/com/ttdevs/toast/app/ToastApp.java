package com.ttdevs.toast.app;

import com.ttdevs.toast.custom.ToastUtil;

import android.app.Application;
import android.os.Looper;

public class ToastApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		ToastUtil.init(getApplicationContext());
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				Looper.prepare();
//				ToastUtil.init(getApplicationContext());
//				Looper.loop();
//			}
//		}).start();
	}
}
