package com.example.android_start;

/**
 * �����Ĳ˵�	
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
		// ��activity
		setContentView(R.layout.fragment_main2);
		// ��ȡbutton
		btn1 = (Button) findViewById(R.id.button1);
		// �ڰ�ť��ע�������Ĳ˵�
		registerForContextMenu(btn1);
	}

	// ���������Ĳ˵����¼�����
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		// ����xml�����ļ�
		getMenuInflater().inflate(R.menu.main2, menu);
	}

	// �����Ĵ����¼�
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.start:
			Toast.makeText(this, "��ʼ��������", Toast.LENGTH_SHORT).show();
			break;

		case R.id.over:
			Toast.makeText(this, "������������", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
}
