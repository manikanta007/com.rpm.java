package com.sgss.hibernate;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class StudentManage {

	private static SessionFactory factory;

	public static void main(String[] arg) {
		try {
			// factory = new Configuration().configure().buildSessionFactory();
			factory = new AnnotationConfiguration()
					.addAnnotatedClass(Student.class).configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("unable to create sessstion factroy .." + ex);
			ex.printStackTrace();
		}

		StudentManage studentManage = new StudentManage();
		// studentManage.addStudent("mani", 24, "mca28", "mca");
		// studentManage.addStudent("joshi", 26, "mca12", "mca");
		// studentManage.addStudent("santu", 25, "mca54", "mca");
		// studentManage.deleteStudent(22);
//		studentManage.listStudent();
//		studentManage.updateStudent();
//		studentManage.listStudent();
		studentManage.nativeSQL();
	}

	private void nativeSQL() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx=session.beginTransaction();
//			SQLQuery query=session.createSQLQuery("select name from Student");
//			SQLQuery query=session.createSQLQuery("select * from Student");
			SQLQuery query=session.createSQLQuery("select * from Student where age=:age");
			query.setParameter("age", 24);
//			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			query.addEntity(Student.class);
			List students=query.list();
			
//			for (int i = 0; i < students.size(); i++) {
//				System.out.println(students.get(0));
//			}
			
			
			for (Iterator iterator = students.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				
				System.out.println(student.getId()+"\t"+student.getStudentName()+"\t"+student.getStudentUSN()+"\t"+student.getStudentAge()+"\t"+student.getStudentAge());
			}
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}
		finally{
			session.close();
		}
	}

	private void updateStudent() {

		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			Scanner sc = new Scanner(System.in);
			System.out.println("Please Enter the student id.");
			int usn = sc.nextInt();
			System.out.println("Please Enter the student name.");
			String name = sc.next();
			Student student = (Student) session.get(Student.class, usn);
			student.setStudentName(name);
			session.update(student);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}

		finally {
			session.close();
		}
	}

	private void deleteStudent(int i) {

		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Student student = (Student) session.get(Student.class, i);
			session.delete(student);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		}

		finally {
			session.close();
		}

	}

	private void listStudent() {

		Session session = factory.openSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			// String
			// hsql="select studentName from Student where studentUSN=:usn";
			String hsql = "select studentName from Student ";
			org.hibernate.Query q = session.createQuery(hsql);
			// q.setParameter("usn", "mca28");
			List allStudent = q.list();

			Criteria cr = session.createCriteria(Student.class);
			cr.add(Restrictions.like("studentUSN", "%28%"));
			allStudent = cr.list();
			for (Iterator iterator = allStudent.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				System.out.println(student.getStudentName());
			}
			
			System.out.println("id\tname\tage\tusn\tcourse\n");
			for (Iterator iterator = allStudent.iterator(); iterator.hasNext();) {
				Student student = (Student) iterator.next();
				System.out.print(student.getId() + "\t"
						+ student.getStudentName() + "\t"
						+ student.getStudentAge() + "\t"
						+ student.getStudentUSN() + "\t"
						+ student.getStudentCourse());
				System.out.println("\n");
			}

			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}

		} finally {
			session.close();
		}

	}

	private void addStudent(String name, int age, String usn, String course) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student = new Student(name, age, usn, course);
			session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {
			session.close();
		}
	}

}
