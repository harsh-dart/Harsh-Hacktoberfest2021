const msg =document.querySelector('.msg');
const guess = document.querySelector('input');
const btn = document.querySelector('.btn');
let play= false;
let newWords="";
let randWords = "";
let sWords = ['Cow','education','tree','question','space','sky','terminal'];

function createNewWords () {
    let ranNum = Math.floor(Math.random() * sWords.length);
    let newTempSwords = sWords[ranNum];
    return newTempSwords;
}


function scrambleWords (arr){
    for( let i = arr.length-1; i>0; i--)
    {
        let temp = arr[i];
        let j = Math.floor(Math.random()*(i+1));
        arr[i] = arr[j];
        arr[j] = temp;

    }
    return arr;
}


btn.addEventListener('click', function()
{
   
    if(!play)
    {
        play=true;
        btn.innerHTML="Guess";
        guess.classList.toggle('hidden');
        newWords = createNewWords();
        randWords = scrambleWords(newWords.split("")).join("");
        msg.innerHTML =`Guess the word: ${randWords}`;
    }
    else{
        
        let tempWord =guess.value;
        if(tempWord === newWords){
            play= false;
            msg.innerHTML = `Awesome It's correct. It is ${newWords}`;
            btn.innerHTML ="Play Again";
            guess.classList.toggle('hidden');
            guess.value ="";
        }
        else{
            msg.innerHTML = `Sorry, It's not correct. Please try again ${randWords}`;
        }
    }
})