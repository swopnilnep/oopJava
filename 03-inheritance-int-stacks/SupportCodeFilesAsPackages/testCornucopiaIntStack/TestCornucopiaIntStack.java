//
// This program demonstrates polymorphism with stack classes
//


package testCornucopiaIntStack;


import java.util.ArrayList;
import java.util.Scanner;


import intStack.IntStack;
import cornucopiaIntStack.CornucopiaIntStack;


public class TestCornucopiaIntStack
{

    private static void loadIntStack(Scanner reader, IntStack S, int stopper)
    {

        for (int item = reader.nextInt(); item != stopper; item = reader.nextInt()) {

            S.push(item);
            System.out.println("pushed [" + item + "] (error: " + S.error() + ")");

            }

        }

    private static void unloadIntStack(IntStack S, int limit)
    {

        for( ; limit != 0 && ! S.isEmpty(); -- limit) {

            int item = S.pop();

            System.out.println("popped [" + item + "] (error: " + S.error() + ")");

            }

        }

    public static void main(String[] commandLineArguments)
    {

        ArrayList< String > testStrings = new ArrayList< String >();

        testStrings.add("0");
        testStrings.add("111 0");
        testStrings.add("111 222 333 444 555 0");

        for (String testSubject : testStrings) {

            IntStack S = new IntStack();
            CornucopiaIntStack C = new CornucopiaIntStack();

            System.out.println("#### Testing IntStack on [" + testSubject + "] ...");

            System.out.println("Loading ...");

            loadIntStack(new Scanner(testSubject), S, 0);

            System.out.println("Unloading ...");
            unloadIntStack(S, 16);

            System.out.println("#### Testing CornucopiaIntStack on [" + testSubject + "] ...");

            System.out.println("Loading ...");

            loadIntStack(new Scanner(testSubject), C, 0);

            System.out.println("Unloading ...");
            unloadIntStack(C, 16);

            System.out.print("\n========\n\n");

            }

        }

    }
