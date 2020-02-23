package backend.objects;
import java.io.Serializable;

import backend.TextObjectExample;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PConstants;

class TextBoxExample extends TextObjectExample implements Serializable {
    private static final long serialVersionUID = 8L;
    private String str, font;
    private float textSize;
    transient private PFont pFont;

  public TextBoxExample(PApplet sketch, float x, float y, float strokeWeight, int[] fillColor, int[] boarderColor, String str, String font, float textSize){
    super(sketch, x, y, strokeWeight, fillColor, boarderColor, str, font, textSize);
  }

  protected void display(){
        super.display();
        sketch.text(str, 0, 0);
  }
}