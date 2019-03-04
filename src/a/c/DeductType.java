package a.c;
/**
 * 枚举类型，扣分方式
 * @author cheny
 *
 */
public enum DeductType {

	DEDUCTEVERY("DEDUCT_EVERY"),
	DEDUCTONCE("DEDUCT_ONCE");
	
	private String value;
	
	DeductType(String value){
		this.value = value;
	}
	
	public static DeductType get(String value){
		switch (value) {
			case "DEDUCT_EVERY" :
				return DEDUCTEVERY;
			case "DEDUCT_ONCE" :
				return DEDUCTONCE;
		}
		return null;
	}
	
	public String toString(){
		return value;
	}
}
