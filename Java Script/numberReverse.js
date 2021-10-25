  function getReverseNumber(num){
if(num<0)
    return -1*parseInt(num.toString().split("").reverse().join(""));
 return parseInt(num.toString().split("").reverse().join(""));
    }


//call the function
    console.log(getReverseNumber(-300));



