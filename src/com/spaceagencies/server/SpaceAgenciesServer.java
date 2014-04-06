package com.spaceagencies.server;

public class SpaceAgenciesServer {

	public static void main(String[] args) {
		ParameterAnalyser parameterAnalyser = new ParameterAnalyser(args);
		GameServer gameServer = new GameServer(parameterAnalyser);
		gameServer.run();
	}
}
