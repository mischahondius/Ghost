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
<b>Model classes: </b> No Game-specific model classes involved here. Player names and new players are amended through the main controller in MainActivity. <br>
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
* NOTE: I would have included a mutually exclusivity in both spinners in player name choice, due to a lack of time this was not implemented.

a list of model classes, public and private fields, and public methods (and their return types and/or arguments) that you’ve decided to implement

a list of any APIs and frameworks that have not yet been named in the above, along with a description of what these will be used for
