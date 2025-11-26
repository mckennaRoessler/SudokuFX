package org.example.sudokufx;

import javafx.scene.Node;

public class Cell extends Node
{
    private int value; //number in the cell
    private final boolean isFixed; //true if cell is filled by default
    private final int boardPosition;

    public Cell(int position, int initialValue, boolean fixed) //cell constructor
    {
        if (initialValue < 0 || initialValue > 9)
        {
            throw new IllegalArgumentException("Cell value must be between 0 and 9");
        }
        this.boardPosition = position;
        this.value = initialValue;
        this.isFixed = fixed;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int newValue)
    {
        if (!isFixed) //value can only be set if cell is not fixed
        {
            if (newValue >= 0 && newValue <= 9)
            {
                this.value = newValue;
            }
            else
            {
                throw new IllegalArgumentException("Cell value must be between 0 and 9");
            }
        }
        else
        {
            System.out.println("Cannot change value of a fixed cell.");
        }
    }

    public boolean isFixed()
    {
        return isFixed;
    }

    public int getBoardPosition()
    {
        return boardPosition;
    }

    @Override
    public Node getStyleableNode()
    {
        return super.getStyleableNode();
    }
}
