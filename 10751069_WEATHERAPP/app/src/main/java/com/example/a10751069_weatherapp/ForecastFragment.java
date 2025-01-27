package com.example.a10751069_weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Forecast fragment.
 */
public class ForecastFragment extends Fragment {

    /**
     * The City field.
     */
    TextView cityField;
    /**
     * The Updated field.
     */
    TextView updatedField;
    /**
     * The Details field.
     */
    TextView detailsField;
    /**
     * The Current temperature field.
     */
    TextView currentTemperatureField;
    /**
     * The Weather icon.
     */
    TextView weatherIcon;

    /**
     * Instantiates a new Forecast fragment.
     */
//private TextView address;
    public ForecastFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        cityField = (TextView) rootView.findViewById(R.id.city_field);
        String city = "Plymouth, UK";
        cityField.setText(city);
        String urlJsonArry = MainActivity.urlJsonArry;
        final String TAG = "json_url_req";
        LocalDateTime localDateTime = LocalDateTime.now();
        updatedField = (TextView) rootView.findViewById(R.id.updated_field);
        DateTimeFormatter localDateTimeFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm");
        updatedField.setText("Last Update: " + localDateTime.format(localDateTimeFormat));
        /**
         * This is supposed to get the variables required to display on the ForecastFragment
         * But currently unable to figure out how to get it to do so.
         */
        /*JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlJsonArry, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG,"Error: " +error.getMessage());
            }
        }){
            @Override
            public Map getParams(){
                Map temp = new HashMap();
                temp.get("temp");

                currentTemperatureField.setText(temp);
            }
        };
        AppController.getInstance().addToRequestQueue(jsonObjectRequest, TAG);
        */
        /**
         * as you can see this was not my first attempt at trying to get it to parse the variables correctly.
         *
         */
        /*
        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                updatedField = (TextView) rootView.findViewById(R.id.updated_field);
                DateFormat df = DateFormat.getDateInstance();
                String updatedOn = df.format(new Date(response.getInt(Integer.parseInt("dt")) * 1000));
                updatedField.setText("Last Update: " + updatedOn);
                currentTemperatureField = (TextView) rootView.findViewById(R.id.current_temperature);
            }*/

        return rootView;
    }

    /*Typeface weatherFont;

    TextView cityField;
    TextView updatedField;
    TextView detailsField;
    TextView currentTemperatureField;
    TextView weatherIcon;

    Handler handler;*/

    /*public ForecastFragment(){
        handler = new Handler();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        cityField = (TextView)rootView.findViewById(R.id.city_field);
        updatedField = (TextView) rootView.findViewById(R.id.updated_field);
        currentTemperatureField = (TextView) rootView.findViewById(R.id.current_temperature);
        weatherIcon = (TextView)rootView.findViewById(R.id.weather_icon);

        weatherIcon.setTypeface(weatherFont);
        return rootView;
    }*/

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        weatherFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/weather.ttf");
        //updateWeatherData(new CityPreference(getActivity()).getCity());
    }*/

    /*private void updateWeatherData(final String city){
        new Thread(){
            public void run(){
                final JSONObject json = RemoteFetch.getJSON(getActivity(), city);
                if(json == null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), getActivity().getString(R.string.place_not_found),Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    handler.post(new Runnable(){
                        public void run(){
                            renderWeather(json);
                        }
                    });
                }
            }
        }.start();
    }

    private void renderWeather(JSONObject json){
        try{
            cityField.setText(json.getString("name").toUpperCase(Locale.ENGLISH) + ", " + json.getJSONObject("sys").getString("country"));

            JSONObject details = json.getJSONArray("weather").getJSONObject(0);
            JSONObject main = json.getJSONObject("main");
            detailsField.setText(details.getString("description").toUpperCase(Locale.ENGLISH) + "\n" + "Humidity: " + main.getString("humidity") + "%" + "\n" + "Pressure: " + main.getString("pressure") + " hpa");

            currentTemperatureField.setText(String.format("%.2f", main.getDouble("temp"))+ " ℃");

            DateFormat df = DateFormat.getDateInstance();
            String updatedOn = df.format(new Date(json.getLong("dt")*1000));
            updatedField.setText("Last update: " +updatedOn);
        }catch(Exception e){
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }*/

}
