package com.katabakuwu.framework;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public interface ScoreboardControl {
	public void sendScore(String authKey, int score, int level) throws IOException;
}
