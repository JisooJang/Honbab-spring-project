package org.springframework.samples.honbab.domain;

import java.io.Serializable;

//original : pieChartData
@SuppressWarnings("serial")
public class Ranking implements Serializable{

	private String rest_ctg;
	private String count_ctg;
	public String getRest_ctg() {
		return rest_ctg;
	}
	public void setRest_ctg(String rest_ctg) {
		this.rest_ctg = rest_ctg;
	}
	public String getCount_ctg() {
		return count_ctg;
	}
	public void setCount_ctg(String count_ctg) {
		this.count_ctg = count_ctg;
	}
	public Ranking(String rest_ctg, String count_ctg) {
		super();
		this.rest_ctg = rest_ctg;
		this.count_ctg = count_ctg;
	}
	
	public Ranking(){
		super();
	
	}
	
}
