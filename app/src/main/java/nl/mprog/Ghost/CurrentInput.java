package nl.mprog.Ghost;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Equifilm on 10-3-2015.
 */
public class CurrentInput{

    //Current input
    private String theCurrentInput;

    //Size of the current input
    private int inputSize;
    
    public CurrentInput() {
        theCurrentInput = "";
        inputSize = 0;
    }
    
    //Function -> Add Letter
    public void addLetter (char letterToAdd, TextView view){

        this.theCurrentInput = this.theCurrentInput + letterToAdd;

        //set new word, update
        view.setText(theCurrentInput);

        //Set size to new size
        this.inputSize++;
    }

    //Function get current input
    public String get(){
        return this.theCurrentInput;
    }

    //Function-> Clear current input
    public void clear(TextView view) {
        this.theCurrentInput = "";
        this.inputSize = 0;
        
        //set view
        view.setText(this.theCurrentInput);
    }

    //Function getSize
    public int getSize () {
        return this.inputSize;
    }
    
}
