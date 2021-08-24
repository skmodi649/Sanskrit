package com.example.sanskrit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;

public class NumbersActivity<itemsAdapter> extends AppCompatActivity {
     private MediaPlayer m;
     private AudioManager mAudioManager;
     AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
         @Override
         public void onAudioFocusChange(int focusChange) {
             if((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) || (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)) {
                 //Stop the playback
                 m.pause();
                 m.seekTo(0);
             } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                 //Resume playback
                m.start(); //There is not method of resuming so we are using the start() method
             } else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                //AUDIOFOCUS_LOSS means we have lost the audio focus
                 //stop playback and cleanup resources
                 releaseMediaPlayer();
             }
         }
     };
     private final MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
         @Override
         public void onCompletion(MediaPlayer mp) {
             releaseMediaPlayer();
         }
     };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.sanskrit.R.layout.activity_numbers);
        //Create and setup the audio manager to request audio focus
        mAudioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        //Below given codes basically print the words using the root view and their childrent wordviews
        //Parent linear layout
        //creating object to print the arraylist elements
        //It is basically child of linear layout that is rootview
        //We are basically doing the work xml over here, in xml we would have to form textView tag for each string and this
        //does that with java code
        //adding each word as a view that further becomes the part of the linear layout

//    ArrayList<String> arr = new ArrayList<String>();
//Now instead of passing string objects inside the arraylist we will pass Word calss objects
        //So the code will be something like this
        ArrayList<Word> arr = new ArrayList<Word>();
//        Word w=new Word("one","ekah");
//        arr.add(w);
        //Now instead of doing above two commented steps we can simply put arr.add(new Word("one","eka");
        //Here we will use the constructor with two strings and one integer as parameter
        arr.add(new Word("One", "eka", R.drawable.number_one, R.raw.recording_one,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Two", "dvi", R.drawable.number_two, R.raw.recording_two,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Three", "tritya", R.drawable.number_three, R.raw.recording_three,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Four", "chaturtha", R.drawable.number_four, R.raw.recording_four,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Five", "pancha", R.drawable.number_five, R.raw.recording_five,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Six", "sashti", R.drawable.number_six, R.raw.recording_six,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Seven", "sapta", R.drawable.number_seven, R.raw.recording_seven,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Eight", "astha", R.drawable.number_eight, R.raw.recording_eight,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Nine", "nava", R.drawable.number_nine, R.raw.recording_nine,R.drawable.baseline_play_circle_outline_black_24));
        arr.add(new Word("Ten", "dasha", R.drawable.number_ten, R.raw.recording_ten,R.drawable.baseline_play_circle_outline_black_24));
        //Now we need to changa the String type of array adapter to Word type and change the layout to list_item
//    ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        //Now we are using a custom arrayadapter(WordAdapter) hence we need to modify ArrayAdapter to WordAdapter and only two paramters
        // to be passed i.e this and arraylist
        WordAdapter adapter = new WordAdapter(this, arr, R.color.category_numbers);
        ListView listview = (ListView) findViewById(com.example.sanskrit.R.id.list);
        listview.setAdapter(adapter);
        //Conclusion: All xml codes can be written using java codes as well

        //Now using the adapter to add sound files in the app
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {  // i denotes position of the word object
                Word word = arr.get(i);  //get the link of object at given position the user is clicked on
                //Release the media player resources as well for the song that was playing previously and
                //also because we are about to play a different audio file
                releaseMediaPlayer();

                //Request Audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //We have audio focus now
                    m = MediaPlayer.create(NumbersActivity.this, word.getAudioResourceId());
                    m.start();
                    //Setup a listener on the media player so that we can stop and release the media player once the song has
                    //stopped playing
                    //Instead of creating object for every audio file we have created global variable so that on object
                    //does the work for all the items in the list for every category
                    m.setOnCompletionListener(mCompletionListener);
                }
            }
        });
    }
    /**
     * Now we have to modify such that on clicking the home button of the mobile, the audio should stop playing
     * completely instead of playing the full song
     * for this a new life cycle activity called "onStop"
     */
    @Override
    protected void onStop() {
        super.onStop();
      //When the activity is stopped release the media resources because we won't be playing any more sounds
        releaseMediaPlayer(); //Instead of using just "release" we are using the releaseMediaPlayer() because it makes null as well
    }
        /**
         * Clean up the media player by releasing its resources
         */
        private void releaseMediaPlayer(){
            //If the media player is not null then it may be currently playing a song
            if(m!=null)
            {
                //Regardless of the state of media player, release its resource because we no longer need it
                m.release();
                //Set the media player back to null
                //For our code we have decided that setting media player to null is an easy way to tell that media player is
                //not configured to play the audio file at moment.
                m=null;

                //Regardless of whether or not we are granted audio focus , abandon it. This also
                //unregisters the AudioFocusChangeListener so we don't get anymore callbacks
                mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
            }
        }

}