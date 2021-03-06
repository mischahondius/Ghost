<h5><b>Project: </b> Ghost <br>
<b>Student: </b> Mischa Hondius, ID 6053017. <br><br></h5>

<h4><b>Screens and decisions </b><br></h4>

Note: I've decided not to show a Congratulations screen, nor the highscore screen after every win. This in order to keep the user in the flow of gameplay. The reason why someone has won a game is not really interesting. 99% of the time the players will know why they've won or lost. I did have to add a function that freezes the screen for a second before continuing the game, in order to give players the chance to see what word they've created. This is I beleive enough information on the reason of winning or loosing.<br>
I know showing these screens were in the requirements. I think I've sufficiently shown to be able to redirect to new screens, and or give information along to new activities through intents. Therefore I hope this design decision is appreciated rather than judged.

<img src="/doc/WelcomeScreen1.png" width="400">
<img src="/doc/WelcomeScreen2.png" width="400">
<img src="/doc/WelcomeScreen3.png" width="400">
<img src="/doc/WelcomeScreen4.png" width="400">

<h5><b>Screen 1: Welcome screen</b></h5>
<b>Controller: </b> FirsTimeActivity <br>
<b>Layout: </b> activity_first_time <br>
<b>Model classes: </b> Name public static method class, checks name validation. Player names and new players are amended through the main controller in MainActivity. <br>
<b>Platform specific control: </b> Validation error messages. Toast message. Actionbar, no menu options used here in order to force the user into entering correct credentials before being able to play. <br>
<b>Decisions: </b> 
* Position of the play button -> at strategic right-hand thumb position.
* Position of the play button -> just above the Toast message in order not to block this button.
* Hint used in order to make it clear to the user what kind of input is expected in the enter name textedits.
* Hint used instead of already pre-inputted text, as used at first. Less user friendly -> User needs to delete by backspace to change the semi-hint.
* Dropdown used in order to be able to choose previous players.
* Chose to give the option to change the name of a previous player directly after selecting from the dropdown. In this way you do recollect your points, but can directly amend your player name.
* Name validation added. This prevents double names in storage, as well as too short or too long names. (Minimum 2 characters, maximum 20 characters). This to protect SharedPrefereneces from overflowing as well.
* Toast message implemented when the players want to play under the exact same names.
* NOTE: Couldn't get the dropdown down-arrow icon to work, I know it doesn't look like a dropdown at the moment. 
* NOTE: I'm aware of a little bug in the dropdown -> It does not change the textview when the first option of the dropdown is selected. Only once first a second option is selected and than the first option. 
* NOTE: I would have included a mutually exclusivity in both spinners in player name choice, due to a lack of time this was not implemented. <br><br>

<img src="/doc/Gameplay1.png" width="400">
<img src="/doc/Gameplay2.png" width="400">
<img src="/doc/Menu1.png" width="400">
<img src="/doc/Language.png" width="400">
<img src="/doc/Language2.png" width="400">

<h5><b>Screen 2: Gameplay</b></h5>
<b>Controller: </b> MainActivity <br>
<b>Layout: </b> activity_main <br>
<b>Model classes involved: </b> Player, Game, CurrentInput, Dictionary. Controls all model classes as main gameplay controller.<br>
<b>Platform specific control: </b>Toast messages. Actionbar menu options. Dialog pop-up overlay.<br>
<b>Decisions: </b> 
* Choice for a neutral, soft, but not totally blank background color.
* Choice for Starting of a game with GHOST as set input, in order to make clear that text is shown in that field. As opposed to showing a blank field.
* Most important information to know during gameplay is: "Who's turn is it?" and the current word fragment. Hence those two elements are placed on top of the screen. The name of the player who needs to make a move is red, to make it absolutely clear who needs to play.
* There is a one second (with computing a few seconds) relay built in after a win, as to give the players a chance to check the correct word or the incorrect word fragment that has been entered.
* As described above, there was a specific choice made to enhance gamplay, not to break the game's flow by showing two screens after each win. A win is not THAT exceptional in this game and the interval is on average only 20 seconds or less.
* I've chosen for a custom on-screen, non-android keyboard, in order not having to handle validation every move. But more importantly, the players are shown all possible keys at once (choices). No unnecessary keys are shown, this enhances gameplay. Also, the buttons are bigger than a regular android keyboard, which enhances quickness of input as well.
* I chose not to show the reason of winning, but rather who won and how the extra points affects his total score. I believe this enhances competitivty between two players. Also, it gives an extra drive to keep on playing directly, as opposed to being forced to skip through two screens after each win.
* NOTE: Unfortunately I've had some troubles setting up the correct layout of the custom keyboard. I would have liked 5 columns, so that the win Toast message would not have overlayed the keyboard. 
* MENU OPTIONS: 
- Restart -> New game is created. Directly clears current word fragment, does not appoint a point to any player. Random player is given the next turn.
- Players -> Change current players' names, or current players altogether, or a combination of those options. 
- Language -> Change the dictionary language of the game. A simple overlay dialog was chosen, since there are onyl two options. No need to go to an entirely new screen. This seemed to me like a neat, quick, and clear way of letting the players chose the dictionary language. A toast message is shown after a language is selected in order to confirm the current language.
- Highscores -> Check out highscores.

