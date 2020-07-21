package com.kwon.db.main;

import java.math.BigDecimal;

public class DataSelector {
	private BigDecimal start;
	private BigDecimal end;
	
	public DataSelector() {
		// TODO Auto-generated constructor stub
	}

	public DataSelector(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
}
