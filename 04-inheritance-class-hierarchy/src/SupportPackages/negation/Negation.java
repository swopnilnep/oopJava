package negation;


import expression.Expression;   // Import the expression abstract class


public class Negation extends Expression
{

    private Expression mySubtrahend;    // mySubtrahend is an instance of Expression
                                        // A quantity or number to be substracted from another number
    private Expression subtrahend()
    {

        return mySubtrahend;

        }

    private void setSubtrahend(Expression other)    // Set the subtrahend into another expression
    {

        mySubtrahend = other;

        }

    @Override
    public double value()                           // Returns the negatuve of the subtrahend
    {                                               // when value for Negation is called

        return - subtrahend().value();

        }

    @Override
    public String toString()
    {

        return "(- " + subtrahend().toString() + ")";       // Places negative sign in
                                                            // front of value string
        }

    private Negation(Expression initialSubtrahend)
    {

        setSubtrahend(initialSubtrahend);                   // Set the initial subtrahend
                                                            // To the current expression
        }

    public Negation(Negation other)
    {

        setSubtrahend(other.subtrahend());                  

        }

    public static Expression make(Expression initialSubtrahend)         // what does make do?
    {

        return new Negation(initialSubtrahend);

        }

    }
