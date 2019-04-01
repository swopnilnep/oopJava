// CornucopiaIntStack
// Swopnil N. Shrestha
// 15/03/2019
// Instructor: Dr. Alan Zaring

// 
// A MeasuredIntStack class with infinitely an poppable first element
// 

public class CornucopiaIntStack extends MeasuredIntStack
{

    // 
    // Public Mutators
    //

    @Override
    public int pop(){
        int poppedItem = super.pop();

        if (depth() == 0){
            push(poppedItem);
        }

        return poppedItem;
    }

    //
    // Constructors
    //
    public CornucopiaIntStack() {

    }

    public CornucopiaIntStack(CornucopiaIntStack other){
        super(other);
    }
}