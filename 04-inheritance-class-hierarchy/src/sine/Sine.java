// Swopnil N. Shrestha
// CS-252
// April 4, 2019
package sine;


import expression.Expression;
import static java.lang.Math.sin;


public class Sine extends Expression
{

    private Expression mySineOperand;   // Just to maintain the 'operand' instance hierarchy

    private Expression sineOperand()
    {

        return mySineOperand;

        }

    private void setSineOperand(Expression other)
    {

        mySineOperand = other;

        }

    @Override
    public double value()
    {

        return sin(sineOperand().value());

        }

    @Override
    public String toString()
    {

        return sineOperand().toString();

        }

    private Sine(Expression initialSineOperand)
    {

        setSineOperand(initialSineOperand);

        }

    public Sine(Sine other)
    {

        setSineOperand(other.sineOperand());                  

        }

    public static Expression make(Expression initialSineOperand)
    {

        return new Sine(initialSineOperand);

        }

    }
