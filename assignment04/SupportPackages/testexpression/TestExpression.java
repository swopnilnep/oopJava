package testexpression;


public class TestExpression
{

    public static void displayExpressionValue(Expression expr)
    {

        System.out.printf("%s = %f\n", expr.toString(), expr.value());

        }


    public static void main(String [] commandLineArguments)
    {

        Expression E1 =
            Sum.make(
                Difference.make(
                    Constant.make(18),
                    Constant.make(17)),
                Negation.make(
                    Constant.make(123.456)));

        Expression E2 = Constant.make(1.2);
        Expression E3 = Negation.make(E2);
        Expression E4 = Negation.make(E3);
        Expression E5 = Negation.make(E4);

        Expression E6 = Negation.make(Negation.make(Negation.make(Constant.make(1.2))));

        displayExpressionValue(E1);
        displayExpressionValue(E5);
        displayExpressionValue(E6);

        }

    }
