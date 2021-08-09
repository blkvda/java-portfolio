import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement
public class User {
    private int id;
    private int age;
    private String name;
    private ContactInfo contactInfo;
    private List<Experience> experiencesArray;

    //пустой конструктор необходим для работы с библиотекой Jackson
    public User() {}

    public User(int id, int age, String name, ContactInfo contactInfo, List<Experience> experiencesArray) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.contactInfo = contactInfo;
        this.experiencesArray = experiencesArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "contactInfo")
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    @XmlElementWrapper(name = "experienceInfo")
    @XmlElement(name = "experience")
    public List<Experience> getExperiencesArray() {
        return experiencesArray;
    }

    public void setExperiencesArray(List<Experience> experiencesArray) {
        this.experiencesArray = experiencesArray;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", contactInfo=" + contactInfo +
                ", experiencesArray=" + experiencesArray +
                '}';
    }
}
