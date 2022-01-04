import processing.core.PApplet;

public class Sketch extends PApplet {

  /**
   * state global variables
   * 
   */

  // Sun Coordinates
  public float SunX = 0;
  public float SunY = 0;

  // Moon Coordinates
  public float MoonX = 0;
  public float MoonY = 0;

  // Boolean Values (If day == false, it is night)
  public boolean Day = true;

  // Sky RGB Colour (Note: When RGB goes up, it gets lighter, goes down it gets
  // darker)
  public int SkyR = 0;
  public int SkyG = 0;
  public int SkyB = 0;

  // Ground RGB Colour
  public int GroundR = 102;
  public int GroundG = 51;
  public int GroundB = 0;

  // Grass RGB Colour
  public int GrassR = 0;
  public int GrassG = 153;
  public int GrassB = 0;

  public void settings() {
    // put your size call here
    size(600, 500);
  }

  /**
   * Called once at the beginning of execution. Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // Animation for if it is day
    if (Day == true) {
      background(SkyR, SkyG, SkyB);

      // Making the sky lighter if the sun has not reached its peak
      if (SkyR < 123 && SunX < width / 2) {
        SkyR += 3;
      }
      if (SkyG < 174 && SunX < width / 2) {
        SkyG += 3;
      }
      if (SkyB < 225 && SunX < width / 2) {
        SkyB += 3;
      }

      // Making the ground and grass ligher if the sun has not reached its peak
      if (SunX < width / 2) {
        GrassR += 1;
        GrassG += 1;
        GrassB += 1;
        GroundR += 1;
        GroundG += 1;
        GroundB += 1;
      }

      // Making the sky, ground and grass darker once the sun has reaches its peak
      else if (SunX > width / 2) {
        SkyR -= 2;
        SkyG -= 2;
        SkyB -= 2;
        GrassR -= 0.1;
        GrassG -= 0.1;
        GrassB -= 0.1;
        GroundR -= 0.1;
        GroundG -= 0.1;
        GroundB -= 0.1;
      }

      // Sun Colour
      fill(255, 255, 0);

      // Increasing the x coordinate of sun by a speed
      SunX += 3;

      // Using a parabola to map out the height of the sunrise.
      SunY = (float) (0.005 * (Math.pow(SunX - width / 2, 2))) + 10;

      // Drawing the sun
      circle(SunX, SunY, 70);

      // Ground Position
      fill(GroundR, GroundG, GroundB);
      rect(0, 400, 600, 100);

      // Grass Position
      fill(GrassR, GrassG, GrassB);
      rect(0, 400, 600, 25);

      // Once day cycle over, set it to night (boolean) and reset values for sun
      // coordinates
      if (SunX == width) {
        Day = false;
        SunX = 0;
        SunY = 0;
      }
    }

    // Animation for if it is night
    else {

      // Set background
      background(SkyR, SkyG, SkyB);

      // Moon Colour
      fill(255, 255, 255);

      // Drawing stars
      fill(255, 255, 255);
      circle(100, 300, 10);
      circle(230, 210, 10);
      circle(300, 250, 10);
      circle(200, 150, 10);
      circle(100, 250, 10);
      circle(100, 182, 10);
      circle(150, 272, 10);
      circle(280, 192, 10);
      circle(350, 150, 10);
      circle(250, 100, 10);
      circle(150, 239, 10);
      circle(200, 182, 10);
      circle(300, 272, 10);
      circle(380, 192, 10);
      circle(450, 150, 10);
      circle(400, 100, 10);
      circle(375, 239, 10);
      circle(500, 150, 10);
      circle(475, 100, 10);
      circle(495, 239, 10);
      circle(480, 150, 10);

      // Increasing the x coordinate of the moon by a speed of 3
      MoonX += 3;

      // Using a parabola to map out the height of the moon.
      MoonY = (float) (0.005 * (Math.pow(MoonX - width / 2, 2))) + 10;

      // Drawing the moon
      circle(MoonX, MoonY, 70);

      // Ground Position
      fill(GroundR, GroundG, GroundB);
      rect(0, 400, 600, 100);

      // Grass Position
      fill(GrassR, GrassG, GrassB);
      rect(0, 400, 600, 25);

      // Once night cycle over, set it back to day (boolean) and reset values for moon
      if (MoonX == width) {
        Day = true;
        MoonX = 0;
        MoonY = 0;
      }
    }
  }
}