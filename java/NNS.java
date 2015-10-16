

import java.util.LinkedList;
import java.util.List;

class Point {
	public java.awt.Point p;
	public long id;

	public Point(float x, float y, long id) {
		this.p = new java.awt.Point();
		p.setLocation(x, y);
		this.id = id;
	}
}

class Sect {
	List<Point> points;

	public Sect() {
		this.points = new LinkedList<Point>();
	}

	public void addPoint(float x, float y, long id) {
		points.add(new Point(x, y, id));
	}
}

public class NNS {
	float width;
	float height;
	int nx;
	int ny;
	float stepx;
	float stepy;

	float threshold;

	Sect[] sects;

	public void init(float width, float height, int nx, int ny, float threshold) {
		this.width = width;
		this.height = height;
		this.nx = nx;
		this.ny = ny;
		this.threshold = threshold;

		this.stepx = width / nx;
		this.stepy = height / ny;

		sects = new Sect[ny * nx];
	}

	private void addPoint(float x, float y, long id) {
		int ix;
		int iy;
		ix = (int) (x / stepx);
		iy = (int) (y / stepy);
		sects[iy * nx + ix].addPoint(x, y, id);
	}

}
