package com.streisky.sevendaysofcode.model;

import java.util.List;

public class Top250Data {

	private List<Top250DataDetail> items;
	private String messageError;
	
	public Top250Data(List<Top250DataDetail> items, String messageError) {
		super();
		this.items = items;
		this.messageError = messageError;
	}
	
	public List<Top250DataDetail> getItems() {
		return items;
	}
	public void setItems(List<Top250DataDetail> items) {
		this.items = items;
	}
	public String getMessageError() {
		return messageError;
	}
	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	@Override
	public String toString() {
		return "GeneralInfo [items=" + items.toString() + ", messageError=" + messageError + "]"
				+ "\n";
	}
}
