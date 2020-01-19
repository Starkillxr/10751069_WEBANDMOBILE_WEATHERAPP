package com.example.myweatherapp;
// used https://demonuts.com/android-google-map-in-fragment/ for help when setting up the map fragment

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Most of my program worked before however it now only seems to work with the JSON Request button on API 24.
 * Tried it on API 28 and it threw up an error.
 */
public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Learnt how to hide the notification bar at https://stackoverflow.com/questions/4222713/hide-notification-bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        /**
         * Most of this code is me practicing calling an API
         */
        //Most of the code in this is me practicing calling an API
        btnMakeArrayRequest = findViewById(R.id.btnArrayRequest);
        txtResponse = findViewById(R.id.txtResponse);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.login);
        /**
         *  the parameter addToBackStack basically allows the programmer to add to the back stack so that the user is able to reverse
         *  the transaction and bring up the previous fragment by pressing the back button
         */
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new MapFragment(), false, "one" );
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new ForecastFragment(), false, "one");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new LoginFragment(), false, "one");
            }
        });

        btnMakeArrayRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeJsonArrayRequest();
            }
        });
    }

    /**
     * Add fragment.
     *
     * @param fragment       the fragment
     * @param addToBackStack the add to back stack
     * @param tag            the tag                       This is a method that I have used to enlarge my fragments.                       I have put it into a method so that it is easier to call at a later date                       without having to constantly retype code.
     */
    public void addFragment(Fragment fragment, boolean addToBackStack, String tag){
      FragmentManager manager = getSupportFragmentManager();
      FragmentTransaction ft = manager.beginTransaction();

      if(addToBackStack){
          ft.addToBackStack(tag);
      }
      ft.replace(R.id.container_frame_back,fragment,tag);
      ft.commitAllowingStateLoss();

    }

    /**
     * String urlJsonArray stores the api for the JSON array from openweather
     */
    public static String urlJsonArry = "http://api.openweathermap.org/data/2.5/forecast?id=2640194&units=metric&APPID=faf15c72035a522d6e027c2be057069c";

    public static String TAG = MainActivity.class.getSimpleName();

    /**
     * btnMakeArrayRequest a button for making array request
     */
    private Button btnMakeArrayRequest;

    private ProgressDialog pDialog;

    private String jsonResponse;

    private TextView txtResponse;

    public void makeJsonArrayRequest(){

        showpDialog();
        JsonArrayRequest req = new JsonArrayRequest(urlJsonArry, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                try {
                    jsonResponse = "";
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject forecast = (JSONObject) response.get(i);

                        String name = forecast.getString("name");
                        String country = forecast.getString("country");
                        int temp = forecast.getInt("temp");
                        int humidity = forecast.getInt("humidity");
                        int windSpeed = forecast.getInt("speed");

                        jsonResponse += "Name: " + name + "\n\n";
                        jsonResponse += "Country: " + country + "\n\n";
                        jsonResponse += "Temperature: " + temp + "\n\n";
                        jsonResponse += "Humidity: " + humidity + "%" + "\n\n";
                        jsonResponse += "Wind Speed: " + windSpeed + "mph" + "\n\n";

                    }

                    txtResponse.setText(jsonResponse);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                hidepDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), error.getMessage(),Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        AppController.getInstance().addToRequestQueue(req);
    }

    /**
     * will show the dialog
     */
    private void showpDialog(){
        if(!pDialog.isShowing())
            pDialog.show();
    }

    /**
     * This hides the dialog
     */
    private void hidepDialog(){
        if(pDialog.isShowing())
            pDialog.dismiss();
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.change_city){
            showInputDialog();
        }
        return false;
    }

    private void showInputDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Change City");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                changeCity(input.getText().toString());
            }
        });
        builder.show();
    }

    public void changeCity(String city){
        ForecastFragment ff = (ForecastFragment)getSupportFragmentManager().findFragmentById(R.id.container_frame_back);

        ff.changeCity(city);
        new CityPreference(this).setCity(city);
    }*/
}