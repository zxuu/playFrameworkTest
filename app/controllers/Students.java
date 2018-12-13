package controllers;

import models.Student;
import org.hibernate.annotations.Check;
import play.mvc.With;

@With(Secure.class)
public class Students extends CRUD {
	
	@Check(constraints = "studentNameModify")
	public static void modifyName(String id){
		Student object = Student.findById(Long.parseLong(id));
		render("@changename", object);
	}

	public static void doModifyName(Student object){
		Student st = Student.findById(object.id);

		if (null != object.nameString) {
			// 保存新名字
			st.nameString = object.nameString;
			st.save();
			render("@modifynamedone", object);
		}
	}

//	@Check(constraints = "studentXuefenModify")
	public static void modifyXuefen(String id) {
		Student object = Student.findById(Long.parseLong(id));
		render("@changexuefen", object);
	}

	public static void doModifyXuefen(Student object) {
		Student st = Student.findById(object.id);
		if (null != object.xuefen) {
			//保存新学分
			st.xuefen = object.xuefen;
			st.save();
			render("@modifyxuefendone", object);
		}
	}

}
