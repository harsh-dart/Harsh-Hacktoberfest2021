//Anagram is a word or phrase that is made by
//arranging the letters of another word or phrase in a different order

let firstItem = "Mary";
let secondItem = "Army";

function checkAnagram(i, j) {
  let one = i.toLowerCase();
  let two = j.toLowerCase();
  const itemOne = one.split("").sort().join("");
  const itemTwo = two.split("").sort().join("");

  return itemOne === itemTwo;
}

console.log(checkAnagram(firstItem, secondItem));
