package gui;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
// import javax.swing.JFrame;

import math.objects.Matrix;
import math.operations.MatrixOperations;
import math.operations.MatrixTransformations;
import models.Cube;


public class CubeCanvas extends Applet implements ActionListener
{
    private JButton upButton, downButton, lefButton, rightButton, frontButton, backButton;
    private JButton rotateXButton, rotateYButton, rotateZButton;
    private JButton antiRotateXButton, antiRotateYButton, antiRotateZButton;
    private JButton zoomInButton, zoomOutButton;

    private final Cube CUBE = new Cube();
    private final Matrix[] CUBE_TRANSFORMATIONS = new Matrix[]
    {
        // DOWN
        MatrixTransformations.IDENTITY, 
        MatrixTransformations.getMoveXMatrix(CUBE.getLength()), 
        MatrixTransformations.getMoveZMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveXMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveZMatrix(CUBE.getLength()), 

        // LEFT
        MatrixTransformations.getMoveYMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveZMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveYMatrix(CUBE.getLength()), 

        // BACK
        MatrixTransformations.getMoveYMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveXMatrix(CUBE.getLength()), 
        MatrixTransformations.getMoveYMatrix(CUBE.getLength()), 

        // RIGHT
        MatrixTransformations.getMoveYMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveZMatrix(CUBE.getLength()), 
        MatrixTransformations.getMoveYMatrix(CUBE.getLength()), 

        // FRONT & UP
        MatrixTransformations.getMoveYMatrix(-CUBE.getLength()), 
        MatrixTransformations.getMoveXMatrix(-CUBE.getLength()), 
    };

    private double scale;
    private final double ANGLE_Z = 45*Math.PI/180;
    private final double TRANSITION_STEP = 20;
    private final double ROTATION_STEP = 10*Math.PI/180; 

    public CubeCanvas()
    {
        super();
        initialize();
    }

    protected void initialize()
    {
        scale = 1;

        setSize(800, 900);
        setLayout(null);

        upButton = new JButton("UP");
        upButton.addActionListener(this);
        upButton.setBounds(100, 400, 120, 20);
        add(upButton);

        downButton = new JButton("DOWN");
        downButton.addActionListener(this);
        downButton.setBounds(100, 430, 120, 20);
        add(downButton);

        lefButton = new JButton("LEFT");
        lefButton.addActionListener(this);
        lefButton.setBounds(100, 460, 120, 20);
        add(lefButton);

        rightButton = new JButton("RIGHT");
        rightButton.addActionListener(this);
        rightButton.setBounds(100, 490, 120, 20);
        add(rightButton);

        frontButton = new JButton("FRONT");
        frontButton.addActionListener(this);
        frontButton.setBounds(100, 520, 120, 20);
        add(frontButton);

        backButton = new JButton("BACK");
        backButton.addActionListener(this);
        backButton.setBounds(100, 550, 120, 20);
        add(backButton);

        rotateXButton = new JButton("ROTATE X");
        rotateXButton.addActionListener(this);
        rotateXButton.setBounds(250, 400, 120, 20);
        add(rotateXButton);

        rotateYButton = new JButton("ROTATE Y");
        rotateYButton.addActionListener(this);
        rotateYButton.setBounds(250, 430, 120, 20);
        add(rotateYButton);

        rotateZButton = new JButton("ROTATE Z");
        rotateZButton.addActionListener(this);
        rotateZButton.setBounds(250, 460, 120, 20);
        add(rotateZButton);

        antiRotateXButton = new JButton("ANTI ROTATE X");
        antiRotateXButton.addActionListener(this);
        antiRotateXButton.setBounds(400, 400, 120, 20);
        add(antiRotateXButton);

        antiRotateYButton = new JButton("ANTI ROTATE Y");
        antiRotateYButton.addActionListener(this);
        antiRotateYButton.setBounds(400, 430, 120, 20);
        add(antiRotateYButton);

        antiRotateZButton = new JButton("ANTI ROTATE Z");
        antiRotateZButton.addActionListener(this);
        antiRotateZButton.setBounds(400, 460, 120, 20);
        add(antiRotateZButton);

        zoomInButton = new JButton("ZOOM IN");
        zoomInButton.addActionListener(this);
        zoomInButton.setBounds(550, 400, 120, 20);
        add(zoomInButton);

        zoomOutButton = new JButton("ZOOM OUT");
        zoomOutButton.addActionListener(this);
        zoomOutButton.setBounds(550, 430, 120, 20);
        add(zoomOutButton);
    }

