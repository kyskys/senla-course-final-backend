package com.senla.impl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senla.api.controller.Controller;
import com.senla.api.service.*;
import com.senla.entity.*;

@Service
public class ControllerImpl implements Controller {
	@Autowired
	private CourseService courseService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private LectionService lectionService;
	@Autowired
	private LecturerService lecturerService;
	@Autowired
	private MarkService markService;
	@Autowired
	private PairService pairService;
	@Autowired
	private StudentService studentService;

	@Override
	public Course getCourse(Long id) {
		return courseService.get(id);
	}

	@Override
	public Group getGroup(Long id) {
		return groupService.get(id);
	}

	@Override
	public Lection getLection(Long id) {
		return lectionService.get(id);
	}

	@Override
	public Lecturer getLecturer(Long id) {
		return lecturerService.get(id);
	}

	@Override
	public Mark getMark(Long id) {
		return markService.get(id);
	}

	@Override
	public Pair getPair(Long id) {
		return pairService.get(id);
	}

	@Override
	public Student getStudent(Long id) {
		return studentService.get(id);
	}

	@Override
	public boolean createCourse(Course course) {
		return courseService.create(course);
	}

	@Override
	public boolean createGroup(Group group) {
		return groupService.create(group);
	}

	@Override
	public boolean createLection(Lection lection) {
		return lectionService.create(lection);
	}

	@Override
	public boolean createLecturer(Lecturer lecturer) {
		return false;
	}

	@Override
	public boolean createMark(Mark mark) {
		return markService.create(mark);
	}

	@Override
	public boolean createPair(Pair pair) {
		return pairService.create(pair);
	}

	@Override
	public boolean createStudent(Student student) {
		return studentService.create(student);
	}

	@Override
	public boolean deleteCourse(Course course) {
		return courseService.delete(course);
	}

	@Override
	public boolean deleteGroup(Group group) {
		return groupService.delete(group);
	}

	@Override
	public boolean deleteLection(Lection lection) {
		return lectionService.delete(lection);
	}

	@Override
	public boolean deleteLecturer(Lecturer lecturer) {
		return lecturerService.delete(lecturer);
	}

	@Override
	public boolean deleteMark(Mark mark) {
		return markService.delete(mark);
	}

	@Override
	public boolean deletePair(Pair pair) {
		return pairService.delete(pair);
	}

	@Override
	public boolean deleteStudent(Student student) {
		return studentService.delete(student);
	}

	@Override
	public boolean updateCourse(Course course) {
		return courseService.update(course);
	}

	@Override
	public boolean updateGroup(Group group) {
		return groupService.update(group);
	}

	@Override
	public boolean updateLection(Lection lection) {
		return lectionService.update(lection);
	}

	@Override
	public boolean updateLecturer(Lecturer lecturer) {
		return lecturerService.update(lecturer);
	}

	@Override
	public boolean updateMark(Mark mark) {
		return markService.update(mark);
	}

	@Override
	public boolean updatePair(Pair pair) {
		return pairService.update(pair);
	}

	@Override
	public boolean updateStudent(Student student) {
		return studentService.update(student);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseService.getAll();
	}

	@Override
	public List<Group> getAllGroups() {
		return groupService.getAll();
	}

	@Override
	public List<Lection> getAllLections() {
		return lectionService.getAll();
	}

	@Override
	public List<Lecturer> getAllLecturers() {
		return lecturerService.getAll();
	}

	@Override
	public List<Mark> getAllMarks() {
		return markService.getAll();
	}

	@Override
	public List<Pair> getAllPairs() {
		return pairService.getAll();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentService.getAll();
	}

}
