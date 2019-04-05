// Swopnil N. Shrestha
// CS-252
// April 4, 2019
package tothepower;


import expression.Expression;
import static java.lang.Math.pow;


public class ToThePower extends Expression
{

    private Expression myBase;
    private Expression myExponent;

    private Expression base()
    {

        return myBase;

        }

    private void setBase(Expression other)
    {

        myBase = other;

        }

    private Expression exponent()
    {

        return myExponent;

        }

    private void setExponent(Expression other)
    {

        myExponent = other;

        }

    @Override
    public double value()
    {

        return pow(base().value() , exponent().value());

        }

    @Override
    public String toString()
    {

        return "(" + base().toString() + "e" + exponent().toString() + ")";

        }

    private ToThePower(Expression initialBase, Expression initialExponent)
    {

        setBase(initialBase);
        setExponent(initialExponent);

        }

    public ToThePower(ToThePower other)
    {

        setBase(other.base());
        setExponent(other.exponent());

        }

    public static Expression make(Expression initialMultiplicand, Expression initialMultiplier)
    {

        return new ToThePower(initialMultiplicand, initialMultiplier);

        }

    }
