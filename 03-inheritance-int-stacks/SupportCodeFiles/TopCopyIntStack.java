//
// A Top-Copy Stack-of-Integers Class
//


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
