package nl.mprog.Ghost;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Dictionary{
    
    //Dictionary contains:
    private HashSet<String> words;
    
    //Dictionary constructor -> TODO meekrijgen van de aan te maken taal
    public Dictionary(Context ctx, String GivenLanguage){
              
        //temp hashset
        HashSet<String> tempHashSet = new HashSet<String>();
        
        //Standard language = Dutch
        InputStream inputStream = ctx.getResources().openRawResource(R.raw.dutch);
//        this.language = "NL";

        //if Eng meegekregen ->
        if (GivenLanguage.equals("ENG")) {
            inputStream = ctx.getResources().openRawResource(R.raw.english);
//            this.language = "ENG";
        }

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



    //get size method
    public int getSize(){
       return  this.words.size();
    }

}
