package com.senla.dao.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateFormatterUtil {
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

	public static String getDateAsString(LocalDateTime date) {
		return date.format(DATE_FORMATTER);
	}

	public static LocalDateTime getDateFromString(String date) {
		return date != null ? LocalDateTime.of(LocalDate.parse(date, DATE_FORMATTER),LocalTime.of(3, 0)) : null;
	}

	public static String getTimeAsString(LocalTime time) {
		return time.format(TIME_FORMATTER);
	}

	public static LocalTime getTimeFromString(String time) {
		return time != null ? LocalTime.parse(time, TIME_FORMATTER) : null;
	}
}
