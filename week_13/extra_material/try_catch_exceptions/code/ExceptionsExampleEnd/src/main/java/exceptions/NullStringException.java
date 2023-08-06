package exceptions;

// We extend the Exception class from the standard java library
// As we're making an Exception, not just any old class.
public class NullStringException extends Exception{

    // Our constructor passes a String up to the super class' (Exception's) constructor.
    // This allows us to attach the String to the Exception object.
    public NullStringException(String message){
        super(message);
    }

}