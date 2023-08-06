import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadFromFileExample {

    public void readFromFile() {
        try {
            System.out.println("Your inputtext.txt text file should be in the directory: "
                    + System.getProperty("user.dir"));

            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("inputtext.txt"));
            //Get first line
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                //Read lines until file reader returns null
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
