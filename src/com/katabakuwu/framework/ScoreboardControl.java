package com.katabakuwu.framework;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public interface ScoreboardControl {
	public static void sendScore(String name, int score) throws IOException {

		URL url = new URL("http://katabakuwu.asteriskrin.my.id/postScore.php?key=1234&name=" + name + "&score=" + score);
		System.out.println(url);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("GET");
		OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
		System.out.println(httpCon.getResponseCode());
		System.out.println(httpCon.getResponseMessage());
		out.close();
	}
}
