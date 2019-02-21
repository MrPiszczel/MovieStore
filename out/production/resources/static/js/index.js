        var all = $('#' + 'all');
        var watchingMovie = $('#' + 'watchingMovie');
        var watchedMovie = $('#' + 'watchedMovie');

        var all2 = $('#' + 'all2');
        var watchingMovie2 = $('#' + 'watchingMovie2');
        var watchedMovie2 = $('#' + 'watchedMovie2');

        var option_s = $(".option_s");

        $('.option').mouseover(function() {
          $(this).find('.option_1').hide();
            $(option_s).find(".option_1").hide();
        })
        .mouseout(function() {
            $(this).find(".option_1").show();
            $(option_s).find(".option_1").show();
        });



        $(all2).mouseover(function(){

            $(this).css("background", "#808080");
            $(watchingMovie2).css("background", "#2f3036");
            $(watchedMovie2).hover().css("background", "#2f3036");
        });

        $(watchingMovie2).mouseover(function(){

            $(all2).css("background", "#2f3036");
            $(this).css("background", "#808080");
            $(watchedMovie2).hover().css("background", "#2f3036");
        });

        $(watchedMovie2).mouseover(function(){

            $(all2).css("background", "#2f3036");
            $(watchingMovie2).css("background", "#2f3036");
            $(this).hover().css("background", "#808080");
        });
