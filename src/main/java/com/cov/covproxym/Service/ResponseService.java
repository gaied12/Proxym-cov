package com.cov.covproxym.Service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {
    public JSONObject getResponse(String Response, String code, String message) throws org.json.JSONException {

        //create error message in JSON
        JSONObject errorJSON = new JSONObject();
        // add error attributes
        errorJSON.put("code", code);
        errorJSON.put("msg", message);
        //create parent response JSON
        JSONObject response = new JSONObject();
        //add error JSON in response JSON
        response.put(Response, errorJSON);

        return response;

    }
}
