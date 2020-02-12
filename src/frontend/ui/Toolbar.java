package frontend.ui;
import frontend.controlP5.*;
import frontend.handler.Handler;
import processing.core.*;
import java.util.ArrayList;

/**
  * <h1>Toolbar/h1>
  *
  * @author Hunter Chasens
  * @version 1.0
  * @since 02.09.2019
 */

import frontend.controlP5.*;


public abstract class Toolbar{
  ControlP5 cp5;
  //Handler is present so the Toolbar can register it's controllers
  Handler h;
  PApplet sketch;
  ArrayList<ScalableObj> controllers;

  public Toolbar(ControlP5 cp5, Handler h, PApplet sketch){
    this.cp5 = cp5;
    this.h = h;
    this.sketch = sketch;
    controllers = new ArrayList<ScalableObj>();
  }


  public void update(){
    for(ScalableObj c : controllers)
      c.update();
  }



    /*public ScalableObj ScalableObjFactory(){


    }*/
}