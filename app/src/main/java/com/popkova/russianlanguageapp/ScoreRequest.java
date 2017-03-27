package com.popkova.russianlanguageapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 23.03.2017.
 */

public class ScoreRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://popkovarussianlanguageapplicationcom.000webhostapp.com/score.php";
    private Map<String, String> params;

    public ScoreRequest(int score, String username, Response.Listener<String> listener) {
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("score", score + "");
        params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
