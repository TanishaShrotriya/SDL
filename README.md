# SDL
Mid Sem Project



SDL folder - 


Java Swing GUI + Model View Controller architecture and multithreading to implement the game tictactoe - 


Player vs Player version - 

Implemented using client server multithreading, where server acts as the Model, or the element that transfers data
between two players or clients.

Server creates an array of threads, which wait for a client request. It pairs every odd numbered client with the even numbered   
client. Thus it handles the write and read requests among the two clients. 
Controller class is the Client in the project, it performs the write operation on an actionPerformed event triggered by the click 
of a button, and a separate thread runs in the background for every new read request.

Tictactoe is the View class which only implements the GUI portion of the game. The Controller class enables communication between 
the model and the view. The Server is the model, which handles the transfer of data.


Player vs Computer - 

Implements an algorithm that motivates the computer to ensure the next move results in a loss on the human players side. 




The Android version -

This implements the games Tictactoe and Bingo.

Tictactoe is a client vs computer version, implementing an algorithm motivating the computer to win the game instead of trying to 
ensure failure for the human player.

Bingo is also a client vs computer version, where the algorithm once again aims for victory.



