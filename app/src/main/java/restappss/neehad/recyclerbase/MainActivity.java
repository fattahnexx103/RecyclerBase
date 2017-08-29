package restappss.neehad.recyclerbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import restappss.neehad.recyclerbase.adapter.RecyclerViewAdapter;
import restappss.neehad.recyclerbase.entities.ObjectClass;

public class MainActivity extends AppCompatActivity {

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
    }
}
