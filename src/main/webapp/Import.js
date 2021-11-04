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
function fetchfunction(apiurl) {
    fetch(apiurl).then(resp => resp.json()).then(data => displaydata(data));
}

function displaydata(value) {
    document.getElementsByClassName("tekstfelt").innerText = JSON.stringify(value);
}