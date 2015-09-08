package AddressBook;


public class Category {

	public String catName;

	
	public Category(String catName) {

		this.catName = catName;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}
	
	public Category addCategory (String catName){
	return   new Category(catName);
}
	
	static Category Cat1 = new Category ("Family");
	static Category Cat2 = new Category ("Colleagues");
	static Category Cat3 = new Category ("Friends");
	
	

}
