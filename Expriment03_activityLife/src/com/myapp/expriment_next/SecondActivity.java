package com.myapp.expriment_next;

/**
 * �ڶ�������
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

public class SecondActivity extends Activity {
	private Button m_btnSecondAct = null;
	private TextView m_txtSecondAct = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("�ڶ�����Ļ��");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		m_btnSecondAct = (Button) findViewById(R.id.button1);
		m_txtSecondAct = (TextView) findViewById(R.id.textview2);
		m_btnSecondAct.setOnClickListener(new ButtonListener());

	}

	// ��Ӱ�ť�����¼�
	class ButtonListener implements
			android.view.View.OnClickListener {
		// ActivityLife ac = new ActivityLife();
		 @Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(SecondActivity.this,ActivityLife.class);
			SecondActivity.this.startActivity(intent);
			Toast.makeText(SecondActivity.this, "�ѻص�������", Toast.LENGTH_LONG).show();

		}
	}
}
