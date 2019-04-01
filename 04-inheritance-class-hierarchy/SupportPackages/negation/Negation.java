package negation;


import expression.Expression;


public class Negation extends Expression
{

    private Expression mySubtrahend;

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

        return - subtrahend().value();

        }

    @Override
    public String toString()
    {

        return "(- " + subtrahend().toString() + ")";

        }

    private Negation(Expression initialSubtrahend)
    {

        setSubtrahend(initialSubtrahend);

        }

    public Negation(Negation other)
    {

        setSubtrahend(other.subtrahend());

        }

    public static Expression make(Expression initialSubtrahend)
    {

        return new Negation(initialSubtrahend);

        }

    }
