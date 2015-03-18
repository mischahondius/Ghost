package nl.mprog.Ghost;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.lang.Override;
import java.lang.String;
import java.util.Map;

class MyAdapter extends ArrayAdapter<String> {

    public MyAdapter(Context context, Map values) {
        super(context, R.layout.row_layout_2, values);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.row_layout_2, parent, false);

        String tvName = getItem(position);
        
        //get the textview to fill up
        TextView theTextView = (TextView) theView.findViewById(R.id.textView1);
        
        //Fill in names of players
        theTextView.setText(tvName);
        
        ImageView theImageView = (ImageView) theView.findViewById(R.id.imageView1);
        theImageView.setImageResource(R.drawable.red_dot);
        return theView;

    }
}