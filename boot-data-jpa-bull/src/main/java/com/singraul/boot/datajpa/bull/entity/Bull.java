package com.singraul.boot.datajpa.bull.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tt_bull")
public class Bull {
	@Id
	private int bullId;
	private String bullName;
	private String bullColor;
	private int bullAge;

	public int getBullId() {
		return bullId;
	}

	public void setBullId(int bullId) {
		this.bullId = bullId;
	}

	public String getBullName() {
		return bullName;
	}

	public void setBullName(String bullName) {
		this.bullName = bullName;
	}

	public String getBullColor() {
		return bullColor;
	}

	public void setBullColor(String bullColor) {
		this.bullColor = bullColor;
	}

	public int getBullAge() {
		return bullAge;
	}

	public void setBullAge(int bullAge) {
		this.bullAge = bullAge;
	}

	@Override
	public String toString() {
		return "Bull [bullId=" + bullId + ", bullName=" + bullName + ", bullColor=" + bullColor + ", bullAge=" + bullAge
				+ "]";
	}
}
