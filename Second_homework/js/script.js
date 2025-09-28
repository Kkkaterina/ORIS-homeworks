document.addEventListener('DOMContentLoaded', function() {
    const navbarToggle = document.getElementById('navbar-toggle');
    const navbarMenu = document.getElementById('navbar-menu');

    navbarToggle.addEventListener('click', function() {
        if (navbarMenu.classList.contains('active')){
        navbarMenu.classList.remove('active');
        } else {
        navbarMenu.classList.add('active');
        }
    });
});

const slider = document.getElementById("gallery");
const slideWidth = 234;
function SliderToLeft() {
    gallery.scrollLeft = gallery.scrollLeft - slideWidth;
}
function SliderToRight() {
    gallery.scrollLeft = gallery.scrollLeft + slideWidth;
}

function СheckForm() {
    let name = document.getElementById("name").value.trim();
    let phone = document.getElementById("phone").value.trim();
    let nameError = document.getElementById("nameError");
    let phoneError = document.getElementById("phoneError");

    document.getElementById("name").classList.remove("error");
    document.getElementById("phone").classList.remove("error");

    if (name.length < 2) {
        nameError.textContent = "Имя должно содержать минимум 2 символа";
        document.getElementById("name").classList.add("error");
        hasError = true;
    }

    if (phone.lenght > 12) {
        phoneError.textContent = "Введите номер в формате +7XXXXXXXXXX";
        document.getElementById("phone").classList.add("error");
        hasError = true;
    }
}

function ThemeSwitch() {
    if (document.body.classList.contains("light")) {
        document.body.className = "dark";
        localStorage.setItem("theme", "dark");
    } else {
        document.body.className = "light";
        localStorage.setItem("theme", "light");
    }
}

document.addEventListener('DOMContentLoaded', function () {
    let timeInSeconds = 3600;
    const countdownEl = document.getElementById('countdown');


    countdownEl.textContent = timeInSeconds;

    const timer = setInterval(function () {
        timeInSeconds--;

        if (timeInSeconds <= 0) {
            clearInterval(timer);
            countdownEl.textContent = '0';
                return;
        }

        countdownEl.textContent = timeInSeconds;
    }, 1000);
});

function DynamicLoading() {
    const hiddenCards = document.querySelectorAll('.case-card .card-hidden');
    hiddenCards.forEach(card => {
        card.classList.remove('card-hidden');
    });
  }