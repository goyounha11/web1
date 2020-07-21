package com.kwon.db.weather;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class WeatherDAO {
	public static void getWeather(HttpServletRequest request) {
		try {
			URL u = new URL("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4113564000");
			HttpURLConnection huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(is, "utf-8");

			ArrayList<Weather> weathers = new ArrayList<Weather>();
			Weather w = null;

			String tagName = null;
			int what = xpp.getEventType();
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					tagName = xpp.getName();
					if (tagName.equals("data")) { // <data seq="?">
						w = new Weather(); // 새로운 날씨객체 생성
					}
				} else if (what == XmlPullParser.TEXT) {
					if (tagName.equals("hour")) {
						// 생성되어있는 날씨객체에 속성값 세팅
						w.setHour("~" + xpp.getText() + "시 까지");
					} else if (tagName.equals("temp")) {
						w.setTemp(xpp.getText() + "℃");
					} else if (tagName.equals("wfKor")) {
						w.setWeather(xpp.getText());
						if (w.getWeather().contains("맑음")) {
							w.setImg("sun.png");
						} else if (w.getWeather().contains("구름") || w.getWeather().contains("흐림")) {
							w.setImg("cloud.png");
						} else if (w.getWeather().contains("비") || w.getWeather().contains("소나기")
								|| w.getWeather().contains("우")) {
							w.setImg("rain.png");
						} else {
							w.setImg("snow.png");
						}
					}
				} else if (what == XmlPullParser.END_TAG) {
					tagName = "";
					if (xpp.getName().equals("data")) { // </data>
						weathers.add(w);
					}
				}
				xpp.next();
				what = xpp.getEventType();
			}
			request.setAttribute("weathers", weathers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
