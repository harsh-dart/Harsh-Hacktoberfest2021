//classic fizzBuzz Problem done using js

function fizzBuzz(limit) {
  for (let i = 1; i <= limit; i++) {
    if (i % 3 === 0 && i % 5 === 0) {
      console.log("FizzBuzz");
      continue;
    } else if (i % 3 === 0) {
      console.log("FIzz");
      continue;
    } else if (i % 5 === 0) {
      console.log("Buzz");
      continue;
    }
    console.log(i);
  }
}

fizzBuzz(15);
