package swing;

/**
 * @author Hugo 
 * 
 */
public class MVCSlideProject {

	/**
	 * @param args TO DO COMMENTER
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlideProjectView slideView = new SlideProjectView();

		SlideProjectModel slideModel = new SlideProjectModel();

		SlideProjectController slideController = new SlideProjectController(slideView, slideModel);

		slideView.setVisible(true);

	}

}
