package com.senla.api.service;

import com.senla.entity.Mark;

public interface MarkService extends AbstractService<Mark> {
	boolean addGroupToPair(Long idGroup, Long idPair);

	boolean removeGroupFromPair(Long idGroup, Long idPair);

	boolean addMarkToPair(Long idMark, Long idPair);

	boolean removeMarkFromPair(Long idMark, Long idPair);

}
