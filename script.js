// Highlight navigation item while scrolling

$(window).on("scroll", function () {
  let current = "";

  $("section").each(function () {
    const sectionTop = $(this).offset().top - 100;

    if ($(window).scrollTop() >= sectionTop) {
      current = $(this).attr("id");
    }
  });

  $(".main-menu a").removeClass("active");

  $('.main-menu a[href="#' + current + '"]').addClass("active");
});

// Justified project strip: each image grows in proportion to its aspect ratio,
// so every image ends up the same height and nothing is cropped

$(function () {
  $(".project-strip img").each(function () {
    const img = this;

    const setRatio = function () {
      img.style.flexGrow = img.naturalWidth / img.naturalHeight;
    };

    if (img.complete && img.naturalWidth) {
      setRatio();
    } else {
      $(img).on("load", setRatio);
    }
  });
});
