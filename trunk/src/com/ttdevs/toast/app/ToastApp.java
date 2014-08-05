package com.ttdevs.toast.app;

import com.ttdevs.toast.custom.ToastUtil;

import android.app.Application;

public class ToastApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		ToastUtil.init(getApplicationContext());
	}
}
