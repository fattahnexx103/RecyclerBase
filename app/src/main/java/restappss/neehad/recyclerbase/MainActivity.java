package restappss.neehad.recyclerbase;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import restappss.neehad.recyclerbase.adapter.RecyclerViewAdapter;
import restappss.neehad.recyclerbase.entities.ObjectClass;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL= "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=ab7ab170f70f40478814d6087c36e698";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ObjectClass> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.item_recyclerView);
        recyclerView.setHasFixedSize(true); //every item has samme size
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //arrange them in linear layout

        listItems = new ArrayList<>(); //make a list of the objects


        //do volley work
        loadRecyclerViewData();

        /*
        //just for dummy data
        for(int i = 0; i < 10; i++){

            ObjectClass object = new ObjectClass(
                    "heading" + (i+1),
                    "This is some dummy text"
            );

            listItems.add(object);


            //make the adapter
            adapter = new RecyclerViewAdapter(listItems, this);

            //set the adapter
            recyclerView.setAdapter(adapter);
        }

        */
    }

    private void loadRecyclerViewData(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Getting data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                BASE_URL,
                new Response.Listener<String>() { //once we get a response from server
                    @Override
                    public void onResponse(String s) {

                        progressDialog.dismiss();

                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray array = jsonObject.getJSONArray("articles");

                        for(int i = 0; i <array.length(); i++){

                            JSONObject object = array.getJSONObject(i);
                            ObjectClass  item = new ObjectClass(
                                    object.getString("title"),
                                    object.getString("description"),
                                    object.getString("urlToImage")
                            );
                            listItems.add(item);
                        }

                        adapter = new RecyclerViewAdapter(listItems, getApplicationContext());
                        recyclerView.setAdapter(adapter);


                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }
                },
                //if error occurs
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
