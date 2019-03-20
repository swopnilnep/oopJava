//
// This program demonstrates polymorphism with stack classes
//


package testLayeredIntStack;


import java.util.ArrayList;
import java.util.Scanner;


import intStack.IntStack;
import layeredIntStack.LayeredIntStack;


public class TestLayeredIntStack
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

    private static void printStatus(String tag, LayeredIntStack L)
    {

        System.out.print(tag + " ");
        System.out.print("isEmpty: " + L.isEmpty());
        System.out.print(" error: " + L.error());
        System.out.print(" layer: " + L.layer());
        System.out.println(" top: " + L.top());

        }

    public static void main(String[] commandLineArguments)
    {

        {

            System.out.println("=== Phase 1:");
            System.out.println();

            LayeredIntStack L = new LayeredIntStack();

            printStatus("L", L);

            L.exitLayer();

            printStatus("L", L);

            L.pop();

            printStatus("L", L);

            L.push(111);

            printStatus("L", L);

            L.push(222);

            printStatus("L", L);

            L.push(333);

            printStatus("L", L);

            L.enterLayer();

            printStatus("L", L);

            L.exitLayer();

            printStatus("L", L);

            L.pop();

            printStatus("L", L);

            L.push(444);

            printStatus("L", L);

            L.enterLayer();

            printStatus("L", L);

            L.pop();

            printStatus("L", L);

            L.push(555);

            printStatus("L", L);

            L.push(666);

            printStatus("L", L);

            L.exitLayer();

            printStatus("L", L);

            L.enterLayer();

            printStatus("L", L);

            L.push(777);

            printStatus("L", L);

            L.enterLayer();

            printStatus("L", L);

            L.push(888);

            printStatus("L", L);

            L.push(999);

            printStatus("L", L);

            System.out.println();
            System.out.println("=== Phase 2:");
            System.out.println();

            LayeredIntStack LDuplicate = new LayeredIntStack(L);

            printStatus("LDuplicate", LDuplicate);

            for (int currentLayer = LDuplicate.layer(); currentLayer >= 0; -- currentLayer) {

                while (! LDuplicate.isEmpty()) {

                    LDuplicate.pop();

                    printStatus("LDuplicate", LDuplicate);

                    }

                LDuplicate.exitLayer();

                printStatus("LDuplicate", LDuplicate);

                }

            }

        }

    }
