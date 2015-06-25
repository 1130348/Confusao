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
 * Variable of an workbook
 *
 * @author 1130395
 */
public class Variable implements Comparable<Variable>, Serializable {

	private String name;

	private Value value;

	private Workbook workbook;

	private Vector<Value> positions;

	private int actualPosition;

	public Variable(String name, Value value, Workbook workbook,
					int actualPosition) {
		this.name = name;
		this.value = value;
		this.workbook = workbook;
		this.actualPosition = actualPosition;
	}

	public void initializePositions() {
		this.positions = new Vector<Value>();
		for (int i = 0; i < 10000; i++) {
			positions.add(new Value(""));
		}
	}

	public String getName() {
		return name;
	}

	public Value getValue() {
		return value;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setValue(Value value) {
		this.value = value;
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

	public int compareTo(Variable otherVariable) {
		if (this.name == otherVariable.getName()) {
			return 0;
		}

		return -1;
	}
        
        @Override
        public String toString()
        {
            return name;
        }
}
