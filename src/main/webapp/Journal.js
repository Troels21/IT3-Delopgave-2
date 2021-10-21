function noWeekend() {
    let datetime = document.getElementById('datetime');

    let day = new Date(datetime.value);
    let endDay = day;
    if (day.getDay() === 6 || day.getDay() === 0) {
        alert('Weekends not allowed');
        day.setDate(0)
        datetime.value = "";
    }

    let time = day.getMinutes();

    if (time < 8) {
        day.setMinutes(0);

        endDay.setMinutes(15);
    }
    if (time > 8 && time < 23) {
        day.setMinutes(15);

        endDay.setMinutes(30);
    }
    if (time > 23 && time < 38) {
        day.setMinutes(30);

        endDay.setMinutes(45);
    }
    if (time > 38 && time < 53) {
        day.setMinutes(45);

        endDay.setMinutes(0);
        endDay.setHours(endDay.getHours() + 1);
    }
    if (time > 53) {
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
