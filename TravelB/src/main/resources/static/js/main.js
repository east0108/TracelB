(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();


    // Initiate the wowjs
    new WOW().init();


    // Sticky Navbar
    $(window).scroll(function () {
        if ($(this).scrollTop() > 45) {
            $('.navbar').addClass('sticky-top shadow-sm');
        } else {
            $('.navbar').removeClass('sticky-top shadow-sm');
        }
    });


    // Dropdown on mouse hover
    const $dropdown = $(".dropdown");
    const $dropdownToggle = $(".dropdown-toggle");
    const $dropdownMenu = $(".dropdown-menu");
    const showClass = "show";

    $(window).on("load resize", function () {
        if (this.matchMedia("(min-width: 992px)").matches) {
            $dropdown.hover(
                function () {
                    const $this = $(this);
                    $this.addClass(showClass);
                    $this.find($dropdownToggle).attr("aria-expanded", "true");
                    $this.find($dropdownMenu).addClass(showClass);
                },
                function () {
                    const $this = $(this);
                    $this.removeClass(showClass);
                    $this.find($dropdownToggle).attr("aria-expanded", "false");
                    $this.find($dropdownMenu).removeClass(showClass);
                }
            );
        } else {
            $dropdown.off("mouseenter mouseleave");
        }
    });


    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
        return false;
    });


    // Testimonials carousel
    $(".testimonial-carousel").owlCarousel({
        autoplay: true,
        smartSpeed: 1000,
        center: true,
        margin: 24,
        dots: true,
        loop: true,
        nav: false,
        responsive: {
            0: {
                items: 1
            },
            768: {
                items: 2
            },
            992: {
                items: 3
            }
        }
    });

})(jQuery);

//註冊帳號
function register() {
    // Form fields, see IDs above
    const params = {
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    }

    const http = new XMLHttpRequest();
    http.withCredentials = true;
    http.open('POST', 'http://localhost:8080/travel/register', true);//'https://cors-anywhere.herokuapp.com/'+
    http.setRequestHeader("Content-Type", "application/json");
    http.send(JSON.stringify(params));// Make sure to stringify //JSON.stringify(params)
    http.onreadystatechange = function () {
        if (http.status >= 200 && http.status < 400) {
           
                document.location.href = "http://localhost:8080/travel/index";
            
        }
    }
};

//更新會員


//登入帳號
function login() {
    // Form fields, see IDs above
    const params = {
        email: document.getElementById('email').value,
        password: document.getElementById('password').value
    }

    const http = new XMLHttpRequest();
    http.withCredentials = true;
    http.open('POST', 'http://localhost:8080/travel/login', true);//'https://cors-anywhere.herokuapp.com/'+
    http.setRequestHeader("Content-Type", "application/json");
    http.send(JSON.stringify(params));// Make sure to stringify //JSON.stringify(params)
    http.onreadystatechange = function () {
        if (http.status >= 200 && http.status < 400) {
           
                document.location.href = "http://localhost:8080/travel/index";
            
        }
    }
};

//檢查註冊郵件
const buttonElement = document.getElementById('email');

if (document.getElementById('email').value != null) {
    buttonElement.addEventListener('click', function () {
        const params = {
            email: document.getElementById('email').value
        }
        var xml = new XMLHttpRequest();
        xml.withCredentials = true;
        xml.open('POST', 'http://localhost:8080/travel/members/checkEmail', true);
        xml.onreadystatechange = function () {

            if (xml.status >= 200 && xml.status < 400) {
                console.log(document.getElementById('email').value);
                document.getElementById("text").innerHTML = "尚未註冊";
            };
            if (xml.status >= 400) {
                console.log("XX");
                document.getElementById("text").innerHTML = "已註冊";
            }
        };
        xml.setRequestHeader("Content-Type", "application/json");
        xml.send(JSON.stringify(params));
    });
};


$(() => {
    $(".background-gray").on("click", function() {
        $(".active").removeClass("active");
    });

    $(".mobile-menu").on("click", function() {
        $(".background-gray").addClass("active");
        $(".mobile-menu-content").addClass("active");
    });
})



