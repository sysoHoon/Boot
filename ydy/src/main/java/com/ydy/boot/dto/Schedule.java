package com.ydy.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	private int idx;
	private int mno;
	private String title;
	private String sdate;
	private String stime;
}
