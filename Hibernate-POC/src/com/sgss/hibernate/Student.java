package com.sgss.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mn080315 student pojo class
 */

@Entity
@Table(name="STUDENT")
public class Student {

	/**
	 * student id.
	 */
	
	@Id@GeneratedValue
	@Column(name="id")
	private int id;
	/**
	 * student name.
	 */
	@Column(name="name")
	private String studentName;
	/**
	 * student Age.
	 */
	@Column(name="age")
	private int studentAge;
	/**
	 * student USN.
	 */
	@Column(name="usn")
	private String studentUSN;
	
	/**
	 * student Course .
	 */
	@Column(name="course")
	private String studentCourse;

	public Student() {
	}

	/**
	 * @param name
	 * @param age
	 * @param usn
	 * @param course
	 */
	public Student(String name, int age, String usn, String course) {

		this.studentName=name;
		this.studentAge=age;
		this.studentUSN=usn;
		this.studentCourse=course;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the studentAge
	 */
	public int getStudentAge() {
		return studentAge;
	}

	/**
	 * @param studentAge
	 *            the studentAge to set
	 */
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	/**
	 * @return the studentUSN
	 */
	public String getStudentUSN() {
		return studentUSN;
	}

	/**
	 * @param studentUSN
	 *            the studentUSN to set
	 */
	public void setStudentUSN(String studentUSN) {
		this.studentUSN = studentUSN;
	}

	/**
	 * @return the studentCourse
	 */
	public String getStudentCourse() {
		return studentCourse;
	}

	/**
	 * @param studentCourse
	 *            the studentCourse to set
	 */
	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

}
