package com.sellup.boot.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private int admin_board_id;
	private String id;
	private String filename;
	private String title;
	private Date wdate;
}
