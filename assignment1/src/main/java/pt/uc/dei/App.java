package pt.uc.dei;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws Exception {

        Student s1 = new Student("201134441110", "Alberto", 21);
        Student s2 = new Student("201134441116", "Patricia", 21);
        Student s3 = new Student("201134441210", "Luis", 21);

        ClassRoom classRoom = new ClassRoom(Arrays.asList(s1, s2, s3));

        JAXBContext context = JAXBContext.newInstance(ClassRoom.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

        File file = new File("class.xml");
        try (FileWriter writer = new FileWriter(file)) {

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<?xml-stylesheet type=\"text/xsl\" href=\"test.xsl\"?>\n");
            writer.write("<!-- Generated automatically. Don't change it. -->\n");

            writer.write("<h:class xmlns:h=\"http://www.dei.uc.pt/EAI\">\n");

            for (Student s : classRoom.getStudents()) {
                writer.write(String.format("  <h:student id=\"%s\">\n", s.getId()));
                writer.write(String.format("    <name>%s</name>\n", s.getName()));
                writer.write(String.format("    <age>%d</age>\n", s.getAge()));
                writer.write("  </h:student>\n");
            }

            writer.write("</h:class>\n");
        }

        System.out.println("Ficheiro gerado com sucesso!");
    }
}
