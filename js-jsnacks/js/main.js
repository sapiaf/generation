// Crea una funzione chiamata sommaNumeri che prenda un array di N numeri e calcoli la somma di tutti questi numeri contenuti nell'array, restituendolo come risultato.
// Utilizzare la funzione sommaNumeri per stampare il risultato. L'array di N numeri da passare alla funzione lo create chiedendo all'utente quanti numeri vuole inserire (cioè N), 
// e poi facendogli inserire questi N numeri all'utente stesso tramite apposito prompt().

const sceltaUtente = +prompt("Quanti numeri vuoi inserire nell' array?")
const arrayUtente = creazioneArrayUtente(sceltaUtente)
const somma = sommaNumeri(arrayUtente)
const media = mediaAritmetica(arrayUtente)


function creazioneArrayUtente(num) {
    const arr = []
    for (let i = 0; i < num; i++) {
        const userNum = +prompt('Scegli un numero...')
        arr.push(userNum)
    }
    return arr
}


function sommaNumeri(arr) {
    let somma = 0;
    for (let i = 0; i < arr.length; i++) {
        const numero = arr[i]
        somma += numero
    }
    return somma
}

// Crea una funzione chiamata mediaAritmetica che prende in input un array di N numeri e restituisca la media aritmetica dei numeri contenuti nell'array.
// Utilizzare la funzione sommaNumeri precedentemente creata per calcolare la media dei numeri che vanno chiesti all'utente attraverso dei prompt.
// Potete ad esempio provare ad usare questo programma per inserire N voti di scuola e farvi restituire qual è la media di tutti i voti inseriti!

function mediaAritmetica(arr) {
    const somma = sommaNumeri(arr)
    const media = somma / arr.length
    return media
}

console.log(`
---- MEDIA MATEMATICA ----
--------------------------
La tua array: ${arrayUtente}
Somma numeri array: ${somma}
Media numeri: ${media}
--------------------------
`)
