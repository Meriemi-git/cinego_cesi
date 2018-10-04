package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author Hugo
 * MVC CONTROLLER WHERE ALL THE MAGIC HAPPENS!
 */
public class SlideProjectController {
	int u = 0;
	int v = 1;
	int w = 2;
	int x = 3;
	private SlideProjectView slideView;
	private SlideProjectModel slideModel;

	SlideProjectController(SlideProjectView slideView, SlideProjectModel slideModel){

		this.slideView = slideView;
		this.slideModel = slideModel;

		this.slideView.addNextButtonListener(new NextButtonListener());
		this.slideView.addBackButtonListener(new BackButtonListener());
		this.slideView.addTimerListener(new TimerListener());

		for(int i = 0; i<4; i++){
			slideView.getlistLabel(i).setSize(200, 270);
			slideView.SetImageSize(slideView.getlistLabel(i), slideModel.getlistFilm(i));
		}
	}
	class TimerListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub          
			u += 1;
			if(u >= slideModel.sizelistFilm().length )
				u = 0; 
			slideView.SetImageSize(slideView.listLabel[0], slideModel.listFilm[u]);     
			v += 1;
			if(v >=  slideModel.sizelistFilm().length )
				v = 0; 
			slideView.SetImageSize(slideView.listLabel[1], slideModel.listFilm[v]);       
			w += 1;
			if(w >=  slideModel.sizelistFilm().length )
				w = 0; 
			slideView.SetImageSize(slideView.listLabel[2], slideModel.listFilm[w]);       
			x += 1;
			if(x >=  slideModel.sizelistFilm().length )
				x = 0; 
			slideView.SetImageSize(slideView.listLabel[3], slideModel.listFilm[x]);   
		}
	}		

	class BackButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				slideView.SetImageSize(slideView.getlistLabel(0), slideModel.getlistFilm(u));
				u -= 1;
				if(u < 0)
					u = slideModel.sizelistFilm().length-1;
				if(u > slideModel.sizelistFilm().length)
					u = 0;

				slideView.SetImageSize(slideView.getlistLabel(1), slideModel.getlistFilm(v));
				v -= 1;
				if(v < 0)
					v = slideModel.sizelistFilm().length-1;
				if(v > slideModel.sizelistFilm().length)
					v = 1;

				slideView.SetImageSize(slideView.getlistLabel(2), slideModel.getlistFilm(w));
				w -= 1;
				if(w < 0)
					w = slideModel.sizelistFilm().length-1;
				if(w > slideModel.sizelistFilm().length)
					w = 2;

				slideView.SetImageSize(slideView.getlistLabel(3), slideModel.getlistFilm(x));
				x -= 1;
				if(x < 0 )
					x = (slideModel.sizelistFilm().length)-1;
				if(x > slideModel.sizelistFilm().length)
					x = 3;
			} catch (ArrayIndexOutOfBoundsException a)
			{
				a.printStackTrace();
			}

		}

	}

	class NextButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			u += 1;
			if(u >= slideModel.sizelistFilm().length )
				u = 0; 
			slideView.SetImageSize(slideView.getlistLabel(0), slideModel.getlistFilm(u));
			// need a list of  
			v += 1;
			if(v >= slideModel.sizelistFilm().length )
				v = 0; 
			slideView.SetImageSize(slideView.getlistLabel(1), slideModel.getlistFilm(v));

			w += 1;
			if(w >= slideModel.sizelistFilm().length )
				w = 0; 
			slideView.SetImageSize(slideView.getlistLabel(2), slideModel.getlistFilm(w));

			x += 1;
			if(x >= slideModel.sizelistFilm().length )
				x = 0; 
			slideView.SetImageSize(slideView.getlistLabel(3), slideModel.getlistFilm(x));


		}
	}
}