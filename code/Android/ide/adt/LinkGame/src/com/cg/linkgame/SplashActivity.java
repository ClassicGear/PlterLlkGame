package com.cg.linkgame;

import com.plter.lib.android.java.controls.ArrayAdapter;
import com.plter.linkgame.LinkGameActivity;
import com.plter.linkgame.MainActivity;
import com.plter.linkgame.R;
import com.cg.linkgame.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

public class SplashActivity extends Activity implements AnimationListener{
	private int SPLASH_TIME=3000;
	//SPLASH画面持续时间为2秒。
    private AlphaAnimation aa = new AlphaAnimation(1, 0);
	//淡出效果的动画。
    private ImageView imageView1 = null;
    private ImageView imageView2 = null;
	public void onAnimationStart(Animation animation) {
		//淡出开始后要干什么……
		//目前什么都不干。
	}

	public void onAnimationEnd(Animation animation) {
		//淡出结束后要干什么……
		imageView1.setVisibility(View.GONE);
		new Handler().postDelayed(new Runnable(){

			public void run(){
				Intent mainIntent=new Intent(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(mainIntent);
				SplashActivity.this.finish();
			}
		}, SPLASH_TIME);
	}

	public void onAnimationRepeat(Animation animation) {
		//淡出重复时要干什么……
		//imageView1.setVisibility(View.GONE);
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		imageView1=(ImageView) findViewById(R.id.imageView1);
		imageView2=(ImageView) findViewById(R.id.imageView2);
		aa.setStartTime(1000);
		aa.setDuration(500);
		aa.setAnimationListener(this);
		
		
		
		new Handler().postDelayed(new Runnable(){

			public void run(){
				imageView1.startAnimation(aa);
			}
		}, SPLASH_TIME);
		

    }
	
	
	@Override
	protected void onPause() {
		
	//	if (dialog!=null) {
	//		dialog.dismiss();
	//		dialog=null;
	//	}
		
		super.onPause();
	}
	
}
