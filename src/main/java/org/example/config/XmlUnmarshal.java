package org.example.config;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.example.model.Student;
import org.example.model.Students;

import java.io.File;
import java.util.List;

public class XmlUnmarshal {

    public static void unmarshalling() {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Students students = (Students) unmarshaller.unmarshal(new File("students1.xml"));

            List<Student> studentsList = students.getStudents();

            for (Student student : studentsList) {
                System.out.println(student);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
