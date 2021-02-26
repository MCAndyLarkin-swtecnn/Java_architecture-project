package watersupply;
import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashMap;

public abstract class FileParser {
    static HashMap<String, Double> consumersScore = null;

    public static void parse(File file) throws IOException, ParserConfigurationException, SAXException {
        String[] splitedName = file.getName().split("\\.");
        switch (splitedName[splitedName.length - 1]) {
            case "json" -> jsonParser(file);
            case "xml" -> xmlParser(file);
            //For extension
        }
    }

    private static void xmlParser(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(file);
        Node node = document.getDocumentElement();
        NodeList consumers = node.getChildNodes();
        consumersScore = new HashMap<>();
        for(int i = 1; i < consumers.getLength(); i+=2){
            Node consumer = consumers.item(i);
            String tag = consumer.getNodeName().replace("Consumer","");
            Double val = Double.parseDouble(consumer.getTextContent());
            consumersScore.put(tag,val);
        }
    }

    public static void jsonParser(File file) throws IOException {
        Gson gson = new Gson();                             ///External!!
        Reader jsonReader = new BufferedReader(new FileReader(file));
        consumersScore = gson.fromJson(jsonReader, HashMap.class);
        jsonReader.close();
    }
    public static int findScore(int id) {
        return consumersScore.get(String.valueOf(id)).intValue();
    }
}
