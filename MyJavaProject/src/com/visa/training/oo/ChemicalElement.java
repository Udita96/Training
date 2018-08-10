package com.visa.training.oo;

public class ChemicalElement {
	private int atomicNumber;
	private String symbolicName, fullName;

	public ChemicalElement(int atomicNumber, String symbolicName, String fullName) {
		this.atomicNumber = atomicNumber;
		this.symbolicName = symbolicName;
		this.fullName = fullName;
	}
	
	private static boolean[] alkalis = new boolean[120];
	
	static{
		alkalis[3] = true;
		alkalis[11] = true;
		alkalis[19] = true;
		alkalis[55] = true;
		alkalis[37] = true;
		alkalis[87] = true;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}



	public String getSymbolicName() {
		return symbolicName;
	}



	public String getFullName() {
		return fullName;
	}



	boolean isAlkaliMetal() {
		return alkalis[atomicNumber];
	}

	boolean isTransitionMetal() {
		return (atomicNumber >= 21 && atomicNumber <= 31) || (atomicNumber >= 39 && atomicNumber <= 48)
				|| (atomicNumber >= 72 && atomicNumber <= 80) || (atomicNumber >= 104 && atomicNumber <= 112);
	}

	boolean isMetal() {
		boolean metal = false;
		switch (atomicNumber) {
		case 13:
		case 49:
		case 50:
		case 81:
		case 82:
		case 83:
		case 113:
		case 114:
		case 115:
		case 116:
			metal = true;
		}
		return metal;
	}

}
