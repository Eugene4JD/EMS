package mediator;

import model.*;
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
import java.io.*;

public class XML implements PersistenceXML
{
  @Override public void save(File file, Object object)
  {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    ExamList exams = (ExamList) object;
    try
    {

      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.newDocument();

      Element rootElement = doc.createElement("ExamList");
      for (int i = 0; i < exams.getNumberOfExams(); i++)
      {
        Element subElement = doc.createElement("Exam");
        Element subSubElement = doc.createElement("Exam_name");
        subSubElement.appendChild(doc.createTextNode(exams.getExam(i).getExamName()));
        subElement.appendChild(subSubElement);
        subSubElement = doc.createElement("Period");
        Element subSubSubElement = doc.createElement("Date");
        subSubSubElement.appendChild(doc.createTextNode(exams.getPeriodOfTheExamByIndex(i).getDateOfTheExam().toString()));
        subSubElement.appendChild(subSubSubElement);
        subSubSubElement = doc.createElement("StartTime");
        subSubSubElement.appendChild(doc.createTextNode(exams.getPeriodOfTheExamByIndex(i).getStartTime().toString()));
        subSubElement.appendChild(subSubSubElement);
        subSubSubElement = doc.createElement("EndTime");
        subSubSubElement.appendChild(doc.createTextNode(exams.getPeriodOfTheExamByIndex(i).getEndTime().toString()));
        subSubElement.appendChild(subSubSubElement);
        subElement.appendChild(subSubElement);
        subSubElement = doc.createElement("Classes");
        for (int j =0 ; j<exams.getExam(i).getClasses().size(); j++)
        {
          subSubSubElement = doc.createElement("Class");
          subSubSubElement.appendChild(doc.createTextNode(exams.getExam(i).getClasses().getClassByIndex(j).toString()));
          subSubElement.appendChild(subSubSubElement);
        }
        subElement.appendChild(subSubElement);
        subSubElement = doc.createElement("Teachers");
        for (int j=0; j<exams.getExam(i).getTeachers().size(); j++)
        {
          subSubSubElement = doc.createElement("Teacher");
          subSubSubElement.appendChild(doc.createTextNode(exams.getExam(i).getTeachers().getTeacherByIndex(j).toString()));
          subSubElement.appendChild(subSubSubElement);
        }
        subElement.appendChild(subSubElement);
        subSubElement = doc.createElement("Rooms");
        for (int j=0; j<exams.getExam(i).getRooms().size(); j++)
        {
          subSubSubElement = doc.createElement("Room");
          subSubSubElement.appendChild(doc.createTextNode(exams.getExam(i).getRooms().getRoomByIndex(j).toString()));
          subSubElement.appendChild(subSubSubElement);
        }

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
