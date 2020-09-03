package com.tbot;
import java.io.IOException;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;



public class Bot extends TelegramLongPollingBot  {




        public void onUpdateReceived(Update update) {

            if (update.hasMessage() && update.getMessage().hasText()) {
                String text = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();
                SendMessage mes = new SendMessage();

                try {
                    if (text.equals("/help")) {
                        mes.setChatId(chat_id).setText("This bots shows current weather conditions");
                        execute(mes);
                    } else {
                        String weather = Weather.getWeather(text);
                        mes.setChatId(chat_id).setText(weather);
                        execute(mes);
                    }
                } catch (TelegramApiException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Wrong city name!");
                    e.printStackTrace();
                }
            }
        }





        public String getBotUsername() {
            // TODO Auto-generated method stub
            //TWeatherBot
            //weather_small_bot
            return "weather_small_bot";
        }

        @Override
        public String getBotToken() {
            // TODO Auto-generated method stub
            return "1203979359:AAG44gnHTUl0eZA-y4nCTsvLNBJ2ud9fdec";
        }

}
