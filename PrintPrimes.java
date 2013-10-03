public class PrintPrimes {
  int numberOfPrimes;
  int RR;
  int CC;
  int ORDMAX;
  int listOfPrimes[];

  public PrintPrimes(int numberOfPrimes, int RR, int CC, int ORDMAX) {
    this.numberOfPrimes   = numberOfPrimes;
    this.RR  = RR;
    this.CC  = CC;
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

      int j = 1;
      int ORD = 2;
      int SQUARE = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) {
        do {
          j = j + 2;
          if (j == SQUARE) {
            ORD = ORD + 1;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            nonPrimes[ORD - 1] = j;
          }
          n = 2;
          jIsPrime = true;
          while (n < ORD && jIsPrime) {
            while (nonPrimes[n] < j)
              nonPrimes[n] = nonPrimes[n] + listOfPrimes[n] + listOfPrimes[n];
            if (nonPrimes[n] == j)
              jIsPrime = false;
            n = n + 1;
          }
        } while (!jIsPrime);
        listOfPrimes[primesFoundSoFar] = j;
      }
    }

    public void printPrimes() {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + RR; ROWOFFSET++){
            for (int C = 0; C < CC;C++)
              if (ROWOFFSET + C * RR <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + C * RR]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + RR * CC;
        }
    }
}				 
//test commit