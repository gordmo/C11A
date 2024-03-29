import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Cat {
    private int headDimension;
    private int eyeY;
    private int eyeX;
    private int eyeSeparation;
    private int eyeHeight;
    private int eyeWidth;
    private int mouthHeight;
    private int mouthWidth;
    private int mouthX;
    private int mouthY;
    
    private Color bodyColor = Color.BLACK; // Default body color
    private Color eyeColor = Color.GREEN; // Default eye color
    private Color mouthColor = Color.PINK; // Default mouth color

    public Cat(int headDimension, int eyeY, int eyeX, int eyeSeparation,
               int eyeHeight, int eyeWidth, int mouthHeight, int mouthWidth,
               int mouthX, int mouthY) {
        this.headDimension = headDimension;
        this.eyeY = eyeY;
        this.eyeX = eyeX;
        this.eyeSeparation = eyeSeparation;
        this.eyeHeight = eyeHeight;
        this.eyeWidth = eyeWidth;
        this.mouthHeight = mouthHeight;
        this.mouthWidth = mouthWidth;
        this.mouthX = mouthX;
        this.mouthY = mouthY;
    }


    public void draw(Graphics g, int catX, int catY) {
        Graphics2D g2 = (Graphics2D) g;

        drawHead(g2, catX, catY);
        drawEyes(g2, catX, catY);
        drawMouth(g2, catX, catY);

        // Meow text appears below cat head, +10 places below
        // so it doesn't overlap the drawing
        g2.setColor(Color.black);
        g2.drawString("Meow", catX, catY + headDimension + 10);
    }

    // Method to draw the cat's head
    private void drawHead(Graphics2D g2, int catX, int catY) {
        g2.setColor(Color.black);
        g2.fillOval(catX, catY, headDimension, headDimension);

        // Calculate ear positions
        int earWidth = headDimension / 3;
        int earHeight = headDimension / 2;
        int earY = catY - earHeight;
        int earBase = headDimension / 4;
        int leftEarX = catX + earBase;
        int rightEarX = catX + headDimension - earBase - earWidth;

        // Draw ears
        Polygon leftEar = new Polygon();
        leftEar.addPoint(leftEarX, catY);
        leftEar.addPoint(catX + earBase / 2, earY);
        leftEar.addPoint(catX + earBase, catY - earHeight);

        Polygon rightEar = new Polygon();
        rightEar.addPoint(rightEarX, catY);
        rightEar.addPoint(catX + headDimension - earBase / 2, earY);
        rightEar.addPoint(catX + headDimension - earBase, catY - earHeight);

        // Fill ears
        g2.setColor(Color.black);
        g2.fillPolygon(leftEar);
        g2.fillPolygon(rightEar);
    }


    // Method to draw the cat's eyes
    private void drawEyes(Graphics2D g2, int catX, int catY) {
        g2.setColor(Color.green);
        int x = catX + eyeX;
        int y = catY + eyeY;
        g2.fillOval(x, y, eyeWidth, eyeHeight);
        x += eyeSeparation;
        g2.fillOval(x, y, eyeWidth, eyeHeight);
    }

    // Method to draw the cat's mouth
    private void drawMouth(Graphics2D g2, int catX, int catY) {
        g2.setColor(Color.pink);
        int x = catX + mouthX;
        int y = catY + mouthY;
        g2.fillOval(x, y, mouthWidth, mouthHeight);
    }

    public static void main(String[] args) {
        // Example usage:
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
            	super.paintComponent(g);
                Cat cat = new Cat(100, 25, 25, 33, 20, 10, 10, 25, 40, 60);
                
                // Change properties using setters
                cat.setHeadDimension(120); // Make the head larger
                cat.setEyeY(30); // Adjust eye vertical position
                cat.setEyeX(30); // Adjust eye horizontal position
                
                cat.draw(g, 100, 100);
            }
        });
        frame.setVisible(true);
    }
    
    // Setter for headDimension
    public void setHeadDimension(int headDimension) {
        this.headDimension = headDimension;
    }

    // Setter for eyeY
    public void setEyeY(int eyeY) {
        this.eyeY = eyeY;
    }

    // Setter for eyeX
    public void setEyeX(int eyeX) {
        this.eyeX = eyeX;
    }
    
    // Setter for body color
    public void setBodyColor(Color color) {
        this.bodyColor = color;
    }
    
    // Setter for eyecolor
    public void setEyeColor(Color color) {
    	this.eyeColor = color;
    }
    
    // Setter for mouthcolor
    public void setMouthColor(Color color) {
    	this.eyeColor = color;
    }

}

