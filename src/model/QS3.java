package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;
import model.DBUtil; 

public class QS3 { 
	public String Studentrec() { 
		String result="";
		EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
		try { 
			model.StudentGradebook stud = em.find(model.StudentGradebook.class, (long)2);
			result=stud.getGrade().toString();
			System.out.println(stud.getGrade()); 
		} catch (Exception e){ 
			System.out.println(e); 
		} finally { 
			em.close(); 
			System.out.println("cerrado!"); 
		}
		return result; 
	} 

	public TypedQuery <StudentGradebook> FindWithtype (String Ass_name){
		EntityManager em1 = DBUtil.getEmFactory().createEntityManager();

		return em1.createQuery(
				"SELECT gb FROM StudentGradebook gb WHERE gb.assignmentType LIKE :ass",StudentGradebook.class)
				.setParameter("ass", Ass_name);
	}

}
