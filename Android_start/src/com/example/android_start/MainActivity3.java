package com.example.android_start;

/**
 * �����˵���ϰ
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity3 extends Activity implements OnMenuItemClickListener {
	private Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main3);
	}
//����˵�
	public void showPopup(View v) {
		// ��������ʽ�˵�������Ͱ汾��11
		PopupMenu popUp = new PopupMenu(this, v);
		// �˵������
		MenuInflater inflater = popUp.getMenuInflater();
		// ���˵�
		inflater.inflate(R.menu.main3, popUp.getMenu());
		// ���ò˵������¼�
		popUp.setOnMenuItemClickListener(this);
		popUp.show();

	}

	// ��ӵ����˵������¼�
	@Override
	public boolean onMenuItemClick(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.copy:
			Toast.makeText(this, "���Ƴɹ���", Toast.LENGTH_SHORT).show();

			break;
		case R.id.del:
			Toast.makeText(this, "ɾ���ɹ�!", Toast.LENGTH_SHORT).show();

			break;
		default:
			break;
		}
		return false;
	}
}
