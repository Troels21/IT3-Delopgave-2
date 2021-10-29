
//Kalendar

const date = new Date();
date.setMonth(8)
const months= [
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
const lastdates = new Date(date.getFullYear(),date.getMonth()+1,0).getDate();

document.getElementById("actualmonth").innerText =mymonth;

const firstdayindex = date.getDay()-1;

const prevlastdates = new Date(date.getFullYear(),date.getMonth(),0).getDate()
const nextdayindex = new Date(date.getFullYear(),date.getMonth()+1,0).getDay();
const nextdays = 7-nextdayindex;

let days="";

for(let x=firstdayindex; x>0; x--){
 days+=`<div class="lastdates">${prevlastdates-x+1}</div>`;
}

for(let z=1;z<=lastdates;z++){
 days+= `<div>${z}</div>`;

}
for(let y=1; y<=nextdays; y++){
 days+=`<div class="nextdates">${y}</div>`;
 dates.innerHTML=days;
}



//Pop-up journal

 function openForm() {
  document.getElementById("myForm").style.display = "block";
 }

 function closeForm() {
  document.getElementById("myForm").style.display = "none";
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

  start.value = (day.getFullYear() + "-" + day.getMonth() + "-" + day.getDay() + " " + day.getHours() + ":" + day.getMinutes());
  end.value = (endDay.getFullYear() + "-" + endDay.getMonth() + "-" + endDay.getDay() + " " + endDay.getHours() + ":" + endDay.getMinutes());
 }
