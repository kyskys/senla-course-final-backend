package com.senla.api.service;

import com.senla.entity.Mark;

public interface MarkService extends AbstractService<Mark> {

	void addPairToMark(Long idPair, Long idMark);

	void addStudentToMark(Long idStudent, Long idMark);
}
