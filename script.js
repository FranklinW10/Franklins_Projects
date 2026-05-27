// Highlight navigation item while scrolling

$(window).on('scroll', function () {

    let current = "";

    $('section').each(function () {

        const sectionTop = $(this).offset().top - 100;

        if ($(window).scrollTop() >= sectionTop) {
            current = $(this).attr('id');
        }

    });

    $('.main-menu a').removeClass('active');

    $('.main-menu a[href="#' + current + '"]')
        .addClass('active');

});