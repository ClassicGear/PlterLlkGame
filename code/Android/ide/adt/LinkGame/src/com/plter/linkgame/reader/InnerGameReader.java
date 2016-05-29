package com.plter.linkgame.reader;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

public class InnerGameReader {

	
	public static GamePkg readGame(Context context,String configFile){
		try {
			InputStream is = context.getAssets().open(configFile);
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			String content=new String(bytes,"utf-8");
			is.close();
			
			JSONObject jsonObject=new JSONObject(content);
			//read name
			String name = jsonObject.getString("name");
			//read bg
			is=context.getAssets().open(jsonObject.getString("background"));
			Bitmap backgroundBitmap = BitmapFactory.decodeStream(is);
			is.close();
			//read pictures
			JSONArray picsJsonArr = jsonObject.getJSONArray("pictures");
			Picture[] pictures = new Picture[picsJsonArr.length()];
			for (int i = 0; i < pictures.length; i++) {
				is = context.getAssets().open(picsJsonArr.getString(i));
				pictures[i]=new Picture(BitmapFactory.decodeStream(is));
				is.close();
			}
			//
			//read backgrounds读取一组背景图片
			JSONArray bgsJsonArr = jsonObject.getJSONArray("backgrounds");
			Background[] backgrounds = new Background[bgsJsonArr.length()];
			for (int i = 0; i < backgrounds.length; i++) {
				is = context.getAssets().open(bgsJsonArr.getString(i));
				backgrounds[i]=new Background(BitmapFactory.decodeStream(is));
				is.close();
			}
			//
			return new GamePkg(name, new Background(backgroundBitmap), pictures, backgrounds);
		} catch (IOException e) {
			Toast.makeText(context, "读取游戏资源失败", Toast.LENGTH_SHORT);
			e.printStackTrace();
		} catch (JSONException e) {
			Toast.makeText(context, "解析游戏资源失败", Toast.LENGTH_SHORT);
			e.printStackTrace();
		}
		
		return null;
	}
	
}
