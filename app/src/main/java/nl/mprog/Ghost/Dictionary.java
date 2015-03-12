package nl.mprog.Ghost;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Dictionary{
    
    //Dictionary contains:
    public HashSet<String> words;
    
    //Dictionary constructor
    public Dictionary(Context ctx){
              
        //temp hashset
        HashSet<String> tempHashSet = new HashSet<String>();

        InputStream inputStream = ctx.getResources().openRawResource(R.raw.dutch);
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;

        try {
            while (( line = buffreader.readLine()) != null) {
                tempHashSet.add(line);
            }
        } catch (IOException e) {
            return;

            
        }

        //Initialize Words    
        this.words = tempHashSet;

    }

    //contains word? function
    public boolean isWord (String word){

        //if it is in dictionary = word
        if (this.words.contains(word)){
            return true;
        }

        else {
            // If it does not contain word
            return false;
        }
    }

    //get Words method
    public HashSet<String> getWords(){return words;}

}
    
        


//    //isValid letter check function
//    public boolean isValid (char lettertoAdd){
//
//        //
//        return true;
//    }