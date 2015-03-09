package nl.mprog.Ghost;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by Equifilm on 9-3-2015.
 */

public class Dictionary {

    //Dictionary inladen
    public static HashSet getDictionary(Context ctx)
    {

        //Create hashset for dictionary
        HashSet<String> dutchDictionary = new HashSet<String>();

        InputStream inputStream = ctx.getResources().openRawResource(R.raw.dutch);

        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;

        try {
            while (( line = buffreader.readLine()) != null) {


                dutchDictionary.add(line);



            }
        } catch (IOException e) {
            return null;
        }
        
        return dutchDictionary;


    }


}
