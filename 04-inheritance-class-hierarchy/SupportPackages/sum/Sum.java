package sum;


import expression.Expression;


public class Sum extends Expression
{

    private Expression myAddend;
    private Expression myAugend;

    private Expression addend()
    {

        return myAddend;

        }

    private void setAddend(Expression other)
    {

        myAddend = other;

        }

    private Expression augend()
    {

        return myAugend;

        }

    private void setAugend(Expression other)
    {

        myAugend = other;

        }

    @Override
    public double value()
    {

        return addend().value() + augend().value();

        }

    @Override
    public String toString()
    {

        return "(" + addend().toString() + " + " + augend().toString() + ")";

        }

    private Sum(Expression initialAddend, Expression initialAugend)
    {

        setAddend(initialAddend);
        setAugend(initialAugend);

        }

    public Sum(Sum other)
    {

        setAddend(other.addend());
        setAugend(other.augend());

        }

    public static Expression make(Expression initialAddend, Expression initialAugend)
    {

        return new Sum(initialAddend, initialAugend);

        }

    }
