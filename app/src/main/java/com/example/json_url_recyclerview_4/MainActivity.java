package com.example.json_url_recyclerview_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    // 1 - JSON Link on Internet https://run.mocky.io/v3/2e8cbeaa-6670-4b6b-b21e-a6a5a61f2052

//    private static String JSON_URL = "https://run.mocky.io/v3/7ab7b672-db37-45f1-875e-cbb959aadca8";
    private static String JSON_URL = "https://run.mocky.io/v3/2e8cbeaa-6670-4b6b-b21e-a6a5a61f2052";

    List<MovieModelClass> movieList;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     movieList = new ArrayList<>();
     recyclerView = findViewById(R.id.recyclerView);


     GetData getData = new GetData();
     getData.execute();


    }

    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while (data != -1){

                        current += (char) data;
                        data = isr.read();

                    }
                    return current;

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null){
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONObject jsonObject = new JSONObject(s);

                JSONArray jsonArray = jsonObject.getJSONArray("moviz");

                for (int i = 0; i < jsonArray.length(); i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    MovieModelClass model = new MovieModelClass();
                    model.setId(jsonObject1.getString("id"));
                    model.setName(jsonObject1.getString("name"));
                    model.setImg(jsonObject1.getString("image"));

                    movieList.add(model);
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }


            PutDataIntoRecyclerView(movieList);



        }
    }

    private void PutDataIntoRecyclerView(List<MovieModelClass> movieList){
        Adaptery adaptery = new Adaptery(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adaptery);
    }


//    public String GetDataFromUrl(String url){
//        if(url.toLowerCase().startsWith("https")){
//            //HTTPS:
//            return GetHTTPSData(url);
//        }else{
//            //HTTP:
//            return GetHTTPData(url);
//        }
//    }




}