package com.ttdevs.toast;

import com.ttdevs.toast.custom.ToastUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	// 需求：android 4.0以后，新增了一个功能：关闭应用发出的通知、Toast等。具体操作为：打开应用安装列表，找到要屏蔽的应用(长按通知，点击弹出的"应用信息"，即可跳到应用信息界面)，把允许推送消息(显示通知)取消即可。产品发现这个功能之后，果断要求屏蔽这个功能。能力有限，不知道如何破屏蔽通知，自己实现一个Toast的还是小case的～～
	// 分析：Toast的实现很快想到两种方案，Dialog和浮窗(WindowManager)。Dialog怀疑代价可能比较大，因此没有去尝试，直接来看浮窗，最后发现Toast也是用浮窗实现的。
	// 想到了用浮窗，就比较简单了，拿到WindowManager然后addView/removeView即可。重新实现就想的更好一些，怎样调用更方便，最简单就直接提供个静态方法吧。还有最关键的一点可能就是Toast的显示策略问题，没有细细去研究，紧凭观察猜测下，不一定对哈：1、相同的消息，会取消之前的，最后一个会显示指定时间；2、显示时间只能使用指定的两种，自己设置了无效；3、支持自定义显示内容。
	// 自己实现就不一定非得按照原始的样子了。
	
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
