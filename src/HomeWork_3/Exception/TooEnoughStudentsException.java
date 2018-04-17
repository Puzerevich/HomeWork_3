package HomeWork_3.Exception;

/**
 * Created by Konstantin on 12.04.2018.
 */
public class TooEnoughStudentsException extends Throwable {
    @Override
    public String getMessage() {
        return "You try add mor than ten students. Our group  hasn't free place. Try later.";
    }
}
