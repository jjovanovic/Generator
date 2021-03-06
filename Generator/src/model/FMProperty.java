package model;

public class FMProperty extends FMNamedElement  {
	
	private String type;
	private String visibility; 
	private Integer lower;
	private Integer upper;
	private Group group;
	private DBProperty dbProperty;
	private UIProperty uiProperty;
    private boolean enumerated;
    private FMType reference;

	
	/**
	 * 
	 * @param name 
	 * @param type
	 * @param visibility private, protected, public, ?
	 * @param lower Donja granica kardinaliteta
	 * @param upper Gornja granica kardinaliteta. -1 znaÄ�i *
	 */
	public FMProperty(String name, String type, String visibility, int lower, int upper) {
		super(name);		
		this.type = type;
		this.visibility = visibility;
		
		this.lower = lower;
		this.upper = upper;		
	}
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public DBProperty getDbProperty() {
		return dbProperty;
	}

	public void setDbProperty(DBProperty dbProperty) {
		this.dbProperty = dbProperty;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}

	public UIProperty getUiProperty() {
		return uiProperty;
	}

	public void setUiProperty(UIProperty uiProperty) {
		this.uiProperty = uiProperty;
	}
	
	public boolean isEnumerated() {
		return enumerated;
	}

	public void setEnumerated(boolean enumerated) {
		this.enumerated = enumerated;
	}

	public FMType getReference() {
		return reference;
	}

	public void setReference(FMType reference) {
		this.reference = reference;
	}

	public boolean isEditable(){
		if(uiProperty!=null && uiProperty instanceof ReadOnly){
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public String toString() {
		return "FMProperty [type=" + type + ", visibility=" + visibility + ", lower=" + lower + ", upper=" + upper
				+ ", group=" + group + ", dbProperty=" + dbProperty + ", uiProperty=" + uiProperty + "]";
	}
	
}
