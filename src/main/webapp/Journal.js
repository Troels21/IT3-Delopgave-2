function noWeekend() {
    let datetime = document.getElementById('datetime');

    let day = new Date(datetime.value);
    if (day.getDay() === 6 || day.getDay() === 0) {
        alert('Weekends not allowed');
        day.setDate(0)
        datetime.value="";
    }/*

    let time =day.getMinutes();
    if (time<8){
        day.setMinutes(0);
    }
    if (time>8 && time<23){
        day.setMinutes(15);
    }
    if (time>23 && time<38){
        day.setMinutes(30);
    }
    if (time>38 && time<53){
        day.setMinutes(45);
    }
    if (time>53){
        day.setMinutes(0);
        day.setHours(day.getHours()+1);
    }

    let s =document.getElementById(timeStart);
    s.value =day.toISOString();*/
}
/*
function rounding(){
    let datetime = document.getElementById('datetime');
    let day = new Date(datetime.value);
    let time =day.getTime();
    if (time<8){
        datetime.value.setMinutes(0);
    }
    if (time>8 && time<23){
        datetime.value.setMinutes(15);
    }
    if (time>23 && time<38){
        datetime.value.setMinutes(30);
    }
    if (time>38 && time<53){
        datetime.value.setMinutes(45);
    }
    if (time>53){
        datetime.value.setMinutes(0);
        datetime.value.setHours(day.getHours()+1);
    }
    alert(datetime.value.getMinutes());
}*/