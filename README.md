# Fallout 76 Launch Code Cracker
Simple program for cracking the launch codes to Fallout 76's nuclear silos.

## How to use it
Simply enter the letters in the order they appear from top to bottom in the top boxes labelled Letters.
Put the numbers of each associated letter in the boxes labelled Numbers.  

Enter a pattern into the Keyword Pattern text field. Note: It uses normal regex constructs, e.g. ....n.... will
find all nine letter words with an 'n' at the 5th position. If the keyword is designatory, and you only
have the 'n' and 'o', you would then enter .....n..o.. into the field, so every unknown character in the
keyword is replaced with a period.

Hit the Crack button and wait until the text area labelled Launch Code Solutions is populated. Note: 
This may take a good amount of time depending on how many letters have been revealed in the bunker.

## Limitations
This is very early stages and I've only spent a day or two working on it, so expect it to be slow on 
less letter filled patterns. So far in testing, it'll crunch all the codes with a single letter pattern,
but it is a hungry beast and I've seen it eat 3GB of memory.

## F.A.Q.

### What does it do?
Takes in the keyword or partial keyword, the silo codes (you need all 8), and then gives a potential 
launch code. More letters in the keyword means a greater chance of success, but this program will brute
force codes for a keyword even with one letter.

### Why is it so ugly?
I'm a programmer, not a UI/UX designer.

### Why a Java/Desktop app and not a webapp
Simple, no hosting fees and none of that telemetry/tracking bullshit. There's nothing in this app to 
steal data or track what you're doing.

### Releases
For those of you that just want to run, there's a Runnable JAR and a JAR wrapped in an EXE with JRE 
included on the releases page.  
For everyone else, download the source here and compile.

### It's broken / Didn't do anything / Got an error
It's not perfect, and I whipped it up in a few hours, so expect issues and other spectacular things.
If it did one of these things, report an issue using the template below.

### Report an issue template
Just copy and paste this into the github issue dialog.

\# [Summary/Title]  
\* [description of the issue]  
\* [the silo codes and pattern you were using]  
\* [error if any]  
\* [specs of your machine]  
\* [OS]  
\* [Java version]  
