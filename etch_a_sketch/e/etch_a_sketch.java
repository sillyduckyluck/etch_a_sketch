package e;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class etch_a_sketch {
	// Main entry point
	public static void main(String[] args) {
		JFrame frame = new DrawFrame();
		// The window size is set in the constructor for DrawFrame
		
		Unpressable Button = new Unpressable("Press me!");
		frame.add(Button, BorderLayout.EAST);
		
		ClearButton ClearButton = new ClearButton("Clear!");
		//frame.add(ClearButton, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	static class DrawFrame extends JFrame implements ActionListener {
		private Container contentPane;
		public DrawFrame() {
			setTitle("Java Graphics");
			setSize(600, 400);

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			JButton ClearButton = new JButton("Clear!");
			ClearButton.addActionListener(this);

			// Components that will appear on a JFrame
			// are added to the content pane.
			
			contentPane = getContentPane();
			MyCanvas drawingCanvas = new MyCanvas();
			contentPane.add(drawingCanvas, BorderLayout.CENTER);
			contentPane.add(ClearButton, BorderLayout.SOUTH);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			contentPane.repaint();
		}
	}
	static public class ClearButton extends JButton implements MouseListener{

		public ClearButton(String text) {
			this.setText(text);
			addMouseListener(this);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {}

		@Override
		public void mouseReleased(MouseEvent e) {}
		
	}
	static public class Unpressable extends JButton implements MouseListener{
		
		public Unpressable(String text) {
			this.setText(text);
			addMouseListener(this);
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			System.out.println("Clicked!");
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			this.setEnabled(false);
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			this.setEnabled(true);
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
	}

	// A JPanel is a component you can draw on.
	// Our panel is listening for mouse events
	static class MyCanvas extends JPanel implements MouseListener, MouseMotionListener {

		private int x, y;
		private int oldX, oldY;
		public MyCanvas() {
			addMouseListener(this);
			addMouseMotionListener(this);
		}

		// --------------------------------------------------------
		// There are 5 methods in the MouseListener (click, double click, etc)
		// interface.
		public void mousePressed(MouseEvent evt) {
			x = evt.getX();
			y = evt.getY();
		}

		// We don't process these events but must declare the methods
		// here because we are obliged to implement all methods in
		// the interface.
		public void mouseReleased(MouseEvent evt) {}

		public void mouseClicked(MouseEvent evt) {}

		public void mouseEntered(MouseEvent evt) {}

		public void mouseExited(MouseEvent evt) {}

		public void mouseDragged(MouseEvent me) {
			// TODO Auto-generated method stub
	        x = me.getX();
	        y = me.getY();
	 
	        if (oldX == 0 ) {
	            oldX=x;
	            oldY=y;
	            return;
	        }
	        //drawPoint( x,y );
	        Graphics g = getGraphics();
	        g.drawLine(oldX,oldY, x, y);
	        //g.setColor(lineColor);
	        oldX = x;
	        oldY = y;
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
}
