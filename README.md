# Paddle-game
It is a simple Paddle game (looks like hockey).
The main difference between it and Hockey is that when the goal keeper stops the ball the goal keeper gets a point otherwise the playes gets a point.

<hr>
<h2> Game Functionalities </h2>
<hr>
<ul>
<li> There are 2 players on the same team (left team) and one goal keeper </li>
<li> Each playeer from the 2 players run on a different thread </li>
<li> When a player shoots the ball and it passes the goal keeper the keft team wins a point</li>
<li> When the goal keeper stops the ball then the right team wins a point </li>
<li> After each shoot the thread of the player that shot on the goal keeper sleeps 2000ms </li>
<li> After that all the graphics are updated with the new score and players return to there starting point</li>
<li> The ball is located each time randomly on the center line </li>
<li> The keeper each shot follows the ball to try to stop it </li>
</ul>

All graphics credits goes to Mina Adly
