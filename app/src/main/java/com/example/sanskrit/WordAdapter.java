package com.example.sanskrit;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;



import java.util.ArrayList;

/*
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link androidSanskrit} objects.
 * */
public class WordAdapter extends ArrayAdapter<Word>
{
    private final String loki=WordAdapter.class.getSimpleName();
    private final int idofcolor;    //Resource id for the background color of the list of words
    /**
 * This is our own custom constructor (it doesn't mirror a superclass constructor).
 * The context is used to inflate the layout file, and the list is the data we want
 * to populate into the lists.
 */
public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId)
{
    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.
    super(context,0,words);
    idofcolor=colorResourceId;
}
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
    }
        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView sansTextView = (TextView) listItemView.findViewById(com.example.sanskrit.R.id.saone_id);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        sansTextView.setText(currentWord.getSanskritTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defTextView = (TextView) listItemView.findViewById(com.example.sanskrit.R.id.one_id);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defTextView.setText(currentWord.getDefaultTranslation());
        //Find the ImageView in the list_item.xml layout with the ID version_name
        ImageView imageview = (ImageView) listItemView.findViewById(com.example.sanskrit.R.id.image);
        ImageView imagi = (ImageView) listItemView.findViewById(com.example.sanskrit.R.id.icon);
        imagi.setImageResource(currentWord.IconResourceId());
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentWord.hasImage()){
        imageview.setImageResource(currentWord.getImageResourceId());
        //Make sure the view is visible
        imageview.setVisibility(View.VISIBLE);
        }
        else{
            //Otherwise hide the imageview(set the visibility to gone)
            imageview.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        //Set the theme color for the list item
        View textContainer=listItemView.findViewById(com.example.sanskrit.R.id.text_container);
        int color = ContextCompat.getColor(getContext(),idofcolor);
        textContainer.setBackgroundColor(color);
        return listItemView;
    }
}

