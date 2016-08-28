package com.myapp.android_dialog;

/**
 * �Ի������ϰ
 */
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Dialog extends Activity implements OnClickListener {
	private Button btn1;
	private Button btn2;
	private Button btn3;
	private Button btn4;
	private Button btn5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_dialog);
		// ��ȡ��ʾ��ť
		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(this);
		// ��ȡ��ͨ�Ի���ť
		btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		// ��ȡ��ѡ��ť
		btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(this);
		// ��ȡ��ѡ��
		btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(this);
		// �Զ���Ŀ�
		btn5 = (Button) findViewById(R.id.button5);
		btn5.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialog, menu);
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

	// ��Ӱ�ť�����¼�
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// �������÷�ʽ
		// case android.R.id.button1:
		case R.id.button1:
			createAlertDialog1();
			break;
		case R.id.button2:
			createAlertDialog2();
			break;
		case R.id.button3:
			createAlertDialog3();
			break;
		case R.id.button4:
			createAlertDialog4();
			break;
		case R.id.button5:
			createAlertDialog5();
			break;

		default:
			break;
		}
	}

	// �Զ�����ı���ť
	private void createAlertDialog5() {
		// ����һ��AlertDialog�Ĺ�����
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("��¼");
		builder.setIcon(android.R.drawable.ic_dialog_info);
		// �����Զ�����ͼ
		// �������������
		LayoutInflater layinflater = getLayoutInflater();
		// ʵ���������齨
		final View view = layinflater.inflate(R.layout.login, null);
		builder.setView(view);
		builder.setPositiveButton("��¼", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				EditText et_username = (EditText) view.findViewById(R.id.editText1_username);
				EditText et_passwoed = (EditText) view.findViewById(R.id.editText2Password);
				String username = et_username.getText().toString();
			    String password = et_passwoed.getText().toString();
			    
			    Toast.makeText(Dialog.this, "�û�����"+username+"---���룺"+password, Toast.LENGTH_SHORT).show();
			    
			}
		});

		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});
		
//		�����ķ���
		builder.setNeutralButton("����", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		builder.show();
	}

	// ��ѡ��ť
	private void createAlertDialog4() {
		// ����һ��AlertDialog�Ĺ�����
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final String[] names = { "��ݮ", "����", "����", "����" };
		builder.setTitle("ˮ��");
		builder.setMultiChoiceItems(names, null,
				new DialogInterface.OnMultiChoiceClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which,
							boolean isChecked) {
						System.out.println("which" + which);
						System.out.println("isSelect" + isChecked);
					}
				});
		builder.show();
	}

	// ��ѡ��ť
	private void createAlertDialog3() {
		// ����һ��AlertDialog�Ĺ�����
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final String[] names = { "��", "��" };
		builder.setTitle("����");
		// -1��ʾ��ʼ״̬ʲô����ѡ
		builder.setSingleChoiceItems(names, -1,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(Dialog.this, names[which],
								Toast.LENGTH_LONG).show();
						// �رյ���
						dialog.dismiss();
					}
				});

		builder.show();
	}

	// ����һ����ͨ�б�Ի���
	private void createAlertDialog2() {
		// ����һ��AlertDialog�Ĺ�����
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("����Ԥ��");
		final String[] names = { "����", "����", "����", "����ת��" };
		builder.setItems(names, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(Dialog.this, names[which], Toast.LENGTH_LONG)
						.show();

			}
		});
		// ��ʾ�Ի���
		builder.show();
	}

	// ����һ����ʾ��Ϣ�Ի���
	private void createAlertDialog1() {
		// ����һ��AlertDialog�Ĺ�����
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("ɾ��");// ���ñ���
		builder.setMessage("�����Ҫɾ����");// ����ɾ����ʾ��Ϣ
		builder.setCancelable(false);// ���õ��������Ƿ�ȡ����ʾ
		// ���ڴ˴��ļ����¼��ӿںͰ�ť�ļ����¼��ӿ�������ͬ�İ�������ֱ���½�������������
		// ������������¼�
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(Dialog.this, "��ȷ��", Toast.LENGTH_LONG).show();
			}
		});
		// ���������¼�
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(Dialog.this, "��ȷ��������ȡ��", Toast.LENGTH_LONG)
						.show();
			}
		});
		builder.show();
	}
}
