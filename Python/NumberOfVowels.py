# The following code will help us to determine the number of vowels in a string.

word = input("Enter your word: ")
i = 0
count = 0
k = len(word)
while(i<k):
    if(word[i] == "A") or (word[i] == "a") or( word[i] == "E") or (word[i] == "e") or (word[i] == "I") or (word[i] == "i") or (word[i]=="O") or (word[i] == "o") or (word[i] == "U") or (word[i] == "u"):
        count = count+1
    i=i+1
print("Total number of vowels in the word " + word + " is: " + str(count))
