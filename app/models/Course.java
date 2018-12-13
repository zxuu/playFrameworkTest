package models;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends Model{
    @Required
    public String namecourse;
    @Required
    public String keshi;

    @ManyToMany(mappedBy = "myCourse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Student> students;

    @Override
    public String toString() {
        return this.namecourse;
    }
}
