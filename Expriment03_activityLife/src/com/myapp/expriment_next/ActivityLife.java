package com.myapp.expriment_next;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 第一个界面
 * 
 * @author Li-Admin
 * 
 */
public class ActivityLife extends Activity {
	private Button m_btnMainAct = null;
	private Button m_btnMainAct3 = null;
	private TextView m_txtxMainAct = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		m_btnMainAct = (Button) findViewById(R.id.button1);
		m_btnMainAct.setOnClickListener(new ButtonListener());
		
		m_txtxMainAct = (TextView) findViewById(R.id.textview2);
		m_btnMainAct3 = (Button) findViewById(R.id.button2);
		m_btnMainAct3.setOnClickListener(new ButtonListener1());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		System.out.println("onDestroy...");
		
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.out.println(" onPause...");
	}

	@Override
	protected void onRestart() {

		super.onRestart();
		System.out.println("onRestart...");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		System.out.println("onResume...");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		System.out.println("onStart...");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		System.out.println("onStop...");
	}
	
//	添加跳转第二个界面按钮监听事件
	class ButtonListener implements  android.view.View.OnClickListener {
         @Override
		public void onClick(View v) {
		Intent intent = new Intent();
		intent.setClass(ActivityLife.this, SecondActivity.class);
		ActivityLife.this.startActivity(intent);
		Toast.makeText(ActivityLife.this, "已转到第二个界面", Toast.LENGTH_LONG).show();

         }

			
		}
//	添加跳转第三个界面按钮监听事件
	class ButtonListener1 implements  android.view.View.OnClickListener {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityLife.this, ThirdActivity.class);
			ActivityLife.this.startActivity(intent);
			Toast.makeText(ActivityLife.this, "已转到第三个界面", Toast.LENGTH_LONG).show();

		}
		
		
	}

	}

