package constant;


import expression.Expression;


public class Constant extends Expression
{

    private double myIntrinsicValue;

    private double intrinsicValue()
    {

        return myIntrinsicValue;

        }

    private void setIntrinsicValue(double other)
    {

        myIntrinsicValue = other;

        }

    @Override
    public double value()
    {

        return intrinsicValue();

        }

    @Override
    public String toString()
    {

        return "" + intrinsicValue();

        }

    private Constant(double initialIntrinsicValue)
    {

        setIntrinsicValue(initialIntrinsicValue);

        }

    public Constant(Constant other)
    {

        setIntrinsicValue(other.intrinsicValue());

        }

    public static Expression make(double initialIntrinsicValue)
    {

        return new Constant(initialIntrinsicValue);

        }

    };
