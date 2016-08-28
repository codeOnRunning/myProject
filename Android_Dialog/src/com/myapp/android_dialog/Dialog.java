package com.myapp.android_dialog;

/**
 * 对话框的练习
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
		// 获取提示框按钮
		btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(this);
		// 获取普通对话框按钮
		btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		// 获取单选框按钮
		btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(this);
		// 获取复选框
		btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(this);
		// 自定义的框
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

	// 添加按钮单击事件
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 两种引用方式
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

	// 自定义的文本框按钮
	private void createAlertDialog5() {
		// 创建一个AlertDialog的构建者
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("登录");
		builder.setIcon(android.R.drawable.ic_dialog_info);
		// 设置自定义视图
		// 创建布局填充器
		LayoutInflater layinflater = getLayoutInflater();
		// 实例化布局组建
		final View view = layinflater.inflate(R.layout.login, null);
		builder.setView(view);
		builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				EditText et_username = (EditText) view.findViewById(R.id.editText1_username);
				EditText et_passwoed = (EditText) view.findViewById(R.id.editText2Password);
				String username = et_username.getText().toString();
			    String password = et_passwoed.getText().toString();
			    
			    Toast.makeText(Dialog.this, "用户名："+username+"---密码："+password, Toast.LENGTH_SHORT).show();
			    
			}
		});

		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});
		
//		中立的方法
		builder.setNeutralButton("隐藏", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		builder.show();
	}

	// 复选框按钮
	private void createAlertDialog4() {
		// 创建一个AlertDialog的构建者
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final String[] names = { "草莓", "橘子", "西瓜", "菠萝" };
		builder.setTitle("水果");
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

	// 单选框按钮
	private void createAlertDialog3() {
		// 创建一个AlertDialog的构建者
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		final String[] names = { "开", "关" };
		builder.setTitle("开关");
		// -1表示初始状态什么都不选
		builder.setSingleChoiceItems(names, -1,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(Dialog.this, names[which],
								Toast.LENGTH_LONG).show();
						// 关闭弹窗
						dialog.dismiss();
					}
				});

		builder.show();
	}

	// 创建一个普通列表对话框
	private void createAlertDialog2() {
		// 创建一个AlertDialog的构建者
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("天气预报");
		final String[] names = { "晴天", "阴天", "暴雨", "多云转晴" };
		builder.setItems(names, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(Dialog.this, names[which], Toast.LENGTH_LONG)
						.show();

			}
		});
		// 显示对话框
		builder.show();
	}

	// 创建一个提示信息对话框
	private void createAlertDialog1() {
		// 创建一个AlertDialog的构建者
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("删除");// 设置标题
		builder.setMessage("你真的要删除吗？");// 设置删除提示信息
		builder.setCancelable(false);// 设置弹框外点击是否取消显示
		// 由于此处的监听事件接口和按钮的监听事件接口引自相同的包，所以直接新建匿名监听对象
		// 创建正面监听事件
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(Dialog.this, "已确定", Toast.LENGTH_LONG).show();
			}
		});
		// 创建反面事件
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(Dialog.this, "已确定操作已取消", Toast.LENGTH_LONG)
						.show();
			}
		});
		builder.show();
	}
}
