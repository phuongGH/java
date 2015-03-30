package data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class fileManager {

    public void writeInfo(HashMap hm) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

//            String aa  = String.valueOf(hm.get("level"));
//            System.out.println(aa);
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement((String) hm.get("rootKey"));
            doc.appendChild(rootElement);

            Element level = doc.createElement("level");
            level.appendChild(doc.createTextNode(String.valueOf(hm.get("level"))));
            rootElement.appendChild(level);

            Element live = doc.createElement("live");
            live.appendChild(doc.createTextNode(String.valueOf(hm.get("live"))));
            rootElement.appendChild(live);

            Element code = doc.createElement("code");
            code.appendChild(doc.createTextNode(String.valueOf(hm.get("code"))));
            rootElement.appendChild(code);
            
            Element highCode = doc.createElement("highCode");
            highCode.appendChild(doc.createTextNode(String.valueOf(hm.get("highCode"))));
            rootElement.appendChild(highCode);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/data/" + (String) hm.get("rootKey") + ".dat"));

            // Output to console for testing
            // StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerConfigurationException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HashMap readInfo(String fileName) {
        HashMap hm = new HashMap();

        try {
            InputSource xml = new InputSource(("src/data/" + fileName + ".dat"));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xml);
            
            hm.put("rootKey",fileName);
            
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();
            String exp = "//rance//level";
            NodeList names = (NodeList) xpath.evaluate(exp, doc, XPathConstants.NODESET);
            Element elem = (Element) names.item(0);
            hm.put("level", elem.getTextContent());
//            System.out.println("level :" + elem.getTextContent());
            
            exp = "//rance//live";
            names = (NodeList) xpath.evaluate(exp, doc, XPathConstants.NODESET);
            elem = (Element) names.item(0);
            hm.put("live", elem.getTextContent());
//            System.out.println("live " + elem.getTextContent());
            
            exp = "//rance//code";
            names = (NodeList) xpath.evaluate(exp, doc, XPathConstants.NODESET);
            elem = (Element) names.item(0);
            hm.put("code", elem.getTextContent());
//            System.out.println("code " + elem.getTextContent());
            
             exp = "//rance//highCode";
            names = (NodeList) xpath.evaluate(exp, doc, XPathConstants.NODESET);
            elem = (Element) names.item(0);
            hm.put("highCode", elem.getTextContent());
            
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            Logger.getLogger(fileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hm;
    }
    
    public boolean cheackFile(String fileName){
          File file = new File(fileName);
          if(file.exists()){
             return true;
          }else{
             return false;
          }        
    }
}
