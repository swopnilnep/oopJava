// Swopnil N. Shrestha
// CS-252
// April 4, 2019
package quotient;


import expression.Expression;


public class Quotient extends Expression
{

    private Expression myDividend;
    private Expression myDivisor;

    private Expression dividend()
    {

        return myDividend;

        }

    private void setDividend(Expression other)
    {

        myDividend = other;

        }

    private Expression divisor()
    {

        return myDivisor;

        }

    private void setMultiplier(Expression other)
    {

        myDivisor = other;

        }

    @Override
    public double value()
    {

        return dividend().value() / divisor().value();

        }

    @Override
    public String toString()
    {

        return "(" + dividend().toString() + " / " + divisor().toString() + ")";

        }

    private Quotient(Expression initialDividend, Expression initialDivisor)
    {

        setDividend(initialDividend);
        setMultiplier(initialDivisor);

        }

    public Quotient(Quotient other)
    {

        setDividend(other.dividend());
        setMultiplier(other.divisor());

        }

    public static Expression make(Expression initialDividend, Expression initialDivisor)
    {

        return new Quotient(initialDividend, initialDivisor);

        }

    }
