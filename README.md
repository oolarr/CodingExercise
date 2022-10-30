## Task Overview
The purpose of this task is to demonstrate how to classify a list of objects based on a common field.
In this exercise, I sorted through a list of transactions based on the catgory that has been assigned to that transaction, for example  if a transaction has been assigned leisure, or grocery - to sort and aggregate all transactions that has that category in common.

## Technology used
I wrote the solution to this exercise in Java using Java 8 Streams API features. There are two approaches, one was to sort in state and return a hashmap with the category as key and the value as either a Transaction object or a Double depending on the output preferred.

The other approach returns a List, Optional, or a double but is more specific as the user has to submit certain parameters which returns a more specific value.

## Challenges encountered
For the question - return monthly average spend in a given category.
I wanted to return a value of Map\<String, Map\<String, Double\>\> with the first string being month values and the inner map containing category and average spend, but had to go with Map\<Object, Double\>\> due to time. I am working on how to achieve this.

## Conclusion
Overall, this was a fun challenge, I enjoyed completing it and gained a gained a deeper understanding of how the Streams API and functional programming works in Java.



