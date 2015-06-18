/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * Array of an workbook
 *
 * @author Sergio
 */
public class Array extends Variable implements Serializable {

	private Vector<Value> positions;

	private int actualPosition;

	public Array(String name, Value value, Workbook workbook, int position) {
		super(name, value, workbook);
		this.actualPosition = position;

	}

	public void initializePositions() {
		this.positions = new Vector<Value>();
		for (int i = 0; i < 10000; i++) {
			positions.add(new Value(""));
		}
	}

	public int getActualPosition() {
		return actualPosition;
	}

	public void setActualPosition(int actualPosition) {
		this.actualPosition = actualPosition;
	}

	public Vector<Value> getPositions() {
		return positions;
	}

	public void setPositions(Vector<Value> positions) {
		this.positions = positions;
	}

	public Value getPositionValue(int position) {
		return positions.get(position);
	}

	public void setPositionValue(int position, Value newValue) {
		this.positions.add(position, newValue);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public Value getValue() {
		return super.getValue();
	}

	@Override
	public void setValue(Value value) {
		super.setValue(value);
	}

	@Override
	public Workbook getWorkbook() {
		return super.getWorkbook();
	}
}
