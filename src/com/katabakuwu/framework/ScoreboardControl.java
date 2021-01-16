package com.katabakuwu.framework;

import java.io.IOException;

public interface ScoreboardControl {
	public void sendScore(String authKey, int score, int level) throws IOException;
}
