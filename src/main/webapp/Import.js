/*viser dropdown menu*/
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

/* Lukker dropdown menuen */
window.onclick = function (event) {
    if (!event.target.matches('.dropdownbtn')) {
        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}

/* Fetch kald som skal resultere i at xml bliver hentet*/
function fetchfunction(apiurl) {fetch(apiurl).
        then(resp => resp.json()).
                then(data => displaydata(data));
}

function displaydata(data) {
    let string ="";
    let container="";
    for (let i=0 ; i < data.length ; i++) {
        let namecpr = data[i].name+"   ---"+data[i].cpr;
        let time = data[i].timestart+" : "+data[i].timeend;
        let note = data[i].note;


        let tider = '<span class="tider">' + time + '</span><br>'
        let navne = '<span class="name">' + namecpr + '</span><br>';
        let notat = '<span class="note">' + note + '</span><hr>';

        container += navne + tider + notat;
    }
        document.getElementById("tekstfelt").innerHTML=container;
}