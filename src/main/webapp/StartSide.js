function fecthcall(fra, til) {
    fetch("http://localhost:8080/IT3_Delopgave_2_war/data/liste/listeSQL?" + new URLSearchParams({
        from: fra,
        to: til,
    }))
        .then(resp => resp.json()).then(data => udfyldskema(data))
}

function udfyldskema(data) {
    console.log(JSON.stringify(data));
    let myobj = JSON.parse(data);
    let autotider = document.getElementsByClassName("autotidersted");
    for (let i = 0; i <= data.length; i++) {
        let time = myobj[i].timestart;
        let name = myobj[i].name;
        let cpr = myobj[i].cpr;

        var tider = document.createElement('div');
        tider.innerText = time;

        var navne = document.createElement('div');
        navne.innerText = name + "      " + cpr;

        autotider.appendChild(tider, navne);
    }
}

//Kalendar


const date = new Date();
date.setMonth(8)
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
let mymonth = months[date.getMonth()];
const dates = document.querySelector(".dates");
const lastdates = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();

document.getElementById("actualmonth").innerText = mymonth;

const firstdayindex = date.getDay() - 1;

const prevlastdates = new Date(date.getFullYear(), date.getMonth(), 0).getDate()
const nextdayindex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();
const nextdays = 7 - nextdayindex;

let days = "";

for (let x = firstdayindex; x > 0; x--) {
    days += `<div class="lastdates">${prevlastdates - x + 1}</div>`;
}

for (let z = 1; z <= lastdates; z++) {
    days += `<div>${z}</div>`;

}
for (let y = 1; y <= nextdays; y++) {
    days += `<div class="nextdates">${y}</div>`;
    dates.innerHTML = days;
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
    start.value = (day.getFullYear() + "-" + (day.getMonth() + 1) + "-" + day.getDay() + " " + day.getHours() + ":" + day.getMinutes());
    end.value = (endDay.getFullYear() + "-" + (endDay.getMonth() + 1) + "-" + endDay.getDay() + " " + endDay.getHours() + ":" + endDay.getMinutes());
    timefree.value = (day.getHours() + ":" + day.getMinutes() + " til " + endDay.getHours() + ":" + endDay.getMinutes() + "    d." + day.getFullYear() + "-" + (day.getMonth() + 1) + "-" + day.getDay())
}
