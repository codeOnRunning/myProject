package com.myapp.expriment_next;



/**
 * 第二个界面
 */
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity {
	private Button m_btnSecondAct = null;
	private TextView m_txtSecondAct = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("第三个屏幕已经打开");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		m_btnSecondAct = (Button) findViewById(R.id.button1);
		m_txtSecondAct = (TextView) findViewById(R.id.textView1);
		m_btnSecondAct.setOnClickListener(new ButtonListener());

	}

	// 添加按钮监听事件
	class ButtonListener implements
			android.view.View.OnClickListener {
		 
		 @Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ThirdActivity.this,ActivityLife.class);
			ThirdActivity.this.startActivity(intent);
			Toast.makeText(ThirdActivity.this, "已回到主界面", Toast.LENGTH_LONG).show();
		}
	}
}
