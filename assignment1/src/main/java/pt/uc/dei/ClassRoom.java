package pt.uc.dei;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "class")
public class ClassRoom {
    private List<Student> students;

    public ClassRoom(List<Student> students) {
        this.students = students;
    }

    public ClassRoom() {}

    @XmlElement(name = "student", namespace = "")
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
