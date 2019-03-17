// CornucopiaIntStack
// Swopnil N. Shrestha
// 15/03/2019
// Instructor: Dr. Alan Zaring

// 
// This class extends layered functionality to a MeasuredIntStack
// It is implemented as two MeasuredIntStacks, one is the main stack and one
// keeps track of the elements in each layer
// 


public class LayeredIntStack extends MeasuredIntStack
{

    //     
    // Instance Fields
    // 

    private MeasuredIntStack myLayers = new MeasuredIntStack();

    // 
    // Public Accessors
    //     

    public int layer() 
    {
        return myLayers.depth()-1;
    }

    public MeasuredIntStack elementsInLayers(){
        return myLayers;
    }

    // 
    //  Public Mutators 
    //

    public void enterLayer()
    {
        myLayers.push(0);
        push(Integer.MAX_VALUE);
    }

    public void exitLayer()
    {
        int elementsInLayer = myLayers.pop();

        for (int layerNumber = 0; layerNumber < elementsInLayer; ++layerNumber){
            pop();
        }

        // if it is the last layer, initialize the 0th layer
        if (layer() == -1){
            myLayers.push(0);
        }

    }

    @Override
    public void push(int additionalItem){
        
        if (top() == Integer.MAX_VALUE){
            super.pop();
        }
        
        super.push(additionalItem);
        int elementsInLayer = myLayers.pop();
        myLayers.push(elementsInLayer+1);
    }

    @Override
    public int pop(){

        if (myLayers.top() > 0 && myLayers.top() != Integer.MAX_VALUE){
            return super.pop();
        }

        // popping when the layer has no more values
        
        return Integer.MAX_VALUE;
    }

    // 
    // Constructors
    //     

    public LayeredIntStack(){
        myLayers.push(0);
    }

    public LayeredIntStack(LayeredIntStack other){
        super(other);
        myLayers.assign(other.elementsInLayers());
    }
}