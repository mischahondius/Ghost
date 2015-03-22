//Mischa Hondius
//6053017

package nl.mprog.Ghost;

public class Name {

    // validating name
    static public boolean isValid(String enteredName) {
        if ((enteredName != null) && (enteredName.length() < 20) && (enteredName.length() > 1)){
            return true;
        }
        return false;
    }
}