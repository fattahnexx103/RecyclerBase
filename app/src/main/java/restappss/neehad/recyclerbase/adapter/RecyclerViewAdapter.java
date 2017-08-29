package restappss.neehad.recyclerbase.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import restappss.neehad.recyclerbase.R;
import restappss.neehad.recyclerbase.entities.ObjectClass;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    //URL https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=ab7ab170f70f40478814d6087c36e698
    private List<ObjectClass> objectClassList;
    private Context context;

    public RecyclerViewAdapter(List<ObjectClass> objectClassList, Context context) {
        this.objectClassList = objectClassList;
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //get the cardView layout into java
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {

        //get the object
        ObjectClass objectClass = objectClassList.get(position);

        //set the title
        holder.title.setText(objectClass.getTitle());

        //set the desc
        holder.desc.setText(objectClass.getDesc());

    }

    @Override
    public int getItemCount() {
        return objectClassList.size(); //size of the list of objects
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {


        //get the views in the cardView
        public TextView title;
        public  TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.item_titile);
            desc = (TextView) itemView.findViewById(R.id.item_desc);


        }
    }
}
