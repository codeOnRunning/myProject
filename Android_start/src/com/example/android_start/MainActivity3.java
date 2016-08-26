package com.example.android_start;

/**
 * 弹出菜单练习
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
//点击菜单
	public void showPopup(View v) {
		// 创建弹出式菜单对象，最低版本是11
		PopupMenu popUp = new PopupMenu(this, v);
		// 菜单填充器
		MenuInflater inflater = popUp.getMenuInflater();
		// 填充菜单
		inflater.inflate(R.menu.main3, popUp.getMenu());
		// 设置菜单监听事件
		popUp.setOnMenuItemClickListener(this);
		popUp.show();

	}

	// 添加弹出菜单单击事件
	@Override
	public boolean onMenuItemClick(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.copy:
			Toast.makeText(this, "复制成功！", Toast.LENGTH_SHORT).show();

			break;
		case R.id.del:
			Toast.makeText(this, "删除成功!", Toast.LENGTH_SHORT).show();

			break;
		default:
			break;
		}
		return false;
	}
}
