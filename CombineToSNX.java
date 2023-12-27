package java8;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CombineToSNX {
    public static void main(String[] args) {
        String outputSNXPath = "E:\\Project\\Groovy_Audit\\PAC\\3.835_Backup\\Combined_Output.snx";
        String inputCodeFolder = "E:\\Project\\Groovy_Audit\\PAC\\3.835_Backup\\Extract_3.8.35code\\";
        String inputDBVariformFolder = "E:\\Project\\Groovy_Audit\\PAC\\3.835_Backup\\DBVariforms\\";
        String inputDigitalAssetFolder = "E:\\Project\\Groovy_Audit\\PAC\\3.835_Backup\\DigitalAssets\\";

        try {
            combineToSNX(outputSNXPath, inputCodeFolder, inputDBVariformFolder, inputDigitalAssetFolder);
            System.out.println("Combined content successfully written to: " + outputSNXPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void combineToSNX(String outputSNXPath, String inputCodeFolder, String inputDBVariformFolder, String inputDigitalAssetFolder) throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document doc = documentBuilder.newDocument();

        // Create the root element
        Element rootElement = doc.createElement("root");
        doc.appendChild(rootElement);

        // Combine Code Extensions
        combineCodeExtensions(doc, rootElement, inputCodeFolder);

        // Combine Database VariForms
        combineDBVariforms(doc, rootElement, inputDBVariformFolder);

        // Combine Digital Assets
        combineDigitalAssets(doc, rootElement, inputDigitalAssetFolder);

        // Write the document to the output file
        writeDocumentToFile(doc, outputSNXPath);
    }

    private static void combineCodeExtensions(Document doc, Element rootElement, String inputCodeFolder) throws IOException {
        File folder = new File(inputCodeFolder);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".groovy")) {
                    String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                    addExtensionElement(doc, rootElement, file.getName(), content);
                }
            }
        }
    }

    private static void combineDBVariforms(Document doc, Element rootElement, String inputDBVariformFolder) throws IOException {
        File folder = new File(inputDBVariformFolder);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".xml")) {
                    String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                    addEntityElement(doc, rootElement, file.getName(), content);
                }
            }
        }
    }

    private static void combineDigitalAssets(Document doc, Element rootElement, String inputDigitalAssetFolder) throws IOException {
        File folder = new File(inputDigitalAssetFolder);
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".groovy")) {
                    String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                    addDigitalAssetElement(doc, rootElement, file.getName(), content);
                }
            }
        }
    }

    private static void addExtensionElement(Document doc, Element rootElement, String name, String content) {
        Element extensionElement = doc.createElement("extension");
        extensionElement.setAttribute("name", name);
        extensionElement.setAttribute("contents", content);
        rootElement.appendChild(extensionElement);
    }

    private static void addEntityElement(Document doc, Element rootElement, String name, String content) {
        Element entityElement = doc.createElement("entity");
        entityElement.setAttribute("name", name);
        Element fieldElement = doc.createElement("field");
        fieldElement.setAttribute("id", "cfgvarName");
        fieldElement.setTextContent(name);
        entityElement.appendChild(fieldElement);
        Element variformElement = doc.createElement("field");
        variformElement.setAttribute("id", "cfgvarVariformXml");
        variformElement.setTextContent(content);
        entityElement.appendChild(variformElement);
        rootElement.appendChild(entityElement);
    }

    private static void addDigitalAssetElement(Document doc, Element rootElement, String id, String content) {
        Element digitalAssetElement = doc.createElement("digital-asset");
        digitalAssetElement.setAttribute("id", id);
        digitalAssetElement.setAttribute("groovy-code", content);
        rootElement.appendChild(digitalAssetElement);
    }

    private static void writeDocumentToFile(Document doc, String filePath) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        FileWriter writer = new FileWriter(filePath);
        StreamResult result = new StreamResult(writer);
        transformer.transform(source, result);
        writer.close();
    }
}