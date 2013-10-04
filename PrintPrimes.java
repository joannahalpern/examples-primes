public class PrintPrimes {
  int numberOfPrimes;
  int numberOfRows;
  int numberOfColumns;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int numberOfRows, int numberOfColumns, int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.numberOfRows  = numberOfRows;
    this.numberOfColumns  = numberOfColumns;
    this.ORDMAX = ORDMAX;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 10, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() {
      boolean jIsPrime;
      int n;
      int nonPrimes[] = new int[ORDMAX + 1];

      int currentNumber = 1;
      int order = 2;
      int square = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          currentNumber = currentNumber + 2;
          if (currentNumber == square) {
            order = order + 1;
            square = listOfPrimes[order] * listOfPrimes[order];
            nonPrimes[order - 1] = currentNumber;
          }
          jIsPrime = true;
          findNonPrimes();
        } while (!jIsPrime);
        listOfPrimes[primesFoundSoFar] = currentNumber;
      }
    }

	private static void findNonPrimes(){
		n = 2;
		while (n < order && jIsPrime) {
            while (nonPrimes[n] < currentNumber)
              nonPrimes[n] = nonPrimes[n] + listOfPrimes[n] + listOfPrimes[n];
            if (nonPrimes[n] == currentNumber)
                jIsPrime = false;
              n = n + 1;
		}
	}
		

    public void printPrimes() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + numberOfRows; ROWOFFSET++){
            for (int C = 0; C < numberOfColumns;C++)
              if (ROWOFFSET + C * numberOfRows <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + C * numberOfRows]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + numberOfRows * numberOfColumns;
        }
    }
}				 
//test commit