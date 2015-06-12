/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core;

import java.io.Serializable;

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

	public Variable(String name, Value value, Workbook workbook) {
		this.name = name;
		this.value = value;
                this.workbook=workbook;
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

	public int compareTo(Variable otherVariable) {
		if (this.name == otherVariable.getName()) {
			return 0;
		}

		return -1;
	}
        
        

}
