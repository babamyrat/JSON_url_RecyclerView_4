package com.example.json_url_recyclerview_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 1 - JSON Link on Internet https://run.mocky.io/v3/2e8cbeaa-6670-4b6b-b21e-a6a5a61f2052

    // private static String JSON_URL = "https://run.mocky.io/v3/2e8cbeaa-6670-4b6b-b21e-a6a5a61f2052";

    //private static String JSON_URL = "https://run.mocky.io/v3/0b296f1f-3d82-4ffc-87b5-b6a67637257b";

    //private static String JSON_URL = "https://run.mocky.io/v3/92daf9b6-9cad-44cf-9084-ab0e184290b8";

//    private static String JSON_URL = "https://run.mocky.io/v3/4ead7731-4ca1-498b-bcfd-dc25cca59430";

    private static String JSON_URL = "http://hp-api.herokuapp.com/api/characters";

    List<ExampleItem> mExampleItem;

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     mExampleItem = new ArrayList<>();
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


                 JSONArray jsonArray = new JSONArray(s);

                for (int i = 0; i < jsonArray.length(); i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    ExampleItem model = new ExampleItem();
                    model.setName(jsonObject1.getString("name"));
                    model.setSpecies(jsonObject1.getString("species"));
                    model.setGender(jsonObject1.getString("gender"));
                    model.setHouse(jsonObject1.getString("house"));
                    model.setDateOfBirth(jsonObject1.getString("dateOfBirth"));
                    model.setYearOfBirth(jsonObject1.getString("yearOfBirth"));
                    model.setAncestry(jsonObject1.getString("ancestry"));
                    model.setEyeColour(jsonObject1.getString("eyeColour"));
                    model.setHairColour(jsonObject1.getString("hairColour"));
                    model.setPatronus(jsonObject1.getString("patronus"));
                    model.setHogwartsStudent(jsonObject1.getString("hogwartsStudent"));
                    model.setHogwartsStaff(jsonObject1.getString("hogwartsStaff"));
                    model.setActor(jsonObject1.getString("actor"));
                    model.setAlive(jsonObject1.getString("alive"));
                    model.setImg(jsonObject1.getString("image"));

                    JSONObject want = jsonObject1.getJSONObject("wand");
                    model.setWood(want.getString("wood"));
                    model.setCore(want.getString("core"));
                    model.setLength(want.getString("length"));



                    mExampleItem.add(model);
                }



            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView(mExampleItem);

        }
    }

    private void PutDataIntoRecyclerView(List<ExampleItem> mExampleItem){
        ExampleAdapter adaptery = new ExampleAdapter(this, mExampleItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adaptery);
    }


}