<img src="/doc/ChangePlayers1.png" width="400">

<h5><b>Screen 3: Change Players</b></h5>
<b>Controller: </b> ChangePlayersActivity <br>
<b>Layout: </b> activity_change_players <br>
<b>Model classes involved: </b> See Screen 1.<br>
<b>Platform specific control: </b>See Screen 1.<br>
<b>Decisions: </b> 
* See Screen 1.
* Decided to label the name textfield option: "Change name of player n" instead of "Enter name of player n" in the Welcome Screen. This is because the users are already playing and have already entered a name. The players are there to change names or players altogether, not to enter a name.

<img src="/doc/Highscores.png" width="400">

<h5><b>Screen 4: Highscores</b></h5>
<b>Controller: </b> HighScoresActivity <br>
<b>Layout: </b> activity_high_scores <br>
<b>Model classes involved: </b> No model classes directly involved here.<br>
<b>Platform specific control: </b> Users have use the "back-button" on their android device in order to go back to the game. The design choice here was to utilize platform specific controls, and to simplify. No back button needed.<br>
<b>Decisions: </b> 
* NOTE: Extremely basic view of highscores due to lack of time.
* NOTE: No sorting, due to lack of time. Would have probably casted the HashMap values to a TreeMap in order to be able to sort.
* NOTE: Tried for a really really long time to get an adapter to work for these keys and values in a HashMap. Couldn't figure out how, chose to keep it simple and functional in the end. It does show all players and scores.

<h4><b>Model classes</b></h4><br>
* NOTE: I now get the difference between PUBLIC and PRIVATE classes and methods, however I see that I haven't changed them. To be sure I started writing all as PUBLIC. 

<h5><b>CurrentInput</b></h5> -> Saves a string and it's size. Functions: addLetter, get, clear and getSize. <br>
- addLetter -> adds a letter to the current word fragment. Updates textview and increases currentInput size by 1.
- get -> returns the current wordfragment.
- clear -> Clears the wordfragment, sets the size to zero and clears the textview.
- getSize -> Returns the size of the current wordfragment.

<h5><b>Dictionary</b></h5> -> Contains a HashSet of words (strings), as with a real dictionary. Only one method: getWords -> returns a HashSet of Dictionary words of that Dictionary. <br>

<h5><b>Game</h5></b> -> As in a real game, every game instance contains two players, keeps track of who's turn it is and updates the textviews accordingly. 
- getTurn -> Returns the Player who's turn it is in that instance and in that moment of a game.
- changeTurn -> Switches the turn to the opponent and updates the Textview accordingly.
- ptToOpponent -> Changes the turn and adds a point to the opposing Player in that game. 
- updateTVTurn -> Updates the textview of who's turn it is, by setting it to the player's who's turn it is at that moment in that instance of a game.
- changePlayers -> Takes two arguments: two players. Everytime the players playing in the current game instance are changed, this function is called to update the currently playing players in that game. It als saves these new or appended Players to SharedPreferences for savekeeping through the method saveToHighScores, belonging to the Player model class.

<h5><b>Player</h5></b> -> As with a real Player, each instance of a Player has a name (String) and keeps track of how many points (int) he or she has earned. The following methods can be called upon a Player: 
- reLoad -> Takes two arguments: a name (String) and the points (int) it has to appoint to a player. It gives a player instance the name and points values it takes in as arguments. This method is used in order to reload players back from memory (SharedPreferences).
- getName -> returns the current name of that instance of a Player.
- setName -> Takes one argument: a new name. Sets the name of a Player to the new name.
- givePoint -> Gives a point to that instance of a player.
- getPoints -> Returns points for that instance of a player.
- saveToHighscores -> Saves the Player and his/her points to SharedPreferences for permanent storage.
