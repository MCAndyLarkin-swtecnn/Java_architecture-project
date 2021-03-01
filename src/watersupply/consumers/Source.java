package watersupply.consumers;

import org.xml.sax.SAXException;
import watersupply.Hardware_realization;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Hardware_realization
public interface Source{//Protocol of data mining
     int getExpense(int id);
     static FileSource fileSourceBuilder(File file){
        FileSource fileSource;
        try {
            fileSource = new FileSource(file);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            fileSource = null;
        }
        return fileSource;
    }
}
