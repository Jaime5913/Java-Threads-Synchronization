

public class Buffer{
    int count;
    int in;
    int out; 
    int size;
    char i;
    char[] buffer;

    public Buffer( int s) {
        count = 0;
        in = 0;
        out = 0;
        size = a;
        buffer = new char[a];
    }
    public boolean isFull(){
        if (size == count){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public synchronized void insert(char item) {
        while(isFull()){
            try{
                wait();
            }
            catch ( Exception e){ e.printStackTrace();  }
        }
        
        buffer[in] = item;
        in = (in + 1) % size;
        count++;
        notify();
        }
       
    public synchronized char remove() {
        while(isEmpty()){
            try{
                wait();
            }
            catch ( Exception e){ 
                e.printStackTrace(); }
        }

        char item;
        item = buffer[out];
        out = (out + 1) %  size;
        count--;

        notify();

        return item;
    }
}
