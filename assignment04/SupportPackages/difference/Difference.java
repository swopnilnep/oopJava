package difference;


import expression.Expression;


public class Difference extends Expression
{

    private Expression myMinuend;
    private Expression mySubtrahend;

    private Expression minuend()
    {

        return myMinuend;

        }

    private void setMinuend(Expression other)
    {

        myMinuend = other;

        }

    private Expression subtrahend()
    {

        return mySubtrahend;

        }

    private void setSubtrahend(Expression other)
    {

        mySubtrahend = other;

        }

    @Override
    public double value()
    {

        return minuend().value() - subtrahend().value();

        }

    @Override
    public String toString()
    {

        return "(" + minuend().toString() + " - " + subtrahend().toString() + ")";

        }

    private Difference(Expression initialMinuend, Expression initialSubtrahend)
    {

        setMinuend(initialMinuend);
        setSubtrahend(initialSubtrahend);

        }

    public Difference(Difference other)
    {

        setMinuend(other.minuend());
        setSubtrahend(other.subtrahend());

        }

    public static Expression make(Expression initialMinuend, Expression initialSubtrahend)
    {

        return new Difference(initialMinuend, initialSubtrahend);

        }

    }
