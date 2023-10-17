/* L' esercizio di oggi: calcolo del prezzo del biglietto del treno
cartella/repo: js-biglietto-treno
Il programma dovrà chiedere all'utente il numero di chilometri che vuole percorrere e l'età del passeggero (con i prompt() in questo caso).
Sulla base di queste informazioni dovrà calcolare il prezzo totale del viaggio, secondo queste regole:
il prezzo del biglietto è definito in base ai km (0.21 € al km)
va applicato uno sconto del 20% per i minorenni
va applicato uno sconto del 40% per gli over 65.
L'output del prezzo finale va messo fuori in forma umana (con massimo due decimali, per indicare centesimi sul prezzo e questo richiederà un minimo di ricerca.).
Il risultato andrà visualizzato prima in console e poi possibilmente in un apposito elemento <p> del mio codice HTML.
BONUS:
Il programma dovrà mostrare una form da compilare con cui chiedere all'utente il numero di chilometri che vuole percorrere e l'età del passeggero. Sulla base di queste informazioni dovrà calcolare il prezzo totale del viaggio.
Il recap dei dati e l'output del prezzo finale va stampato in pagina.
Potete prendere spunto dal layout in allegato, oppure farvi il vostro biglietto del treno personalizzato! */


const departureStationInput = document.getElementById('departure-station');
const destinationStationInput = document.getElementById('destination-station');
const kmToGoInput = document.getElementById('km-to-go');
const buyButton = document.querySelector('.btn-buy')
const firstNameInput = document.getElementById('first-name')
const lastNameInput = document.getElementById('last-name')
const cancelButton = document.querySelector('.btn-cancel')
const birthDayInput = document.getElementById('birth-day')
const birthMonthInput = document.getElementById('birth-month')
const birthYearInput = document.getElementById('birth-year')
const ageSelctor = document.getElementById('age-selector')

const ticketName = document.getElementById('ticket-name')
const ticketSeat = document.getElementById('ticket-seat')
const ticketPrice = document.getElementById('ticket-price')
const ticketDeparture = document.getElementById('ticket-departure')
const ticketDestination = document.getElementById('ticket-destination')
const ticketCarriage = document.getElementById('ticket-carriage')
const ticketTypeInput = document.getElementById('ticket-type')
const ticketModal = document.querySelector('.ticket-modal');


buyButton.addEventListener('click', generateTicket)

function generateTicket(event) {
    event.preventDefault()


    // Get passenger name
    const firstName = firstNameInput.value
    const lastName = lastNameInput.value

    // Get Number of km
    const numberOfKm = kmToGoInput.value

    // Calculate gross price
    const grossPrice = 0.21 * numberOfKm

    // Calculate net price and ticket type
    let netPrice = 0
    let ticketType = ''

    if (ageSelctor.value === 'underage') {
        netPrice = grossPrice * 0.8
        ticketType = 'Student Ticket'
    } else if (ageSelctor.value === 'adult') {
        netPrice = grossPrice
        ticketType = 'Standard Ticket'
    } else {
        netPrice = grossPrice * 0.6
        ticketType = 'Senior Ticket'
    }

    // Random train carriage
    const carriageNum = Math.floor(Math.random() * 5) + 1
    const carriageLetters = ['A', 'B', 'C', 'D', 'E'];
    const carriageLetter = carriageLetters[carriageNum - 1];

    // Random seat number
    const carriageSeatNum = Math.floor(Math.random() * 90) + 1
    const trainSeat = carriageSeatNum + carriageLetter

    // Add info to the ticket
    ticketName.textContent = `${firstName} ${lastName}`
    ticketSeat.textContent = `${trainSeat}`
    ticketPrice.textContent = `$ ${netPrice.toFixed(2)}`
    ticketDeparture.textContent = `${departureStationInput.value}`
    ticketDestination.textContent = `${destinationStationInput.value}`
    ticketCarriage.textContent = `${carriageNum}`
    ticketTypeInput.textContent = `${ticketType}`

    ticketModal.classList.add('show');

}



// Calculate number of kilometers
destinationStationInput.addEventListener('blur', calculateKilometers);

function calculateKilometers() {
    const departureStation = departureStationInput.value;
    const destinationStation = destinationStationInput.value;

    if (departureStation && destinationStation && !destinationStationInput.matches(':focus')) {
        const randomNumofKm = Math.floor(Math.random() * 991) + 10;
        kmToGoInput.value = randomNumofKm;
    }
}

// Calculate date of birth and verify if the passenger is adult, underage or over 65
birthYearInput.addEventListener('blur', calculateAge)

function calculateAge() {
    const birthDay = +birthDayInput.value
    const birthMonth = +birthMonthInput.value
    const birthYear = +birthYearInput.value

    const currentDate = new Date()
    const birthDate = new Date(`${birthYear}-${birthMonth}-${birthDay}`)

    const age = (currentDate.getFullYear() - birthDate.getFullYear()) - 1

    if (age < 18) {
        ageSelctor.value = 'underage'
    } else if (age < 65) {
        ageSelctor.value = 'adult'
    } else {
        ageSelctor.value = 'over-65'
    }

}

// Cancel button
cancelButton.addEventListener('click', function () {
    const inputs = [firstNameInput, lastNameInput, birthDayInput, birthMonthInput, birthYearInput, departureStationInput, destinationStationInput, kmToGoInput]

    inputs.forEach(input => {
        input.value = ''
    });

    ageSelctor.value = 'empty-option'

})

// Remove ticket modal
ticketModal.addEventListener('click', (event) => {

    if (!event.target.closest('.ticket')) {
        ticketModal.classList.remove('show')
    }
})
