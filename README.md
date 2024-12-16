# Softvoper Idle Game
This is a simple Idle Game where you try to gain SCoins (Softvoper Coin) as much as possible by coding and hiring some developers and developing some software projects.

## MongoDB
Game progresses are nested objects. It has 2 to 3 more objects in  it. So storing game progresses might be hard using SQL databases due to its complex structure.

MongoDB is document based NoSQL database application. So it is able to store complex data without too much effort. 

For that reason we choose MongoDB to save game progresses in this game. 

## Spring Framework
We needed a framework to develop an API while it is easy to use and learn.

Spring is a framework to develop apps for Java.
We developed an API to deal with store, delete, update or receive game progresses using Spring.

## How to Run 
Firstly MongoDB must be installed to run this game. You can easily install it from [MongoDB's website](https://www.mongodb.com/try/download/community).

To run the game there are 2 project to run. API project should be ran first. Here are the steps. 

1. Install all documents.
2. Open your terminal and go to directory where IdleGame_API is located by using `cd` command.
```markdown
    cd path/of/the/IdleGame_API
```
3. Use `mvn compile` command to compile the project.
```markdown
    mvn compile
```
4. Then use this command to run the API.
```markdown
    mvn exec:java -Dexec.mainClass="com.Softvoper.Softvoper.SoftvoperApplication"
```
5. Now open a new terminal and go to directory where src folder in Idle-Game is located. 
```markdown
    cd path/of/the/Idle-Game/src
```
6. To compile the project run this command.
```markdown
    javac Main.java
```
7. And finally use this command to run the game.
```markdown
    java Main
```
## How to Play



  