package mypkg;

public class PaintThings implements Paint{
	static public float computePaint(float surface) {
		return surface * Paint.paintPerSurfaceUnit;
	}
}
