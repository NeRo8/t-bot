package com.tbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new Bot());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
