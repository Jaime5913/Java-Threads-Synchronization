import java.util.Random;

public class Consumer extends java.lang.Thread {
	Random randomWithSeed;
    Buffer Buff;
	int consumer_amount = 0;
	int count;
	int id;


	public Consumer(Buffer buff, int count, int id) {
		this.Buff = buff;
		this.count = count;
		this.id = id;
	}

	@Override
	public void run() {
		/* Your code goes in here

		Insert the N-th prime to the buffer as much as the count.
        The random number N is produced by random generator. Check the range in the HW description.
        You can generate a random number in range [1, 10] as:
        int randomN = randomWithSeed.nextInt(10-1+1) + 1;

		*/
		int count = this.count;
		int id = this.id;

        while (count != 0){

            int index = Buff.out;
			char chartr = Buff.remove();
			if (chartr != 'A' && chartr != 'E' && chartr != 'I' && chartr != 'O' && chartr != 'U'){
				consumer_amount = consumer_amount + 1;
			}
			if (chartr != 0){
				String s = String.format("[Consumer %d]: consumed %s at index %d at time %s",id, chartr, index, Coordinator.getTime());
				System.out.println(s);
				count--;
			}
			
			
        }
	}
	public int getCConsonents(){
		return consumer_amount;
	}
}

