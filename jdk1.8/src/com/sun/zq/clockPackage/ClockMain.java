package com.sun.zq.clockPackage;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import javax.swing.text.DateFormatter;

public class ClockMain {

	public static void main(String[] args) throws InterruptedException {
		Clock clock = Clock.systemDefaultZone();
		long millis0 = clock.millis();
		Thread.sleep(2000L);
		long millis1 = clock.millis();
		System.out.println(millis1-millis0);
		
		Instant instant = clock.instant();
		
		Date date = Date.from(instant);
		System.out.println(date.getDate());
		
		System.out.println(ZoneId.getAvailableZoneIds());
		ZoneId zi1 = ZoneId.of("Etc/GMT+8");
		ZoneId zi2 = ZoneId.of("Asia/Aden");
		System.out.println(zi1.getRules());
		System.out.println(zi2.getRules());
		
		LocalTime localTime1 = LocalTime.now(zi1);
		LocalTime localTime2 = LocalTime.now(zi2);
		System.out.println(localTime1.isBefore(localTime2));
		
		long hours = ChronoUnit.HOURS.between(localTime1, localTime2);
		long minutes= ChronoUnit.MINUTES.between(localTime1, localTime2);
		long millis = ChronoUnit.MILLIS.between(localTime1, localTime2);
		
		System.out.println(hours);
		System.out.println(minutes);
		System.out.println(millis);
		
		
		LocalTime time = LocalTime.of(17, 34, 23);
		System.out.println(time);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).
				withLocale(Locale.GERMANY);
		LocalTime lt = LocalTime.parse("13:37", formatter);
		System.out.println(lt);
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		LocalDate tomorrow = localDate.plusDays(1);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println(tomorrow);
		System.out.println(yesterday);
		System.out.println(yesterday.getDayOfWeek());
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).
				withLocale(Locale.GERMANY);
		LocalDate ld = LocalDate.parse("24.12.2014", dateFormatter);
		System.out.println(ld);
		
		System.out.println("-------���ڽ���---------");
		
		LocalDateTime ldt = LocalDateTime.of(2017, 8, 15, 18, 23,34);
		System.out.println(ldt.getDayOfWeek());
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getMonth());
		System.out.println(ldt.getLong(ChronoField.MINUTE_OF_DAY));
		
		DateTimeFormatter def = DateTimeFormatter.ofPattern("MMM dd,yyyy-HH:mm");
		LocalDateTime ldtime = LocalDateTime.of(2017, 8, 15, 18, 23,34);
		String ddate = def.format(ldtime);
		System.out.println(ddate);
		
	}

}
