//
// A Measured-Stack Class
//


public class MeasuredIntStack extends IntStack
{

    //
    // Instance Fields
    //

        private int myDepth;

    //
    // Private Mutators
    //

        private void setDepth(int other)
        {

            myDepth = other;

            }

    //
    // Public Accessors
    //

        public int depth()
        {

            return myDepth;

            }

    //
    // Public Mutators
    //

        @Override
        public void push(int additionalItem)
        {

            super.push(additionalItem);

            if (! error())
                setDepth(depth() + 1);

            }

        @Override
        public int pop()
        {

            int poppedItem = super.pop();

            if (! error())
                setDepth(depth() - 1);

            return poppedItem;

            }

        public void assign(MeasuredIntStack other)
        {

            super.assign(other);

            setDepth(other.depth());

            }

    //
    // Constructors
    //

        public MeasuredIntStack()
        {

            setDepth(0);

            }

        public MeasuredIntStack(MeasuredIntStack other)
        {

            super(other);
            setDepth(other.depth());

            }

    }
