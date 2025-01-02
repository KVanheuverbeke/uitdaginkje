# Six Letter Words API

Hereby a file, input.txt, that contains words of varying lengths (1 to 6 characters).

Your objective is to show all combinations of those words that together form a word of 6 characters. That combination
must also be present in input.txt  
E.g.:

``` 
foobar  
fo  
obar
```

should result in the output:

```
fo+obar=foobar
```

You can start by only supporting combinations of two words and improve the algorithm at the end of the exercise to
support any combinations.
Treat this exercise as if you were writing production code; think unit tests, SOLID, clean code and architectural
healthy design.
Be mindful of changing requirements like a different maximum combination length, or a different source of the input
data.

The solution is best stored in a git repo that you communicate to us.
After the repo is cloned, the application should be able to run with one command / script.  
You can create a docker, a runnable jar, a launch script, anything that works. Just include a Readme file that guides us
through the process.

A good extra to do is the create an API that can be called with a request containing a list of words and then returning
the output as described above.
Or to store the result in a database (H2 for instance) to show that you can talk to a database.


to test the application, run it in your IDE and go to
http://localhost:8080/swagger-ui/index.htm

or use postman with uitdaginkje.postman_collection.json
(and select the file on the correct location)

