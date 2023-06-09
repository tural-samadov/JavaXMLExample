package org.example.config;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.model.Student;
import org.example.model.Students;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class XmlMarshal {

    public static void marshalling() {
        Student student1 = new Student("Tural", "Samadov");
        Student student2 = new Student("Kamran", "Mammadov");
        Student student3 = new Student("Vasif", "Aliyev");
        Student student4 = new Student("Ilkin", "Suleymanov");

        List<Student> studentList = Arrays.asList(student1, student2, student3, student4);

        Students students = new Students(studentList);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Students.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(students, new File("students1.xml"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
