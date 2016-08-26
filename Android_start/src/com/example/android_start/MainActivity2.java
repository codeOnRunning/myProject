package com.example.android_start;

/**
 * 上下文菜单	
 */
import com.example.android_start.R;
import com.example.android_start.R.id;
import com.example.android_start.R.menu;

import android.R.layout;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends Activity {
	private Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 绑定activity
		setContentView(R.layout.fragment_main2);
		// 获取button
		btn1 = (Button) findViewById(R.id.button1);
		// 在按钮上注册上下文菜单
		registerForContextMenu(btn1);
	}

	// 创建上下文菜单的事件方法
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// 关联xml布局文件
		getMenuInflater().inflate(R.menu.main2, menu);
	}

	// 上下文触发事件
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.start:
			Toast.makeText(this, "开始。。。。", Toast.LENGTH_SHORT).show();
			break;

		case R.id.over:
			Toast.makeText(this, "结束。。。。", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
}
