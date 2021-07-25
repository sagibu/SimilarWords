# SimilarWordsApi
This repository contains my implementation of the XXX home exercise for finding word permutations within a word DB.
The REST Api is written in Java 11 using Spring.

## The algorithm
I saved the words file in memory in a hashmap,
where the keys are another hashmap containing the count of each char in the word and the values are a list of all words with the same counts.

For example - for the word if all the permutations of the word `aab` in the DB are (since `aab` should not be part of result):

`baa, aba`

Then the map will have the entry:

`{'a': 2, 'b': 1} : ['aba', 'baa']`

This will result in each query to the DB to take O(1) time.

## Requirements
### Java 11
In linux install using 
`sudo apt-get install openjdk-11-jdk`
### Gradle 7
Install gradle 7 - used to build the project.

## Build
From the main directory run:
`gradle build` - this might take some time to install all the Spring dependencies.

## Run
Run using `gradle run`, note there is some warmup time on startup for converting the words file.

## Using the API
There are two endpoints in the API:
### Similar
Returns a list of permutated words of the query word:
`http://localhost:8000/api/v1/similar?word=ok`

Results in:
`{"similar":["ko","ok"]}`

### Stats
Returns the stats of the rest API:
`http://localhost:8000/api/v1/stats`

Results in:
`{"totalWords":351075,"totalRequests":9,"avgProcessingTimeNs":37520}`
