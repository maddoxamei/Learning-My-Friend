import processing.core.*;
import processing.event.*;
import frontend.*;
import frontend.controlP5.*;
import backend.*;
import frontend.fcontrollers.*;
import java.io.File;
import java.io.IOException;

/**
 *<h1> LearningMyFriend </h1>
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
 * @author Mei Maddox (backend)
 * @version 1.0
 * @since 02.09.2019
 */

public class LearningMyFriend extends PApplet {
GUI gui;
Window win;
IOHandler h;

public float canvasX, canvasY, canvasWidth, canvasHeight;

/**
 * [main is what runs by default. This should not be called by any other class.]
 * @param passedArgs [description]
 */
	public static void main(String[] passedArgs) {
		String[] appletArgs = { "LearningMyFriend" };
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

	boolean ctrl = false, shift = false;

	public void keyReleased(){
		if(this.keyCode == 17) ctrl = false;
		if(this.keyCode == 16) shift = false;
	}

	public void keyPressed(){

		win.keyPressed(this.key, this.keyCode);

		if(this.keyCode == 17)  ctrl = true;
		if(this.keyCode == 16) shift = true;

		System.out.println(this.key+ ", "+this.keyCode + " : "+ctrl);
		System.out.println(this.key=='c'&&ctrl);

		if(this.keyCode == 90 && ctrl) this.win.delete();
		else if(this.keyCode == 89 && ctrl) this.win.restoreLast();
		else if(this.keyCode == 67 && ctrl) gui.copy();
		else if(this.keyCode == 88 && ctrl) this.win.cut();
		else if(this.keyCode == 86 && ctrl) gui.paste();

		else if(this.keyCode == 78 && ctrl) this.win.clear();
		else if(this.keyCode == 79 && ctrl){
			try {
				this.win.open("C:/Users/Mei ^.^/Desktop/drawing.polly");
			} catch (ClassNotFoundException | IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}
		else if(this.keyCode == 83 && ctrl){
			try {
				this.win.save("C:/Users/Mei ^.^/Desktop/drawing.polly");
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			}
		}

		else if(this.keyCode == 69 && ctrl) gui.export();
		else if(this.keyCode == 71 && ctrl) gui.group();
		else if(this.keyCode == 65 && ctrl) this.win.toggleComments(); //Toggles Annotations
		else if(this.keyCode == 66 && ctrl) this.win.toggleGrid();  //Toggles boxes on screen (grid)

		else if(this.key == '<') this.win.changeThickness(-.5F);
		else if(this.key == '>') this.win.changeThickness(0.5F);
		else if(this.key == '{') this.win.changeGridSpacing(-5);
		else if(this.key == '}') this.win.changeGridSpacing(5);
		else if(this.key == '|') this.win.createLine(this.mouseX, this.mouseY);
		else if(this.key == 'P') this.win.createPollyGon(this.mouseX, this.mouseY, 3);


		//else if(this.key == 'R') this.win.createRect(this.mouseX, this.mouseY);
		else if(this.key == 'T') this.win.createTextBox(this.mouseX, this.mouseY, "This is Text!", "arial", 12);
		else if(this.key == 'I') this.win.createInteractiveTextBox(this.mouseX, this.mouseY, this.mouseX + 100, "arial", 12);
		//else if(this.key == 'A') this.win.createComment(this.mouseX, this.mouseY, "This is Comment!", "arial", 12);
		//else if(this.key == 'C') this.win.createEllipse(this.mouseX, this.mouseY);

		else if(this.keyCode == 127) this.win.delete();  //delete
		else if(this.keyCode == 37) this.win.rotate(-1); //left
		else if(this.keyCode == 39) this.win.rotate(1);  //right
		else if(this.keyCode == 38) this.win.resize(0.01F);  //up
		else if(this.keyCode == 40) this.win.resize(-0.01F); //down
		else if(this.keyCode == 155) this.win.importImage("grayscrunchie",".png");

		else if(this.keyCode == 10) this.win.reCenter();   //enter
		else if(this.keyCode == 192) this.win.createCurve(this.mouseX, this.mouseY); //tilde
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

	public void mouseReleased(){
		h.mouseReleased();
	}


	public void controlEvent(ControlEvent theEvent) {
	  if(theEvent.isAssignableFrom(Textfield.class)) {
	    gui.setCurrentString(theEvent.getStringValue());
	  }
	}


}
