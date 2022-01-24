package com.tanvircodder.exmple.task2.internet;

import android.content.Context;

import com.tanvircodder.exmple.task2.model.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonPerser {
    private static final String id = "id";
    private static final String name = "name";
    private static final String email = "email";
    private static final String gender = "gender";
    private static final String status= "status";
    private static final String main_key = "data";
    private static List<Util> mData = null;
    public static List<Util> UrlJsonParsing(Context context,String httpresponse) throws JSONException {

        JSONObject responseObject= new JSONObject(httpresponse);
        JSONArray responseArray = responseObject.getJSONArray(main_key);
        mData = new ArrayList<>();
        for (int i =0;i<responseArray.length();i++){
            JSONObject object = responseArray.getJSONObject(i);
            String m_id = object.getString(id);
            String m_name = object.getString(name);
            String m_email = object.getString(email);
            String m_gender = object.getString(gender);
            String m_status = object.getString(status);
            Util util= new Util(m_id,m_name,m_email,m_gender,m_status);
            mData.add(util);
        }
        return mData;
    }
}
