package swing;

/**
 * @author Hugo
 *
 */
public class SlideProjectModel {

	String[] listFilm = {
			"SlideShowMovie/avenger.jpg",//1
			"SlideShowMovie/diversion.jpg",//2
			"SlideShowMovie/harrypotter.jpg",//3
			"SlideShowMovie/avatar.jpg",//0
			"SlideShowMovie/persia.jpg",//4
			"SlideShowMovie/sherlockholms.jpg",//5
			"SlideShowMovie/taxi.jpg",//6
			"SlideShowMovie/wonderwoman.jpg"//7
			/*"E:/SlideShow/avenger.jpg",
    		"E:/SlideShow/diversion.jpg",
    		"E:/SlideShow/harrypotter.jpg",
    		"E:/SlideShow/avatar.jpg",
    		"E:/SlideShow/persia.jpg",
    		"E:/SlideShow/sherlockholms.jpg",
    		"E:/SlideShow/taxi.jpg"*/
	};

	/**
	 * @param key
	 * @return Getter
	 */
	public String getlistFilm(int key){
		return listFilm[key];
	}
	/**
	 * @return Renvoie la taille de la liste de film.
	 */
	public String[] sizelistFilm(){
		return listFilm;
	}


}
