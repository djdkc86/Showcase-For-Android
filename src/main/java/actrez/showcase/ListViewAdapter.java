package actrez.showcase;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<RezObject> {
    ArrayList<RezObject> activitiesToDisplay;
    Context context;
    int resource;
    
    public ListViewAdapter(Context context, int resource, ArrayList<RezObject> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.context = context;
        this.activitiesToDisplay = objects;
    }
    
    public class ViewHolder {
        TextView txtTitle;
        TextView txtLocation;
        TextView txtImageCount;
        TextView txtDescription;
    }
    
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder = null;
        
        if (view == null) {
            LayoutInflater inflater = ListViewActivity1.this.getLayoutInflater();
            view = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) view.findViewById(R.id.TextView_Title_ListView2);
            holder.txtLocation = (TextView) view.findViewById(R.id.TextView_Location_ListView2);
            holder.txtImageCount = (TextView) view.findViewById(R.id.TextView_ImageCount_ListView2);
            holder.txtDescription = (TextView) view.findViewById(R.id.TextView_Description_ListView2);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        String title = activitiesToDisplay.get(position).getTitle();
        String location = activitiesToDisplay.get(position).getDest();//*+" image count: "+activitiesToDisplay.get(position).getImageCount();
        String imageCount = "Images: "+activitiesToDisplay.get(position).getImageCount()+" ";
        String description = activitiesToDisplay.get(position).getDesc();
        holder.txtTitle.setText(title);
        holder.txtLocation.setText(location);
        holder.txtImageCount.setText(imageCount);
        holder.txtDescription.setText(description);
        
        return view;
    }
    
}