package com.example.android_menu;

/**
 * 创建选项菜单
 */
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
private static  final int START_ITEM = Menu.FIRST; 
private static  final int OVER_ITEM = Menu.FIRST+1;
private static final int SET_ITEM1 = Menu.FIRST+2; 
private static final int SET_ITEM2 = Menu.FIRST+3; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

//填充选项菜单（加载XML，解析，加载到MENU组件上）	
//		getMenuInflater().inflate(R.menu.main, menu);
//		添加菜单项（组id，菜单项id，排序，标题）
		menu.add(0, START_ITEM, 100, "开始");
		menu.add(0, OVER_ITEM, 200, "结束");
//		添加子菜单
       SubMenu sunMenu= menu.addSubMenu("设置");
       sunMenu.add(1, SET_ITEM1, 300, "设置壁纸");
       sunMenu.add(1, SET_ITEM2, 400, "设置桌面");
		return true;
	}
//重写onOptionsItemSelected()方法 实现菜单项事件
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case START_ITEM:
//			提示信息
			Toast.makeText(this, "开始游戏", Toast.LENGTH_SHORT).show();
			break;
		case OVER_ITEM:
			Toast.makeText(this, "结束游戏", Toast.LENGTH_SHORT).show();
			break;
		case SET_ITEM1:
			Toast.makeText(this, "设置壁纸", Toast.LENGTH_SHORT).show();
			break;
		case SET_ITEM2:
			Toast.makeText(this, "设置桌面", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
		int id = item.getItemId();
		if (id == R.id.start) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
