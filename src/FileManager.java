import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class FileManager
{
   private String[] fileNames;
   private File[] files;

   public FileManager()

  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try
    {
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.newDocument();

      Element rootElement = doc.createElement("GradeList");
      for (int i = 0; i < grades.size(); i++)
      {
        Element subElement = doc.createElement("Grade");
        Element subSubElement = doc.createElement("Course");
        subSubElement.appendChild(doc.createTextNode(grades.getGrade(i).getCourse()));
        subElement.appendChild(subSubElement);
        subSubElement = doc.createElement("Grade");
        subSubElement.appendChild(doc.createTextNode(
            Integer.toString(grades.getGrade(i).getGrade())));
        subElement.appendChild(subSubElement);
        rootElement.appendChild(subElement);
      }
      doc.appendChild(rootElement);

      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      transformer
          .setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
      transformer.transform(new DOMSource(doc), new StreamResult(file));

    }
    catch (ParserConfigurationException | TransformerException e)
    {
      System.out.println("Error");
    }
  }
}
