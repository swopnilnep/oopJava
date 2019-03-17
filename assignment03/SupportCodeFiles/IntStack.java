//
// A Linked-List-Based Stack-of-Integers Class
//


public class IntStack
{

    //
    // Class Fields
    //

        private static final int ourErrorReturnItem = java.lang.Integer.MAX_VALUE;

    //
    // Class Utility Methods
    //

        private static Node duplicate(Node original)
        {

            if (original == null)

                return null;

            else

                return new Node(original.item(), duplicate(original.next()));

            }

    //
    // Instance Fields
    //

        private boolean myLastOperationCausedError;
        private Node myContents;

    //
    // Private Accessors (contents)
    //

        private Node contents()
        {

            return myContents;

            }

    //
    // Private Mutators
    //

        protected void setError(boolean otherLastOperationCausedError)
        {

            myLastOperationCausedError = otherLastOperationCausedError;

            }

        private void setContents(Node otherContents)
        {

            myContents = otherContents;

            }

    //
    // Public Accessors
    //

        public boolean error()
        {

            return myLastOperationCausedError;

            }

        public boolean isEmpty()
        {

            return contents() == null;

            }

        public int top()
        {

            setError(isEmpty());

            if (error())
                return ourErrorReturnItem;
            else
                return contents().item();// first item of the Node

            }

    //
    // Public Mutators
    //

        public void push(int additionalItem)
        {

            setError(false);

            setContents(new Node(additionalItem, contents()));

            }

        public int pop()
        {

            setError(isEmpty());

            if (error())

                return ourErrorReturnItem;

            else {

                int formerTopItem = top();

                setContents(contents().next());

                return formerTopItem;

                }

            }

        public void assign(IntStack other)
        {

            setError(false);
            setContents(duplicate(other.contents()));

            }

    //
    // Constructors
    //

        public IntStack()
        {

            setError(false);
            setContents(null);

            }

        public IntStack(IntStack other)
        {

            assign(other);

            }

    }


//
// A Simple Linked-List Node Class
//


class Node
{

    int myItem;
    Node myNext;

    int item()
    {

        return myItem;

        }

    Node next()
    {

        return myNext;

        }

    void setItem(int other)
    {

        myItem = other;
        }

    void setNext(Node other)
    {

        myNext = other;

        }

    Node()
    {

        setNext(null);

        }

    Node(int initItem)
    {

        setItem(initItem);
        setNext(null);

        }

    Node(Node initNext)
    {

        setNext(initNext);

        }

    Node(int initItem, Node initNext)
    {

        setItem(initItem);
        setNext(initNext);

        }

    }
