package com.iuh.se.BanDoGiaDung.dto;

public abstract class AbstractDTO {
	private int id;

	public AbstractDTO() {
		super();
	}

	public AbstractDTO(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AbstractDTO [id=" + id + "]";
	}

}
