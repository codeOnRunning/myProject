package com.example.android_menu;

/**
 * ����ѡ��˵�
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

//���ѡ��˵�������XML�����������ص�MENU����ϣ�	
//		getMenuInflater().inflate(R.menu.main, menu);
//		��Ӳ˵����id���˵���id�����򣬱��⣩
		menu.add(0, START_ITEM, 100, "��ʼ");
		menu.add(0, OVER_ITEM, 200, "����");
//		����Ӳ˵�
       SubMenu sunMenu= menu.addSubMenu("����");
       sunMenu.add(1, SET_ITEM1, 300, "���ñ�ֽ");
       sunMenu.add(1, SET_ITEM2, 400, "��������");
		return true;
	}
//��дonOptionsItemSelected()���� ʵ�ֲ˵����¼�
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case START_ITEM:
//			��ʾ��Ϣ
			Toast.makeText(this, "��ʼ��Ϸ", Toast.LENGTH_SHORT).show();
			break;
		case OVER_ITEM:
			Toast.makeText(this, "������Ϸ", Toast.LENGTH_SHORT).show();
			break;
		case SET_ITEM1:
			Toast.makeText(this, "���ñ�ֽ", Toast.LENGTH_SHORT).show();
			break;
		case SET_ITEM2:
			Toast.makeText(this, "��������", Toast.LENGTH_SHORT).show();
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
