package watersupply.consumers;

import static watersupply.ExampleStorage.*;
import static watersupply.FileParser.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileSource implements Source{
    private File file;
    private boolean available = false;

    public FileSource(File file){
        if(file.canRead()){
            this.file = file;
            parse(file);
        }
    }
    @Override
    public int getExpense(int id) {
        return findScore(id);
    }

    public boolean isAvailable(){
        return  available;
    }
    public void replaceFile(File file){
        this.file = file;
    }
}
