package top.soest.dto;

import lombok.Data;

@Data
public class ManagerDTO {
	private Long id;

	private Integer degree;

	private String name;

	private String userName;

	private String account;

	private String password;
}
