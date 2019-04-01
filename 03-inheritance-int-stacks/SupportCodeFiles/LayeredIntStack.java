// CornucopiaIntStack
// Swopnil N. Shrestha
// 15/03/2019
// Instructor: Dr. Alan Zaring
// Constant time for all methods, o(n) where n is the number of integers in the stack

public class LayeredIntStack extends IntStack{
    // 
    // Class Fields
    // 

    private static final int ourLayerSeparatorItem = java.lang.Integer.MAX_VALUE;

    //     
    // Instance Fields 
    //

    private int myLayers;
    private boolean myLastOperationCausedError;

    // 
    // Private Mutators
    // 

    private void setLayers(int numberOfLayers)
    {
        myLayers = numberOfLayers;
    }

    private void setClassError(boolean other){

        myLastOperationCausedError = other;

    }

    private boolean layerIsEmpty(){

        return top() == ourLayerSeparatorItem;

    }

    // 
    // Public Accessors
    // 

    public int layer(){

        return myLayers;

    }

    @Override
    public boolean isEmpty()
    {

        return super.isEmpty() || layerIsEmpty();
        
    }

    @Override
    public boolean error(){
        return (super.error() || myLastOperationCausedError);
    }

    // 
    // Public Mutators
    // 

    public void enterLayer(){

        setClassError(false);
        myLayers++;
        push(ourLayerSeparatorItem);

    }

    public void exitLayer(){

        // pop until it reaches the layer separator and remove it
        while (pop() != ourLayerSeparatorItem);
        if (myLayers > 0) myLayers--;

    }

    @Override
    public void push(int additionalItem)
    {

        setClassError(false);
        super.push(additionalItem);

    }

    @Override
    public int pop()
    {   

        setClassError(isEmpty());

        int poppedItem = super.pop();
        
        if (poppedItem == ourLayerSeparatorItem) {
            myLastOperationCausedError = true;
            push(ourLayerSeparatorItem);
        }
        
        return poppedItem;
    }

    // 
    //  Constructors
    //

    public LayeredIntStack() {

        setLayers(0);

    }

    public LayeredIntStack(LayeredIntStack other){

        super(other);
        setLayers(other.layer());

    }
}