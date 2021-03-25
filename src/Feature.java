
public interface Feature {
	/*
	 *  Feature accessible from a menu. Shown as item in menu list.
	 */
	
	// Get label to appear in menu
	public String getLabel();
	
	// Complete desired action
	public void run();
}
