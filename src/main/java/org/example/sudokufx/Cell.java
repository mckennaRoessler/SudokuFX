package org.example.sudokufx;
public class Cell
{
    private int value; //number in the cell
    private boolean isFixed; //true if cell is filled by default

    public Cell(int initialValue, boolean fixed) //cell constructor
    {
        if (initialValue < 0 || initialValue > 9)
        {
            throw new IllegalArgumentException("Cell value must be between 0 and 9");
        }
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
}
