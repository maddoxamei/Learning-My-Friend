import processing.core.*;
import processing.event.*;
import frontend.*;
import frontend.controlP5.*;
import backend.*;
import frontend.fcontrollers.*;


/**
 *<h1> PollyPaint </h1>
 * This is our primary class. Our `main` method is stored here. When launching the program this is what launches.
 *
 * This is our `sketch` and it is broken into five methods.
 * <h4>main</h4>
 * 	This is called first and passes any arguments to PApplets.
 * <h4>settings</h4>
 *  "The settings() function is necessary when using Processing code outside of the Processing Development Environment (PDE).
 *  For example, when using the Eclipse code editor, it's necessary to use settings() to define the size() and smooth() values for a sketch." ~ Processing Docs
 *  Here we enbale smoth() which is anti-aliasing (aa). We can increase this by using smoth(4) for x4 aa, or smoth(8) for x8 aa.
 * <h4>setup</h4>
 * 	Setup runs once at the start of the program. We can build and define things here.
 * <h4>draw</h4>
 *  Draw gets called with the framerate.
 * <h4>controlEvent</h4>
 * 	controEvent is called by `controlP5`. It then passes all events generated by the gui to the handler where it is parsed.
 *
 *
 *
 * <h3>Frontend</h3>
 *
 * <h3>Backend</h3>
 *
 *
 *
 * @author Hunter Chasens
 * @version 1.0
 * @since 02.09.2019
 */

public class PollyPaint extends PApplet {
GUI gui;
Window win;
IOHandler h;

public float canvasX, canvasY, canvasWidth, canvasHeight;

/**
 * [main is what runs by default. This should not be called by any other class.]
 * @param passedArgs [description]
 */
	public static void main(String[] passedArgs) {
		String[] appletArgs = { "PollyPaint" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
    }



/**
 * [settings provides settings to PApplet befor init]
 */
	public void settings() {
		size(1000, 500);
		// The size here is good for hidpi monitors
		//size(1500, 1500/2);
		smooth(8);
	}


/**
 * [setup provides instructions to PApplet after init]
 */
	public void setup(){
		surface.setResizable(true);

		//Init Canvas Position and Size in center of the screen
	 	canvasX = width/4;
		canvasY  = height/4;
		canvasWidth = width/2;
		canvasHeight = height/2;


		win = new Window(this, canvasX, canvasY, canvasWidth, canvasHeight);
		gui = new GUI(this, win);
		h = new IOHandler(this, win, gui);
	}

/**
 * [draw description]
 */
	public void draw(){
		background(64);
		win.display();
		gui.display();
	}




	public void mouseDragged() {
			h.mouseDragged();
	}


	public void mouseClicked(){
		//if the mouse is on the canvas
		h.mouseClicked();

	}

	public void mouseWheel(MouseEvent event) {
	 h.mouseWheel(event);
	}





}
