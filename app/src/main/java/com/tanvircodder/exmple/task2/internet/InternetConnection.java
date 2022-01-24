package com.tanvircodder.exmple.task2.internet;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class InternetConnection {
    private static final String endpoint = "https://gorest.co.in/public/v1/users";
    private static final String key = "token";
    private static final String token = "d7c01847de4c083cb154e9a533294301e9f05f93dbae7d589e42ece63226c0a3";
    public static URL buildURL(){
        Uri buildUri = Uri.parse(endpoint).buildUpon()
                .appendQueryParameter(key,token)
                .build();
        URL newURL = null;
        try{
            newURL = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return newURL;
    }

    public static String HttpResponse(URL url) throws IOException {
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        try{
            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream);
            scanner.useDelimiter("\\A");
            boolean hasNext = scanner.hasNext();
            if (hasNext){
                return  scanner.next();
            }else {
                return null;
            }
        }catch (IOException e){
            Log.e(InternetConnection.class.getSimpleName(),"The connection problem"+ connection.getResponseCode());
        }finally {
            connection.disconnect();
        }
        return null;
    }
}
