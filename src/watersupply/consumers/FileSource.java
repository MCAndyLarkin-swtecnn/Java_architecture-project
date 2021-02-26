package watersupply.consumers;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import static watersupply.ExampleStorage.*;
import static watersupply.FileParser.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileSource implements Source{
    private File file;
    private boolean available = false;

    public FileSource(File file) throws IOException, ParserConfigurationException, SAXException {
                                                    //I dont foolow Exception^ becuse exception MUST be throwed.
                                                    // Excertion save program behavior
            this.file = file;
            parse(file);
    }
    @Override
    public int getExpense(int id){
        return findScore(id);
    }

    public boolean isAvailable(){
        return  available;
    }
    public void replaceFile(File file){
        this.file = file;
    }
}
