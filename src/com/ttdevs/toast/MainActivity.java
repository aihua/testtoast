package com.ttdevs.toast;

import com.ttdevs.toast.custom.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	// 需求：android 4.0以后，新增了一个功能：关闭应用发出的通知、Toast等。具体操作为：打开应用安装列表，找到要屏蔽的应用(长按通知，点击弹出的"应用信息"，即可跳到应用信息界面)，把允许推送消息取消即可。产品发现这个功能之后，果断要求屏蔽这个功能。能力有限，不知道如何破屏蔽通知，自己实现一个Toast的还是小case的～～
	// 分析：Toast的实现很快想到两种方案，dialog和浮窗。dialog怀疑代价可能比较大，因此没有去尝试，直接来看浮窗。
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
