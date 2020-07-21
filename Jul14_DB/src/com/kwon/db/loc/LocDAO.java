package com.kwon.db.loc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// 한글처리
//	 톰캣
//		클라이언트 -GET-> 서버(나)
//			자동(Tomcat이 알아서)
//		클라이언트 -POST-> 서버(나)
//			request.setCharacterEncoding("euc-kr");
//   자바
//		클라이언트(나) -GET-> 서버
//			URLEncoder.encode처리해서 보내야

public class LocDAO {
	public static void search(HttpServletRequest request) {
		try {
			// 클라이언트가 쓴 맥주가 euc-kr
			request.setCharacterEncoding("euc-kr"); // post때는 써야

			String what = request.getParameter("what");
			// 인터넷 주소에는 한글을 넣으면x
			// ㅋ -utf-8-> %2A
			what = URLEncoder.encode(what, "utf-8");

			String s = "https://dapi.kakao.com/v2/local/search/keyword.json";
			s += "?query=" + what;
			s += "&x=127.023706&y=37.502369&radius=5000";
			s += "&sort=distance";

			URL u = new URL(s);
			HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK 00df1ed27f9258c68437812788bfbf96");

			InputStream is = huc.getInputStream();
			// 카카오가 응답해준게 utf-8
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			JSONParser jp = new JSONParser();
			JSONObject jo = (JSONObject) jp.parse(isr);
			JSONArray d = (JSONArray) jo.get("documents");
			JSONObject l = null;
			ArrayList<Location> locs = new ArrayList<Location>();
			Location loc = null;
			for (int i = 0; i < d.size(); i++) {
				l = (JSONObject) d.get(i);
				loc = new Location();
				loc.setName(l.get("place_name") + "");
				loc.setDistance(l.get("distance") + "");
				loc.setAddress(l.get("road_address_name") + "");
				loc.setPhone(l.get("phone") + "");
				locs.add(loc);
			}
			request.setAttribute("locs", locs);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