    @Override
    public void paint(Graphics g) 
    {
        super.paint(g);        
        paintCube(g);
        paintCube(g);
    }

    protected void paintCube(Graphics g)
    {
        // Position matrix
        Matrix matrix = MatrixTransformations.getPositionMatrix
        (
            CUBE.getX(), 
            CUBE.getY(), 
            CUBE.getZ()
        );

        // Scale matrix
        matrix = MatrixOperations.crossMatrix
        (
            matrix, 
            MatrixTransformations.getScaleMatrix(scale)
        );

        // Rotate x matrix
        matrix = MatrixOperations.crossMatrix
        (
            matrix, 
            MatrixTransformations.getRotateXMatrix(CUBE.getAngleX())
        );

        // Rotate y matrix
        matrix = MatrixOperations.crossMatrix
        (
            matrix, 
            MatrixTransformations.getRotateYMatrix(CUBE.getAngleY())
        );

        // Rotate z matrix
        matrix = MatrixOperations.crossMatrix
        (
            matrix, 
            MatrixTransformations.getRotateZMatrix(CUBE.getAngleZ())
        );

        for (int i = 0; i < CUBE_TRANSFORMATIONS.length; i++)
        {
            Matrix newMatrix = MatrixOperations.crossMatrix
            (
                matrix, 
                CUBE_TRANSFORMATIONS[i]
            );

            double x1 = matrix.getValue(0, 3);
            double y1 = matrix.getValue(1, 3);
            double z1 = matrix.getValue(2, 3);

            double x2 = newMatrix.getValue(0, 3);
            double y2 = newMatrix.getValue(1, 3);
            double z2 = newMatrix.getValue(2, 3);

            int proyX1 = (int) (x1 - z1*Math.cos(ANGLE_Z));
            int proyY1 = (int) (y1 + z1*Math.sin(ANGLE_Z));

            int proyX2 = (int) (x2 - z2*Math.cos(ANGLE_Z));
            int proyY2 = (int) (y2 + z2*Math.sin(ANGLE_Z));

            g.drawLine(proyX1, proyY1, proyX2, proyY2);

            matrix = newMatrix;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == rightButton)
        {
            CUBE.setX(CUBE.getX() + TRANSITION_STEP);
        }
        else if (e.getSource() == lefButton)
        {
            CUBE.setX(CUBE.getX() - TRANSITION_STEP);
        }
        else if (e.getSource() == upButton)
        {
            CUBE.setY(CUBE.getY() - TRANSITION_STEP);
        }
        else if (e.getSource() == downButton)
        {
            CUBE.setY(CUBE.getY() + TRANSITION_STEP);
        }
        else if (e.getSource() == frontButton)
        {
            CUBE.setZ(CUBE.getZ() + TRANSITION_STEP);
        }
        else if (e.getSource() == backButton)
        {
            CUBE.setZ(CUBE.getZ() - TRANSITION_STEP);
        }
        else if (e.getSource() == rotateXButton)
        {
            CUBE.setAngleX(CUBE.getAngleX() + ROTATION_STEP);
        }
        else if (e.getSource() == rotateYButton)
        {
            CUBE.setAngleY(CUBE.getAngleY() + ROTATION_STEP);
        }
        else if (e.getSource() == rotateZButton)
        {
            CUBE.setAngleZ(CUBE.getAngleZ() + ROTATION_STEP);
        }
        else if (e.getSource() == antiRotateXButton)
        {
            CUBE.setAngleX(CUBE.getAngleX() - ROTATION_STEP);
        }
        else if (e.getSource() == antiRotateYButton)
        {
            CUBE.setAngleY(CUBE.getAngleY() - ROTATION_STEP);
        }
        else if (e.getSource() == antiRotateZButton)
        {
            CUBE.setAngleZ(CUBE.getAngleZ() - ROTATION_STEP);
        }
        else if (e.getSource() == zoomInButton)
        {
            if (scale < 8)
            {
                scale *= 2;
            }
        }
        else if (e.getSource() == zoomOutButton)
        {
            if (scale > 0.125)
            {
                scale /= 2;
            }
        }

        repaint();
    }

}










