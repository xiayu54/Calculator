package com.example.zcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	Button bt_0;
	Button bt_1;
	Button bt_2;
	Button bt_3;
	Button bt_4;
	Button bt_5;
	Button bt_6;
	Button bt_7;
	Button bt_8;
	Button bt_9;
	Button bt_clear;
	Button bt_divide;
	Button bt_multiply;
	Button bt_del;
	Button bt_minus;
	Button bt_add;
	Button bt_point;
	Button bt_equal;
	
	private TextView tv_input;
	private StringBuilder pending = new StringBuilder();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initview();
	}
	
	

	private void initview() {
		bt_0 = (Button) findViewById(R.id.bt_0);
		bt_1 = (Button) findViewById(R.id.bt_1);
		bt_2 = (Button) findViewById(R.id.bt_2);
		bt_3 = (Button) findViewById(R.id.bt_3);
		bt_4 = (Button) findViewById(R.id.bt_4);
		bt_5 = (Button) findViewById(R.id.bt_5);
		bt_6 = (Button) findViewById(R.id.bt_6);
		bt_7 = (Button) findViewById(R.id.bt_7);
		bt_8 = (Button) findViewById(R.id.bt_8);
		bt_9 = (Button) findViewById(R.id.bt_9);
		bt_clear = (Button) findViewById(R.id.bt_clear);
		bt_divide = (Button) findViewById(R.id.bt_divide);
		bt_multiply = (Button) findViewById(R.id.bt_multiply);
		bt_del = (Button) findViewById(R.id.bt_del);
		bt_minus = (Button) findViewById(R.id.bt_minus);
		bt_add = (Button) findViewById(R.id.bt_add);
		bt_point = (Button) findViewById(R.id.bt_point);
		bt_equal = (Button) findViewById(R.id.bt_equal);
		
		tv_input = (TextView) findViewById(R.id.tv_input);
		
		bt_0.setOnClickListener(this);
		bt_1.setOnClickListener(this);
		bt_2.setOnClickListener(this);
		bt_3.setOnClickListener(this);
		bt_4.setOnClickListener(this);
		bt_5.setOnClickListener(this);
		bt_6.setOnClickListener(this);
		bt_7.setOnClickListener(this);
		bt_8.setOnClickListener(this);
		bt_9.setOnClickListener(this);
		bt_clear.setOnClickListener(this);
		bt_divide.setOnClickListener(this);
		bt_multiply.setOnClickListener(this);
		bt_del.setOnClickListener(this);
		bt_minus.setOnClickListener(this);
		bt_add.setOnClickListener(this);
		bt_point.setOnClickListener(this);
		bt_equal.setOnClickListener(this);
		
	}



	@Override
	public void onClick(View v) {
		int last = 0;
		if (pending.length() != 0) {
			last = pending.codePointAt(pending.length() - 1);
		}
		
		switch (v.getId()) {
		case R.id.bt_0:
			pending = pending.append("0");
			tv_input.setText(pending);
			break;
		case R.id.bt_1:
			pending = pending.append("1");
			tv_input.setText(pending);
			break;
		case R.id.bt_2:
			pending = pending.append("2");
			tv_input.setText(pending);
			break;
		case R.id.bt_3:
			pending = pending.append("3");
			tv_input.setText(pending);
			break;
		case R.id.bt_4:
			pending = pending.append("4");
			tv_input.setText(pending);
			break;
		case R.id.bt_5:
			pending = pending.append("5");
			tv_input.setText(pending);
			break;
		case R.id.bt_6:
			pending = pending.append("6");
			tv_input.setText(pending);
			break;
		case R.id.bt_7:
			pending = pending.append("7");
			tv_input.setText(pending);
			break;
		case R.id.bt_8:
			pending = pending.append("8");
			tv_input.setText(pending);
			break;
		case R.id.bt_9:
			pending = pending.append("9");
			tv_input.setText(pending);
			break;
		case R.id.bt_add:
			pending = pending.append("+");
			tv_input.setText(pending);
			break;
		case R.id.bt_minus:
			pending = pending.append("-");
			tv_input.setText(pending);
			break;
		case R.id.bt_multiply:
			pending.append("*");
			tv_input.setText(pending);
			break;
		case R.id.bt_divide:
			pending = pending.append("/");
			tv_input.setText(pending);
			break; 
		case R.id.bt_point:
//			if (judge1()) {
				pending = pending.append(".");
				tv_input.setText(pending);
//			} else {
//				tv_input.setText("错误");
//			}
			break;
		case R.id.bt_del:
			if (pending.length() != 0) {
				pending = pending.delete(pending.length() - 1, pending.length());
				tv_input.setText(pending);
			}
			break;
		case R.id.bt_clear:
			pending = pending.delete(0, pending.length());
			tv_input.setText(pending);
			break;
		case R.id.bt_equal:
			if (pending.length() > 1) {
				TransToDeal td = new TransToDeal();
				String result;
				try {
					String a = td.toSuffix(pending);
					result = td.dealEquation(a);
				} catch (Exception e) {
					result = "出错";
				}
				tv_input.setText(pending + "=" + "\n" + result);
				
                pending = pending.delete(0, pending.length());
                if (Character.isDigit(result.charAt(0))) {
                    pending = pending.append(result);
                }
	
			}
			break;
		default:
			break;
		}
			
	}
	
	/*
	 * 好像没什么用
	 */
//	public boolean judge1(){
//		char temp = pending.charAt(pending.length()-1);
//		char[] test = {'+', '-', '*', '/'};
//		boolean flag = false;
//		for (int i = 0; i < test.length; i++) {
//			if (temp == test[i]) {
//				flag = false;
//			} else {
//				flag = true;
//			}
//		}
//		return flag;
//	}
//	
	

}
