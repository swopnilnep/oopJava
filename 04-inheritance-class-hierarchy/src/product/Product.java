// Swopnil N. Shrestha
// CS-252
// April 4, 2019
package product;


import expression.Expression;


public class Product extends Expression
{

    private Expression myMultiplicand;
    private Expression myMultiplier;

    private Expression multiplicand()
    {

        return myMultiplicand;

        }

    private void setMultiplicand(Expression other)
    {

        myMultiplicand = other;

        }

    private Expression multiplier()
    {

        return myMultiplier;

        }

    private void setMultiplier(Expression other)
    {

        myMultiplier = other;

        }

    @Override
    public double value()
    {

        return multiplicand().value() * multiplier().value();

        }

    @Override
    public String toString()
    {

        return "(" + multiplicand().toString() + " * " + multiplier().toString() + ")";

        }

    private Product(Expression initialMultiplicand, Expression initialMultiplier)
    {

        setMultiplicand(initialMultiplicand);
        setMultiplier(initialMultiplier);

        }

    public Product(Product other)
    {

        setMultiplicand(other.multiplicand());
        setMultiplier(other.multiplier());

        }

    public static Expression make(Expression initialMultiplicand, Expression initialMultiplier)
    {

        return new Product(initialMultiplicand, initialMultiplier);

        }

    }
