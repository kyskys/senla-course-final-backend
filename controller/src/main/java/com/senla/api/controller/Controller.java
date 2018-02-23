package com.senla.api.controller;

import java.util.List;

import com.senla.entity.*;

public interface Controller {
	
	Course getCourse(Long id);
	Group getGroup(Long id);
	Lection getLection(Long id);
	Lecturer getLecturer(Long id);
	Mark getMark(Long id);
	Pair getPair(Long id);
	Student getStudent(Long id);
	
	boolean createCourse(Course course);
	boolean createGroup(Group group);
	boolean createLection(Lection lection);
	boolean createLecturer(Lecturer lecturer);
	boolean createMark(Mark mark);
	boolean createPair(Pair pair);
	boolean createStudent(Student student);
	
	boolean deleteCourse(Course course);
	boolean deleteGroup(Group group);
	boolean deleteLection(Lection lection);
	boolean deleteLecturer(Lecturer lecturer);
	boolean deleteMark(Mark mark);
	boolean deletePair(Pair pair);
	boolean deleteStudent(Student student);
	
	boolean updateCourse(Course course);
	boolean updateGroup(Group group);
	boolean updateLection(Lection lection);
	boolean updateLecturer(Lecturer lecturer);
	boolean updateMark(Mark mark);
	boolean updatePair(Pair pair);
	boolean updateStudent(Student student);
	
	List<Course> getAllCourses();
	List<Group> getAllGroups();
	List<Lection> getAllLections();
	List<Lecturer> getAllLecturers();
	List<Mark> getAllMarks();
	List<Pair> getAllPairs();
	List<Student> getAllStudents();
}
