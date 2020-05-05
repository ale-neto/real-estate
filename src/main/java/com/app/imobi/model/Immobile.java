package com.app.imobi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="immobile")
public class Immobile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Proprietor proprietor;
	@Column(name="address", nullable=false, length=250) 
	private String address;
	@Column(name="landArea", nullable=false)
	private double landArea;
	@Column(name="buildingArea", nullable=false)
	private double buildingArea;
	@Column(name="totalArea", nullable=false)
	private double totalArea;
	@Column(name="aliquot", nullable=false)
	private double aliquot;
	@Column(name="landVenalValue", nullable=false)
	private double landVenalValue;
	@Column(name="venalConstructionlValue", nullable=false)
	private double venalConstructionlValue;
	@Column(name="totalVenalValue", nullable=false)
	private double totalVenalValue;
	@Column(name="appliedRate", nullable=false)
	private double appliedRate;
	@Column(name="taxAmount", nullable=false)	
	private double taxAmount;
	
	/**********************************************/
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Proprietor getProprietor() {
		return proprietor;
	}
	public void setProprietor(Proprietor proprietor) {
		this.proprietor = proprietor;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLandArea() {
		return landArea;
	}
	public void setLandArea(double landArea) {
		this.landArea = landArea;
	}
	public double getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(double buildingArea) {
		this.buildingArea = buildingArea;
	}
	public double getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}
	public double getAliquot() {
		return aliquot;
	}
	public void setAliquot(double aliquot) {
		this.aliquot = aliquot;
	}
	public double getLandVenalValue() {
		return landVenalValue;
	}
	public void setLandVenalValue(double landVenalValue) {
		this.landVenalValue = landVenalValue;
	}
	public double getVenalConstructionlValue() {
		return venalConstructionlValue;
	}
	public void setVenalConstructionlValue(double venalConstructionlValue) {
		this.venalConstructionlValue = venalConstructionlValue;
	}
	public double getTotalVenalValue() {
		return totalVenalValue;
	}
	public void setTotalVenalValue(double totalVenalValue) {
		this.totalVenalValue = totalVenalValue;
	}
	public double getAppliedRate() {
		return appliedRate;
	}
	public void setAppliedRate(double appliedRate) {
		this.appliedRate = appliedRate;
	}
	public double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}
}
