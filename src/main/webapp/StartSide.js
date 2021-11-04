function fecthcall(from, to) {
    let fra = from;
    let til = to;
    fetch("http://localhost:8080/IT3_Delopgave_2_war/data/liste/listeSQL?" + new URLSearchParams({
        from: fra,
        to: til,
    }))
        .then(resp => resp.json()).then(data => udfyldskema(data))
}

function udfyldskema(data) {
    let time = "";
    let name = "";
    let cpr = "";
    let container = "";
    let note = "";
    console.log("Hello");

    for (let i = 0; i < data.length; i++) {
        time = data[i].timestart.substring(11, 16);
        name = (data[i].name + " ");
        cpr = "CPR: " + data[i].cpr;
        note = "Notat: " + data[i].note;


        let tider = '<span class="autotider">' + time + '</span>'
        let navne = '<span class="autoname">' + name + cpr + '</span>';
        let notat = '<span class="autonote">' + note + '</span><hr>';

        container += tider + navne + notat;
    }

    document.getElementById("autotider").innerHTML = container;
}

//Kalendar
const months = [
    "Januar",
    "Febuar",
    "Marts",
    "April",
    "Maj",
    "Juni",
    "Juli",
    "August",
    "September",
    "Oktober",
    "November",
    "December",
];
let fromfrom = "";
let tiltil = "";

function makecalender(date) {
    let mymonth = months[date.getMonth()];
    const dates = document.querySelector(".dates");
    const lastdates = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

    document.getElementById("actualmonth").innerText = mymonth;

    const firstdayindex = date.getDay() - 1;

    const prevlastdates = new Date(date.getFullYear(), date.getMonth(), 0).getDate()
    const nextdayindex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();
    const nextdays = 7 - nextdayindex;

    let year = date.getFullYear();
    let month = date.getMonth() + 1;

    let days = "";

    for (let x = firstdayindex; x > 0; x--) {
        days += `<div class="lastdates"  onclick="setdates(${year},${month - 1},${x})">${prevlastdates - x + 1}</div>`;
    }

    for (let z = 1; z <= lastdates; z++) {

        days += `<div onclick="setdates(${year},${month},${z})">${z}</div>`;

    }
    for (let y = 1; y <= nextdays; y++) {
        days += `<div class="nextdates" onclick="setdates(${year},${month + 1},${y})">${y}</div>`;
        dates.innerHTML = days;
    }
}

let date = new Date();
makecalender(date);

function nextdate() {
    date.setMonth(date.getMonth() + 1);
    makecalender(date);
}

function prevdate() {
    date.setMonth(date.getMonth() - 1);
    makecalender(date);
}

let i = 0;

function setdates(year, month, day) {
    fromfrom = (year + "-" + month + "-" + day);
    tiltil = (year + "-" + month + "-" + (day + 1));
    document.getElementById("autotiderbar").innerText = "Den  " + day + "/" + month;
    if (i === 0) {
        fecthcall(fromfrom, tiltil);
        setInterval(function () {
            refresh()
        }, 10000);
        i++;
    } else {
        fecthcall(fromfrom, tiltil);
    }
}

//Pop-up journal

function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
    let frm = document.getElementsByClassName("form-container")[0];
    frm.reset();
}

function submitForm() {
    document.getElementById("myForm").style.display = "none";
    let frm = document.getElementsByClassName("form-container")[0];
    document.getElementById("datetime").res
    frm.submit();
    frm.reset();
}

function noWeekend() {
    let datetime = document.getElementById('datetime');

    let day = new Date(datetime.value);
    let endDay = new Date(datetime.value);
    if (day.getDay() === 6 || day.getDay() === 0) {
        alert('Weekends not allowed');
        day.setDate(0)
        datetime.value = "";
    }

    let time = day.getMinutes();

    if (time <= 8) {
        day.setMinutes(0);

        endDay.setMinutes(15);
    }
    if (time > 8 && time <= 23) {
        day.setMinutes(15);

        endDay.setMinutes(30);
    }
    if (time > 23 && time <= 38) {
        day.setMinutes(30);

        endDay.setMinutes(45);
    }
    if (time > 38 && time <= 53) {
        day.setMinutes(45);

        endDay.setMinutes(0);
        endDay.setHours(endDay.getHours() + 1);
    }
    if (time >= 53) {
        day.setMinutes(0);
        day.setHours(day.getHours() + 1);

        endDay.setMinutes(15);
        endDay.setHours(endDay.getHours() + 1);
    }

    let start = document.getElementById('timeStart');
    let end = document.getElementById('timeEnd')
    let timefree = document.getElementById("timefree")
    start.value = (day.getFullYear() + "-" + (day.getMonth() + 1) + "-" + day.getUTCDate() + " " + day.getHours() + ":" + day.getMinutes());
    end.value = (endDay.getFullYear() + "-" + (endDay.getMonth() + 1) + "-" + endDay.getUTCDate() + " " + endDay.getHours() + ":" + endDay.getMinutes());
    timefree.value = (day.getHours() + ":" + day.getMinutes() + " til " + endDay.getHours() + ":" + endDay.getMinutes() + "    d." + day.getFullYear() + "-" + (day.getMonth() + 1) + "-" + day.getUTCDate())
}

window.onload = function () {
    showTime()
}
var timeApi = 'http://worldtimeapi.org/api/timezone/Europe/Copenhagen';


function showTime() {
    var date = new Date();
    var time = date.getHours();
    var minut = date.getMinutes();
    //  var sekunder = date.getSeconds(); //Hvis vi skal have sekunder med

    document.getElementById("MyClockDisplay").innerText = "kl. " + time + ":" + minut; // +":"+sekunder;
    document.getElementById("MyClockDisplay").textContent = "kl. " + time + ":" + minut; //+":"+sekunder;

    setTimeout(showTime, 10000,); //Tiden kan ændres, hvis vi er begrænset på processernes kapicitet
}

function refresh() {
    fecthcall(fromfrom,tiltil)
}



