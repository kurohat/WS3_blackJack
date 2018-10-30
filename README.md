# WORKSHOP 3 BlackJack
## Developed by: Amata Anantaprayoon (aa224iu)

## RUN :
* From IDE: Load the project source files, and run using the main method Program.java(/WS3_blackJack/BlackJack/Program.java).
* JAR:  Open terminal and go to .jar file directory (WS3_blackJack/). Type the following command: java -jar BlackJacj.jar

## Requirements (for running from IDE):
* [Java SE Development Kit 10](https://www.oracle.com/technetwork/java/javase/downloads/jdk10-downloads-4416644.html) 
* [Eclipse SimRel 2018‑09](https://www.eclipse.org/downloads/)

### Changes:
1. Re-factory PlayGame and Program.java. Reduce workload in Program in while loop.
2. Removed dependency between ctrl and view.
3. Deleted SwedeishView, don't need it. 
4. Add DealCard to get card from deck in Dealer.java
5. Add Stand() in Dealer.java and re-factory Stand() in Game.java. From this point the game is now run-able but Player always win (if they not stupid enough to hit when they shouldn't). Next step is create "Soft 17" so dealer can win at some point.
6. implemented soft 17
7. GetHitRule() call SoftSeventeenHitStrategy.java.
8. Deleted BasicHitStrategy.java and InternationalNewGameStrategy.java
9. Setting up Observer pattern (need to work on it more)

### PS:
* The program is run-able but need more implementation to reach Grade 2.
* No diagrams include in the projects yet. Don't want to do it now when program is not finish
* Just want to submit to get Fx so I dont need to do Yahtzee.

