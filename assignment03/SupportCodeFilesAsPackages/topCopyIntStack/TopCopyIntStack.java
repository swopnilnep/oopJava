//
// A Top-Copy Stack-of-Integers Class
//


package topCopyIntStack;


import intStack.IntStack;


public class TopCopyIntStack extends IntStack
{

    //
    // Public Mutators
    //

        public void copy()
        {

            int topItem = top();

            if (! error())

                push(topItem);

            }

    }
